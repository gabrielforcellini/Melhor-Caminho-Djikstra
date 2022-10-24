package application;
	
import java.io.IOException;

import arquivo.ManipuladorArquivo;
import grafos.Configuracoes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	private static String tela = "";
	private static String titulo = "";
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			stage.setScene(mainScene);
			stage.setTitle(titulo);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		ManipuladorArquivo manipulador = new ManipuladorArquivo();
		Configuracoes config = new Configuracoes();
		config = manipulador.leitor("C:\\Teste\\Configuracao\\config.txt");
		if (config == null) {
			tela = "/gui/View.fxml";
			titulo = "Configuração";
			launch(args);
		} else if (config.getRotaAutomatica()){
			//fazer o sistema rodar em background
			System.out.println("background");
		} else {
			titulo = "Djikstra - Busca por melhor caminho";
			tela = "/gui/ViewManual.fxml";
			launch(args);
		}
	}
}
