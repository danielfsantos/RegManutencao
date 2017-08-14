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
		pane.setPrefSize(800, 600);
		pane.getChildren().addAll(nome, logradouro);

	}

	public void initLayout() {
			nome.setLayoutX((pane.getWidth() - nome.getWidth()) / 2);
			nome.setLayoutY(50);
			
			logradouro.setLayoutX((pane.getWidth() - logradouro.getWidth()) / 2);
			logradouro.setLayoutY(100);
			
			
			
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
