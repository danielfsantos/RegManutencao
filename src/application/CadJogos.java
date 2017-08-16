package application;

import java.util.ArrayList;
import java.util.List;

import br.com.dao.AdmBanco;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CadJogos extends Application {

	private TextField txtNome;
	private TextField txtGenero;
	private TextField txtPlataforma;
	private TextField txtquantidade;
	private TextField txtPreco;
	private TableColumn tNome;
	private TableColumn tGenero;
	private TableColumn tPlataforma;
	private TableColumn tPreco;
	private TableColumn tQuantidade;
	private AdmBanco banco = new AdmBanco();
	private TableColumn tCep;
	private final TableView<?> table = new TableView();
	private static Stage stage;
	private AnchorPane pane;

	/**
	 * 
	 * Inicia os componentes da tela
	 * 
	 */
	public void initComponents() {
		txtNome = new TextField();
		txtGenero = new TextField();
		txtPlataforma = new TextField();
		txtquantidade = new TextField();
		txtPreco = new TextField();

		pane = new AnchorPane();
		tNome = new TableColumn<>("Nome");
		
		tGenero = new TableColumn<>("Genero");
		tPlataforma = new TableColumn<>("Plataforma");
		tPreco = new TableColumn<>("Preço");
		tQuantidade = new TableColumn<>("Quantidade");

		popularTableView();
		pane.setPrefSize(800, 600);
		table.getColumns().addAll(tNome, tGenero, tPlataforma, tPreco, tQuantidade);
		tNome.setCellValueFactory(new PropertyValueFactory("nome"));
		pane.getChildren().addAll(txtNome, txtGenero, txtPlataforma, txtPreco, txtquantidade, table);

	}

	/**
	 * 
	 * inicia o Layout dos componentes da tela
	 * 
	 */
	public void initLayout() {

		txtNome.setLayoutX((pane.getWidth() - txtNome.getWidth()) / 10);
		txtNome.setLayoutY(50);
		txtGenero.setLayoutX((pane.getWidth() - txtGenero.getWidth()) / 10);
		txtGenero.setLayoutY(84);
		txtPlataforma.setLayoutX((pane.getWidth() - txtPlataforma.getWidth()) / 10);
		txtPlataforma.setLayoutY(115);
		txtPreco.setLayoutX((pane.getWidth() - txtPreco.getWidth()) / 10);
		txtPreco.setLayoutY(145);
		txtquantidade.setLayoutX((pane.getWidth() - txtquantidade.getWidth()) / 10);
		txtquantidade.setLayoutY(175);

		table.setLayoutX((pane.getWidth() - table.getWidth()) / 40);
		table.setPrefWidth(500);
		table.setLayoutY(215);

	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		Scene cene = new Scene(pane);
		stage.setScene(cene);
		stage.setResizable(true);
		stage.setTitle("CADASTRO DE JOGOS - RegManutenção");
		stage.show();
		initLayout();
		CadJogos.stage = stage;
	}

	public void popularTableView() {
		ObservableList valores = FXCollections.observableArrayList();

		valores = banco.valoresDB();
		
		table.setItems(valores);

	}

	public Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
