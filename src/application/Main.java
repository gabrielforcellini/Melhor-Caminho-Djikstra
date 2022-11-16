package application;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import arquivo.ManipuladorArquivo;
import grafos.Configuracoes;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static String tela = "";
	private static String titulo = "";
	final static String DIR_RAIZ = "C:\\Teste";
	final static String DIR_CONFIG = DIR_RAIZ + "\\Configuracao";
	final static TrayIcon trayIcon = new TrayIcon(
			Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "//icon.gif"));
	final static SystemTray tray = SystemTray.getSystemTray();
	final static PopupMenu popup = new PopupMenu();
	final static MenuItem item1 = new MenuItem("Configuração");
	final static MenuItem item2 = new MenuItem("Visivel");
	final static MenuItem exitItem = new MenuItem("Exit");
	static Stage gStage;

	@Override
	public void start(Stage stage) {
		try {
			gStage = stage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
			Parent parent = loader.load();
			Scene mainScene = new Scene(parent);
			stage.setScene(mainScene);
			stage.setTitle(titulo);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		ManipuladorArquivo manipulador = new ManipuladorArquivo();
		Configuracoes config = new Configuracoes();
		config = manipulador.leitor(DIR_CONFIG + "\\config.txt");
		if (config == null) {
			tela = "/gui/View.fxml";
			titulo = "Configuração";
			launch(args);
		} else if (!config.getRotaAutomatica()) {
			titulo = "Djikstra - Busca por melhor caminho";
			tela = "/gui/ViewManual.fxml";
			launch(args);
		} else {
			// thread
			tela = "/gui/View.fxml";
			titulo = "Configuração";
			launch(args);
			if (SystemTray.isSupported()) {
				initSysTray();
			}
			exitItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("finalizando...");
					System.exit(0);
				}

			});
			item1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tela = "/gui/View.fxml";
					titulo = "Configuração";
					gStage.show();
					gStage.toFront();
				}

			});
			item2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					titulo = "Djikstra - Busca por melhor caminho";
					tela = "/gui/ViewManual.fxml";
					gStage.show();
					gStage.toFront();
				}

			});
			System.out.println("background");
		}
	}

	public static void initSysTray() {

		popup.add(item1);
		popup.add(item2);
		popup.addSeparator();
		popup.add(exitItem);

		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void show() {

	}
}
