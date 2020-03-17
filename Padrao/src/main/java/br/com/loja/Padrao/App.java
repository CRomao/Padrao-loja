package br.com.loja.Padrao;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private AnchorPane pane;
	private TextField textFieldUserLogin;
	private PasswordField passwordFieldUserLogin;
	private Button buttonLogin, buttonExit;
	private static Stage stage;

	// arquitetura básica, tem esses três métodos

	public void initComponent() {
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);

		textFieldUserLogin = new TextField();
		textFieldUserLogin.setPromptText("Digite seu user");
		
		passwordFieldUserLogin = new PasswordField();
		passwordFieldUserLogin.setPromptText("Digite sua senha");
		
		buttonLogin = new Button("Login");
		buttonExit = new Button("Sair");	

	}

	public void initLayout() {
		textFieldUserLogin.setLayoutX((pane.getWidth() - textFieldUserLogin.getWidth()) / 2);
		textFieldUserLogin.setLayoutY(50);
		
		passwordFieldUserLogin.setLayoutX((pane.getWidth()- textFieldUserLogin.getWidth())/2);
		passwordFieldUserLogin.setLayoutY(100);
		
		buttonLogin.setLayoutX((pane.getWidth()- textFieldUserLogin.getWidth())/2);
		buttonLogin.setLayoutY(150);
		
		buttonExit.setLayoutX((pane.getWidth()- textFieldUserLogin.getWidth())/2);
		buttonExit.setLayoutY(200);
		
		pane.getChildren().addAll(textFieldUserLogin, passwordFieldUserLogin, buttonLogin, buttonExit);

	}

	public void initListeners() {
		buttonExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// fecharApp();
			}
		});

		buttonLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logar();
			}
		});

	}

	public void logar() {
		if (textFieldUserLogin.getText().equals("admin") && passwordFieldUserLogin.getText().equals("admin")) {
			// TODO Abrir tela vitrineApp
		} else {
		//	System.err.println("Access Denied");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Informação");
			alert.setHeaderText(null);
			alert.setContentText("Acesso Negado!");
			
			alert.showAndWait();
		}
	}

	@Override
	public void start(Stage stage) {
		App.stage = stage;
		this.stage.show();
		initComponent();
		initLayout();
		initListeners();
		logar();
		
	}

	public static void main(String[] args) {
		launch();
	}

}