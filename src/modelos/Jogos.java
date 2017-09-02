package modelos;

import br.com.dao.AdmBanco;
import controles.GeneroDao;
import controles.JogosDao;
import controles.PlataformaDao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Jogos extends Application {

	private TextField txtNome;
	private TextField txtPlataforma;
	private TextField txtGenero;
	private Button btnSalvar;
	private Button btnSair;
	private ComboBox<String> cboGenero;
	private ComboBox<String> cboPlataforma;
	private static Stage stage;
	private AnchorPane pane;
	private AdmBanco banco = new AdmBanco();
	private JogosDao jogosdao;
	private GeneroDao genero;
	private PlataformaDao plataforma;

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListener();
		Scene cene = new Scene(pane);
		cene.getStylesheets().add("br/com/estilos/estilo.css");
		stage.setScene(cene);
		stage.setResizable(false);
		stage.setTitle("Cadastro de jogos");
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

		txtGenero = new TextField();
		txtGenero.setPromptText("Genero");

		txtPlataforma = new TextField();
		txtPlataforma.setPromptText("Plataforma");

		cboGenero = new ComboBox<>();
		cboGenero.setPromptText("Genero");
		

		cboPlataforma = new ComboBox<>();
		cboPlataforma.setPromptText("Plataforma");
		popularCombo();
		btnSalvar = new Button("Salvar");
		btnSair = new Button("SAIR");
		pane = new AnchorPane();
		pane.setId("pane");
		pane.setPrefSize(800, 600);
		pane.getChildren().addAll(cboPlataforma,cboGenero, txtNome, txtGenero, txtPlataforma, btnSalvar, btnSair);

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
		txtNome.setLayoutX((pane.getWidth() - txtNome.getWidth()) / 20);
		txtNome.setLayoutY(50);

		txtGenero.setLayoutX((pane.getWidth() - txtGenero.getWidth()) / 20);
		txtGenero.setLayoutY(80);

		txtPlataforma.setLayoutX((pane.getWidth() - txtGenero.getWidth()) / 20);
		txtPlataforma.setLayoutY(110);


		cboGenero.setLayoutX((pane.getWidth() - cboGenero.getWidth()) / 20);
		cboGenero.setLayoutY(140);

		cboPlataforma.setLayoutX((pane.getWidth() - cboGenero.getWidth()) / 20);
		cboPlataforma.setLayoutY(170);
		

		btnSalvar.setLayoutX((pane.getWidth() - btnSalvar.getWidth()) / 2);
		btnSalvar.setLayoutY(250);
		
		btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth()) / 2);
		btnSair.setLayoutY(280);
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
				cadastrarJogos();

			}
		});

	}

	public void fecharAplicativo() {
		System.exit(0);
	}

	public void cadastrarJogos() {
		String nome = txtNome.getText();
		String Genero = txtGenero.getText();
		String Plataforma = txtPlataforma.getText();

		jogosdao = new JogosDao();
		genero = new GeneroDao();
		plataforma = new PlataformaDao();

		jogosdao.salvarJogos(nome, genero.buscarIdBancoGenero(cboGenero.getValue()),
				plataforma.buscarIdBancoPlataforma(cboPlataforma.getValue()));
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void popularCombo() {

		genero = new GeneroDao();
		cboGenero.getItems().addAll(genero.popularComboGenero());

		plataforma = new PlataformaDao();
		cboPlataforma.getItems().addAll(plataforma.popularComboPlataforma());

	}

}
