package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Cadjogos extends Application {

	private TextField txtNome;
	private TextField txtPlataforma;
	private TextField txtGenero;
	private AnchorPane pane;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(true);
		stage.setTitle("Cadastro");
		stage.show();
		initLayout();
		Cadjogos.stage = stage;
	}

	public void initComponents() {
		txtNome = new TextField();
		txtPlataforma = new TextField();
		txtGenero = new TextField();
		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtPlataforma, txtGenero);

	}

	public void initLayout() {
		txtNome.setLayoutX((pane.getWidth() - txtNome.getWidth()) / 2);
		txtNome.setLayoutY(50);

		txtGenero.setLayoutX((pane.getWidth() - txtGenero.getWidth()) / 2);
		txtGenero.setLayoutY(50);

	}

	public Stage stage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
