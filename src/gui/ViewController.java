package gui;

import java.net.URL;
import java.util.ResourceBundle;

import arquivo.ManipuladorArquivo;
import grafos.Configuracoes;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
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
			if (!getMissed()){
				config = new Configuracoes();
				manipulador = new ManipuladorArquivo();
				config.setDiretorioErro(edtDirErro.getText());
				config.setDiretorioRaiz(edtdirRaiz.getText());
				config.setDiretorioSucesso(edtDirSucesso.getText());
				config.setRotaAutomatica(chkRotaAutomatica.isSelected());
				manipulador.escritor("c:\\Teste\\Configuracao\\config.txt", config.toString());
				System.exit(0);
			}
		} catch (Exception e) {
			Alerts.showAlert("Arquivo config", "Erro ao criar arquivo de configura��o", e.getMessage(), AlertType.ERROR);
		}
	} 
	
	@FXML
	public void onchkRotaAutomaticaClick() {
		//evento clique do botao rota automatica
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
	}
	
	public boolean getMissed() {
		boolean isFalse = false;
		if (edtDirErro.getText() == "" ) {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Erro n�o pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		} else if (edtDirSucesso.getText() == "" ) {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Sucesso n�o pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		} else if (edtdirRaiz.getText() == "" ) {
			Alerts.showAlert("Erro", "Campo vazio", "O campo Raiz n�o pode ser vazio!", AlertType.ERROR);
			isFalse = true;
		}
		return isFalse;
	}
}
