package application;

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

public class Login extends Application {

	private TextField txtLogin;
	private PasswordField txtSenha;
	private Button btnEntrar;
	private Button btnSair;
	private static Stage stage;
	private AnchorPane pane;
	private CadFerramentas cad = new CadFerramentas();
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
		Login.stage = stage;
	}

	/**
	 * 
	 * Inicializa��o dos componentes da tela
	 * 
	 * @author Daniel Fernandes
	 */
	public void initComponents() {
		txtLogin = new TextField();
		txtLogin.setPromptText("LOGIN");
		txtSenha = new PasswordField();
		txtSenha.setPromptText("SENHA");
		btnEntrar = new Button("ENTRAR");
		btnSair = new Button("SAIR");
		pane = new AnchorPane();
		pane.setId("pane");
		pane.setPrefSize(400, 300);
		txtLogin.setPromptText("Input de Login");
		txtSenha.setPromptText("Txt de Senha");
		pane.getChildren().addAll(txtLogin, txtSenha, btnEntrar, btnSair);

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
		txtLogin.setLayoutX((pane.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(50);

		txtSenha.setLayoutX((pane.getWidth() - txtSenha.getWidth()) / 2);
		txtSenha.setLayoutY(100);

		btnEntrar.setLayoutX((pane.getWidth() - btnEntrar.getWidth()) / 2);
		btnEntrar.setLayoutY(150);

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

		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {

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
	 * 
	 * Verifica as credenciaais de acesso e abre a proxima tela 
	 * */
	public void entrar() {
		if (txtLogin.getText().equals("Daniel") && txtSenha.getText().equals("123")) {
			try {
				cad.start(getStage());
				banco.selecionar();

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
