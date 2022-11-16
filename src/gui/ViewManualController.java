package gui;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import model.entities.Caminho;
import model.services.CaminhoService;

public class ViewManualController extends Application implements Initializable{
	
	private CaminhoService service;
	
	private ObservableList<Caminho> obsList;
	
	private List<Caminho> listaCaminhos;
	
	@FXML
	private TextField edtBuscar;
	
	@FXML
	private TextField edtCodOrigem;
	
	@FXML
	private TextField edtCodDestino;
	
	@FXML
	private TextField edtCidadeOrigem;
	
	@FXML
	private TextField edtCidadeDestino;
	
	@FXML
	private TextField edtKm;
	
	@FXML 
	private Button btnBuscar;
	
	@FXML
	private Button btnNew;
	
	@FXML
	private TableView<Caminho> tableViewCaminho;
	
	@FXML
	private TableColumn<Caminho, Integer> tableColumnCodigoCidadeOrigem;
	
	@FXML
	private TableColumn<Caminho, Integer> tableColumnCodigoCidadeDestino;
	
	@FXML
	private TableColumn<Caminho, String> tableColumnCidadeOrigem;
	
	@FXML
	private TableColumn<Caminho, String> tableColumnCidadeDestino;
	
	@FXML
	private TableColumn<Caminho, Double> tableColumnKm;
	
	@FXML
	public void onBtnNewAction() {
		if (service == null) {
			setCaminhoService(new CaminhoService());
		}
		updateTableView();
	}
	
	public void setCaminhoService(CaminhoService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		tableColumnCodigoCidadeOrigem.setCellValueFactory(new PropertyValueFactory<>("codigoCidadeOrigem"));
		tableColumnCodigoCidadeDestino.setCellValueFactory(new PropertyValueFactory<>("codigoCidadeDestino"));
		tableColumnCidadeDestino.setCellValueFactory(new PropertyValueFactory<>("cidadeDestino"));
		tableColumnCidadeOrigem.setCellValueFactory(new PropertyValueFactory<>("cidadeOrigem"));
		tableColumnKm.setCellValueFactory(new PropertyValueFactory<>("Km"));
	}

	@FXML
	public void onBtnBuscarClick() {
		FileDialog carregaArquivo = null;
		try {
			carregaArquivo = new FileDialog(new Dialog(carregaArquivo), "Selecione o arquivo", FileDialog.LOAD);
			carregaArquivo.setVisible(true);
			edtBuscar.setText(carregaArquivo.getDirectory()+carregaArquivo.getFile());						
		} catch (Exception e) {
			Alerts.showAlert("Erro", "Erro ao abrir dialog", e.getMessage(), AlertType.ERROR);
		}
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		if (listaCaminhos == null) {
			listaCaminhos = new ArrayList<>();
		}
		listaCaminhos.add(new Caminho(edtBuscar.getText(), Integer.parseInt(edtCodOrigem.getText()), edtCidadeOrigem.getText(), 
							edtCidadeDestino.getText(), Integer.parseInt(edtCodDestino.getText()), Double.parseDouble(edtKm.getText())));
		obsList = FXCollections.observableArrayList(listaCaminhos);
		tableViewCaminho.setItems(obsList);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Application.launch(ViewManualController.class);
	}

}
