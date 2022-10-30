package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import grafos.Configuracoes;
import grafos.Grafo;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class ManipuladorArquivo {

	Grafo g = new Grafo();

	public ManipuladorArquivo() {

	}

	// M�todo para verificar se o arquivo existe e n�o � um diret�rio
	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}

	public Configuracoes leitor(String path) throws IOException {
		Configuracoes config = null;
		try {
			if (isFileExists(new File(path))) {
				BufferedReader buffRead = new BufferedReader(new FileReader(path));
				String linha = "";
				config = new Configuracoes();
				linha = buffRead.readLine();
				while (true) {
					if (linha != null) {
						String[] textoSeparado = linha.split("=");
						if (textoSeparado[0].equalsIgnoreCase("Processado")) {
							config.setDiretorioSucesso(textoSeparado[1]);
						} else if (textoSeparado[0].equalsIgnoreCase("N�o Processado")) {
							config.setDiretorioErro(textoSeparado[1]);
						} else if (textoSeparado[0].equalsIgnoreCase("Diretorio Raiz")) {
							config.setDiretorioRaiz(textoSeparado[1]);
						} else if (textoSeparado[0].equalsIgnoreCase("Rota Automatica")) {
							config.setRotaAutomatica(textoSeparado[1].equalsIgnoreCase("true"));
						}
					} else
						break;
					linha = buffRead.readLine();
				}
				buffRead.close();
			} else {
				config = null;
			}
		} catch (Exception e) {
			Alerts.showAlert("Arquivo", "Erro de Manipula��o do arquivo", e.getMessage(), AlertType.ERROR);
		}
		return config;
	}

	public void escritor(final String path, final String conteudo) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.append(conteudo);
		buffWrite.close();
	}
}
