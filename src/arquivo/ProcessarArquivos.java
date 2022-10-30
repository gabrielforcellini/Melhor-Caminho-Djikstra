package arquivo;

import io.Escritor;
import io.Leitor;
import model.Header;
import model.Pesos;
import model.Trailer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessarArquivos implements Runnable {

    Leitor leitor = new Leitor();
    Escritor escritor = new Escritor();
    List<String> arquivos = new ArrayList<>();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                arquivos = leitor.buscarArquivosProcessar();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            for (String arquivo : arquivos) {
                List<String> linhas = null;
                try {
                    linhas = leitor.lerArquivo(arquivo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Lendo o arquivo: " + arquivo);
                Header header = null;
                Pesos resumoPesos = null;
                Trailer trailer = null;
                int totalNos = 0, totalPesos = 0, somaPesos = 0;
                for (String linha : linhas) {
                    String[] splitLinha = linha.split("");
                    String identificadorLinha = splitLinha[1];
                    switch (identificadorLinha) {
                        case "0":
                            if (linha.length() > 6) {
                                System.out.println("Header inválido");
                                System.exit(1);
                            }
                            header = new Header(splitLinha[2] + splitLinha[3], splitLinha[4] + splitLinha[5]);
                            break;
                        case "1":
                            if (!splitLinha[4].equals("=")) {
                                System.out.println("Resumo de conexoes inválido");
                                System.exit(1);
                            }
                            totalNos++;
                            break;
                        case "2":
                            totalPesos++;
                            resumoPesos = new Pesos(splitLinha[2] + splitLinha[3], splitLinha[5] + splitLinha[6], splitLinha[8]);
                            somaPesos = somaPesos + Integer.parseInt(resumoPesos.getPesoAresta());
                            break;
                        case "9":
                            trailer = new Trailer(splitLinha[2] + splitLinha[3], splitLinha[5] + splitLinha[6]);
                            break;
                    }

                }
                if (Integer.parseInt(header.getQtadeNos()) != totalNos) {
                    System.out.println("Número totais de nós inválido");
                    try {
                        escritor.moveArquivoNaoProcessado(arquivo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (Integer.parseInt(header.getSomaPesos()) != somaPesos) {
                    System.out.println("Soma dos pesos difere (Valor do registro HEADER = " + header.getSomaPesos() + " e Soma dos Pesos = " + somaPesos + ")");
                    try {
                        escritor.moveArquivoNaoProcessado(arquivo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (Integer.parseInt(trailer.getQtdadeConexoes()) != totalNos) {
                    try {
                        escritor.moveArquivoNaoProcessado(arquivo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw new RuntimeException("Numero de linhas de quantidade de conexoes inválidos");
                }

                if (Integer.parseInt(trailer.getQtdadePesos()) != totalPesos) {
                    try {
                        escritor.moveArquivoNaoProcessado(arquivo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw new RuntimeException("Numero de linhas de quantidade de pesos inválidos");
                }
                try {
                    escritor.moveArquivoProcessado(arquivo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
