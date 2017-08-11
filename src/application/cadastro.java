package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class cadastro extends Application {

	private TextField nome;
	private TextField logradouro;
	private TableColumn tNome;
	private TableColumn tLogradouro;
	private TableColumn tCep;
	private final TableView table = new TableView();
	private static Stage stage;
	private AnchorPane pane;

	public void initComponents() {
		nome = new TextField();
		logradouro = new TextField();
		pane = new AnchorPane();
		table.getColumns().addAll(tNome, tLogradouro);

	}

	public void initLayout() {

	}

	@Override
	public void start(Stage stage) throws Exception {

		Scene cene = new Scene(pane);
		cene.getStylesheets().add("application.css");
		stage.setScene(cene);
		stage.setResizable(false);
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
