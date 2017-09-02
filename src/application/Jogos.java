package application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.dao.AdmBanco;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Jogos extends Application {

	private TextField txtNome;
	private PasswordField txtGenero;
	private Button btnSalvar;
	private Button btnSair;
	private static Stage stage;
	private AnchorPane pane;
	private AdmBanco banco = new AdmBanco();

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListener();
		Scene cene = new Scene(pane);
		cene.getStylesheets().add("br/com/estilos/estilo.css");
		stage.setScene(cene);
		stage.setResizable(false);
		stage.setTitle("LOGIN - RegManuten��o");
		stage.show();
		initLayout();
		Jogos.stage = stage;
	}

	/**
	 * 
	 * Inicializa��o dos componentes da tela
	 * 
	 * @author Daniel Fernandes
	 */
	public void initComponents() {
		txtNome = new TextField();
		txtNome.setPromptText("Nome");
		txtGenero = new PasswordField();
		txtGenero.setPromptText("Genero");
		btnSalvar = new Button("Salvar");
		btnSair = new Button("SAIR");
		pane = new AnchorPane();
		pane.setId("pane");
		pane.setPrefSize(400, 300);
		txtNome.setPromptText("Input de Login");
		txtGenero.setPromptText("Txt de Senha");
		pane.getChildren().addAll(txtNome, txtGenero, btnSalvar, btnSair);

	}

	public Stage getStage() {
		return stage;
	}

	/**
	 * Fun��o que inicia o Layout dos componentes da pagina
	 * 
	 * @author Daniel Fernandes dos Santos
	 */
	private void initLayout() {
		txtNome.setLayoutX((pane.getWidth() - txtNome.getWidth()) / 2);
		txtNome.setLayoutY(50);

		txtGenero.setLayoutX((pane.getWidth() - txtGenero.getWidth()) / 2);
		txtGenero.setLayoutY(100);

		btnSalvar.setLayoutX((pane.getWidth() - btnSalvar.getWidth()) / 2);
		btnSalvar.setLayoutY(150);

		btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth()) / 2);
		btnSair.setLayoutY(200);
	}

	/**
	 * 
	 * Fun��o que inicia as a��es dos componentes da tela
	 * 
	 * @author Daniel Fernandes dos Santos
	 */
	private void initListener() {
		btnSair.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fecharAplicativo();

			}
		});

		btnSalvar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				entrar();

			}
		});

	}

	public void fecharAplicativo() {
		System.exit(0);
	}

	
	
	
	/**
	 * Verifica as credenciaais de acesso e abre a proxima tela
	 *2 de set de 2017
	 *void
	 *@author Daniel Fernandes
	 */
	public void entrar() {

		List<String> userpass = new ArrayList<String>();
		userpass = banco.selecionar();

		if (txtNome.getText().equals(userpass.get(0)) && txtGenero.getText().equals(userpass.get(1))) {
			try {


			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "DEU ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
