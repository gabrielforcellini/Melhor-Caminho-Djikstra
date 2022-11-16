package io;

import constantes.Pastas;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Escritor {

    public void moveArquivoRota(String arquivo) throws IOException {
        try {
            Files.move(Paths.get(Pastas.FILE_IN_PROJECT + arquivo + ".txt"),
                    Paths.get(Pastas.C_TESTE + arquivo + ".txt"));
        } catch (NoSuchFileException e){
            System.out.println("Arquivo não reconhecido: " + e);
            criarPastasTesteArquivoConfig();
            return;
        }
        System.out.println("Arquivo " + arquivo + " movido");
    }

    public void moveArquivoProcessado(String arquivo) throws IOException {
        try {
            Files.move(Paths.get(Pastas.C_TESTE + arquivo),
                    Paths.get(Pastas.PROCESSADO + arquivo));
        } catch (NoSuchFileException e){
            System.out.println("Arquivo não reconhecido: " + e);
            criarPastasTesteArquivoConfig();
            return;
        }
        System.out.println("Arquivo " + arquivo + " movido para pasta de processados");
    }

    public void moveArquivoNaoProcessado(String arquivo) throws IOException {
        try {
            Files.move(Paths.get(Pastas.C_TESTE + arquivo),
                    Paths.get(Pastas.NAO_PROCESSADO + arquivo));
        } catch (NoSuchFileException e){
            System.out.println("Arquivo não reconhecido: " + e);
            criarPastasTesteArquivoConfig();
            return;
        }
        System.out.println("Arquivo " + arquivo + " movido para pasta não processados");
    }

    public void criarPastasTesteArquivoConfig() {
        // Cria pasta C:/Teste
        File arquivo = new File(Pastas.C_TESTE);
        arquivo.mkdir();
        // Cria pasta C:/Teste/Configuracao
        arquivo = new File(Pastas.C_TESTE_CONFIGURACAO);
        arquivo.mkdir();

        // Cria o arquivo config dentro de C:/Teste/Configuracao
        List<String> linhas = Arrays.asList("Processado=C:\\Teste\\Processado", "Não Processado=C:\\Teste\\NaoProcessado", "Diretorio Raiz=C:\\Teste", "Rota Automatica=False\n");
        Path arquivoConfig = Paths.get(Pastas.C_TESTE_CONFIGURACAO + "config.txt");
        try {
            Files.write(arquivoConfig, linhas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Arquivo de configuração criado, se necessário rode a aplicação novamente");
    }
}
