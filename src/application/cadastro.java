package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class cadastro extends Application {

	private TextField txtNome;
	private TextField txtLogradouro;
	private Label lblNome;
	private TableColumn tNome;
	private TableColumn tLogradouro;
	private TableColumn tCep;
	private final TableView table = new TableView();
	private static Stage stage;
	private AnchorPane pane;

	public void initComponents() {
		txtNome = new TextField();
		txtLogradouro = new TextField();
		pane = new AnchorPane();
		tNome = new TableColumn<>();
		tLogradouro = new TableColumn<>();
		table.getColumns().addAll(tNome, tLogradouro);
		pane.setPrefSize(800, 600);
		pane.getChildren().addAll(txtNome, txtLogradouro, table);

	}

	public void initLayout() {
		txtNome.setLayoutX((pane.getWidth() - txtNome.getWidth()) / 10);
		txtNome.setLayoutY(50);

		txtLogradouro.setLayoutX((pane.getWidth() - txtLogradouro.getWidth()) / 10);
		txtLogradouro.setLayoutY(90);

		table.setLayoutX((pane.getWidth() - table.getWidth()) / 2);
		table.setLayoutY(200);
		tNome.setText("Nome");
		tLogradouro.setText("Logradouro");

	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		Scene cene = new Scene(pane);
		stage.setScene(cene);
		stage.setResizable(true);
		stage.setTitle("LOGIN - RegManutenção");
		stage.show();
		initLayout();
		cadastro.stage = stage;
	}

	public Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
