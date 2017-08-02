package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Estoque extends Application {

	@Override
	public void start(Stage index) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		Scene cene = new Scene(pane);

		/* Componentes da Tela */
		TextField txtLogin = new TextField();
		TextField txtSenha = new TextField();
		Button btnEntrar = new Button("Entrar");
		Button btnSair = new Button("Sair");
		txtLogin.setPromptText("Input de Login");
		txtSenha.setPromptText("Txt de Senha");

		/* Configuração dos Componentes da tela */
		pane.getChildren().addAll(txtLogin, txtSenha, btnEntrar, btnSair);

		index.setScene(cene);
		index.show();

		/* Layout dos componentes */
		txtLogin.setLayoutX(pane.getWidth() - txtLogin.getWidth() / 2);
		txtLogin.setLayoutY(50);

		txtSenha.setLayoutX(pane.getWidth() - txtSenha.getWidth() / 2);
		txtSenha.setLayoutY(100);

		btnEntrar.setLayoutX(pane.getWidth() - btnEntrar.getWidth() / 2);
		btnEntrar.setLayoutY(150);

		btnSair.setLayoutX(pane.getWidth() - btnSair.getWidth() / 2);
		btnSair.setLayoutY(200);

		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100% , blue 0% , silver 100%);");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
