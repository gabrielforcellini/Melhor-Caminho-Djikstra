package io;

import constantes.Pastas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

    public boolean lerCriarDadosConfig() throws IOException {
        InputStream inputStream = new FileInputStream(Pastas.C_TESTE_CONFIGURACAO + "config.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String linha = bufferedReader.readLine();

        ArrayList<String> listConfiguracoes = new ArrayList<>();
        int contador = 0;

        while(linha != null && !linha.equals("")) {
            try{
                String[] split = linha.split("=");
                listConfiguracoes.add(split[1]);
            } catch (ArrayIndexOutOfBoundsException e){
                throw new ArrayIndexOutOfBoundsException("Verifique o caracter separador [errorMessage]: " + e.getMessage());
            }
            linha = bufferedReader.readLine();
            contador++;
        }

        if (contador < 2){
            Escritor escritor = new Escritor();
            escritor.criarPastasTesteArquivoConfig();
            return false;
        }

        for (String caminho : listConfiguracoes){
            File arquivo = new File(caminho);
            if (!Files.exists(Paths.get(caminho))){
                arquivo.mkdir();
                System.out.println("Criado o diretório: " + caminho);
            }
        }
        return true;
    }

    public List<String> buscarArquivosProcessar() throws FileNotFoundException {
        File file = new File(Pastas.C_TESTE);
        String[] filelist = file.list();
        List<String> txtFiles = new ArrayList<>();
        for (String f : filelist){
            if (f.endsWith(".txt")){
                txtFiles.add(f);
            }
        }
        return txtFiles;
    }

    public List<String> lerArquivo(String arquivo) throws IOException {
        InputStream inputStream = new FileInputStream(Pastas.C_TESTE + arquivo);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String linha = bufferedReader.readLine();

        List<String> linhas = new ArrayList<>();

        while(linha != null && !linha.equals("")) {
            linhas.add(linha);
            linha = bufferedReader.readLine();
        }
        bufferedReader.close();
        return linhas;
    }
}
