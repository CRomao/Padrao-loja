package br.com.fapce.teste;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 * 
 * @author LAB 3A - Aluno - C.ROMÃO
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {

		var pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		
		var textFieldLogin = new TextField("Digite seu usuário..");
		
		var passwordFieldLogin = new PasswordField();
		
		passwordFieldLogin.setPromptText("Digite sua senha..");
		
		var buttonLogin = new Button("Entrar");
		
		var buttonExit = new Button("Sair");
		
		pane.getChildren().addAll(textFieldLogin, passwordFieldLogin, buttonLogin, buttonExit);
		
		var scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.show();
		
		textFieldLogin.setLayoutX((pane.getWidth()- textFieldLogin.getWidth())/2);
		textFieldLogin.setLayoutY(50);
		
		passwordFieldLogin.setLayoutX((pane.getWidth()- textFieldLogin.getWidth())/2);
		passwordFieldLogin.setLayoutY(100);
		
		buttonLogin.setLayoutX((pane.getWidth()- textFieldLogin.getWidth())/2);
		buttonLogin.setLayoutY(150);
		
		buttonExit.setLayoutX((pane.getWidth()- textFieldLogin.getWidth())/2);
		buttonExit.setLayoutY(200);
	}

	public static void main(String[] args) {
		launch();
	}

}