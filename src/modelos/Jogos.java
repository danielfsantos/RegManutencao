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
	 * Inicializa os componentes da tela 
	 * 
	 * @author Daniel Fernandes
	 */
	public void initComponents() {
		txtNome = new TextField();
		txtNome.setPromptText("Nome");

		cboGenero = new ComboBox<>();
		cboGenero.setPromptText("Genero");
		
		cboPlataforma = new ComboBox<>();
		cboPlataforma.setPromptText("Plataforma");
		popularCombo();
		
		btnSalvar = new Button("Salvar");
		btnSair = new Button("SAIR");
		pane = new AnchorPane();
		pane.setId("pane");
		pane.setPrefSize(380, 384);
		pane.getChildren().addAll(cboPlataforma,cboGenero, txtNome, btnSalvar, btnSair);

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

		cboGenero.setLayoutX((pane.getWidth() - cboGenero.getWidth()) / 20);
		cboGenero.setLayoutY(80);

		cboPlataforma.setLayoutX((pane.getWidth() - cboGenero.getWidth()) / 20);
		cboPlataforma.setLayoutY(110);
		

		btnSalvar.setLayoutX((pane.getWidth() - btnSalvar.getWidth()) / 2);
		btnSalvar.setLayoutY(200);
		
		btnSair.setLayoutX((pane.getWidth() - btnSair.getWidth()) / 2);
		btnSair.setLayoutY(230);
	}

	/**
	 * 
	 * INicializa as funções dos Botões 
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

	/**
	 * Encerra a Aplicação
	 *
	 *2 de set de 2017
	 *
	 *void
	 *	
	 *@author Daniel Fernandes
	 */
	public void fecharAplicativo() {
		System.exit(0);
	}

	/**
	 * Realiza o Cadastro dos jogos utilizando os valores obtidos da tela 
	 *
	 *2 de set de 2017
	 *
	 *void
	 *	
	 *@author Daniel Fernandes
	 */
	public void cadastrarJogos() {
		String nome = txtNome.getText();
		

		jogosdao = new JogosDao();
		genero = new GeneroDao();
		plataforma = new PlataformaDao();

		jogosdao.salvarJogos(nome, genero.buscarIdBancoGenero(cboGenero.getValue()),
				plataforma.buscarIdBancoPlataforma(cboPlataforma.getValue()));
	}

	public static void main(String[] args) {
		launch(args);
	}

	
	/**
	 * Este metodo Popula as ComboBoxes da Tela
	 *
	 *2 de set de 2017
	 *
	 *void
	 *	
	 *@author Daniel Fernandes
	 */
	public void popularCombo() {

		genero = new GeneroDao();
		cboGenero.getItems().addAll(genero.popularComboGenero());

		plataforma = new PlataformaDao();
		cboPlataforma.getItems().addAll(plataforma.popularComboPlataforma());

	}

}
