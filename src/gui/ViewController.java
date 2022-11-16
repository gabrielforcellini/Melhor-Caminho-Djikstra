package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import arquivo.ManipuladorArquivo;
import grafos.Configuracoes;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	final String DIR_RAIZ = "C:\\Teste";
	final String DIR_CONFIG = this.DIR_RAIZ + "\\Configuracao";
	@FXML
	private Button btnOk;

	@FXML
	private CheckBox chkRotaAutomatica;

	@FXML
	private TextField edtdirRaiz;

	@FXML
	private TextField edtDirErro;

	@FXML
	private TextField edtDirSucesso;

	@FXML
	public void onBtnOkClick() {
		Configuracoes config = null;
		ManipuladorArquivo manipulador = null;
		try {
			if (!getMissed()) {
				config = new Configuracoes();
				manipulador = new ManipuladorArquivo();
				config.setDiretorioErro(edtDirErro.getText());
				config.setDiretorioRaiz(edtdirRaiz.getText());
				config.setDiretorioSucesso(edtDirSucesso.getText());
				config.setRotaAutomatica(chkRotaAutomatica.isSelected());
				manipulador.escritor(DIR_CONFIG +"\\config.txt", config.toString());
				System.exit(0);
			}
		} catch (Exception e) {
			Alerts.showAlert("Arquivo config", "Erro ao criar arquivo de configuração", e.getMessage(),
					AlertType.ERROR);
		}
	}

	@FXML
	public void onchkRotaAutomaticaClick() {
		// evento clique do botao rota automatica
	}

	// M�todo para verificar se o arquivo existe e n�o � um diret�rio
	public static boolean isFileExists(File file) {
		return file.exists() && !file.isDirectory();
	}
	
	// M�todo para verificar se o diret�rio existe
	public static boolean isDirExists(File file) {
		return file.exists();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		if (!isDirExists(new File(DIR_RAIZ))) {
			JOptionPane.showMessageDialog(null, "O diret�rio "+DIR_RAIZ+" não foi encontrado",
					"Diretório não encontrado", JOptionPane.OK_OPTION);
			System.exit(0);
		} else if (!isDirExists(new File(DIR_CONFIG))) {
			JOptionPane.showMessageDialog(null, "O diret�rio "+ DIR_CONFIG +" não foi encontrado",
					"Diretório não encontrado", JOptionPane.OK_OPTION);
			System.exit(0);
		}
	}

	public boolean getMissed() {
		boolean isFalse = false;
		if (edtDirErro.getText() == "") {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Erro não pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		} else if (edtDirSucesso.getText() == "") {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Sucesso não pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		} else if (edtdirRaiz.getText() == "") {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Raiz não pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		}
		return isFalse;
	}
}
