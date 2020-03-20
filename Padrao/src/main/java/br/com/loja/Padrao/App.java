package br.com.loja.Padrao;

//import com.fap.twitter.App;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Label labelLogoTipo;
	private Label labelUser;
	private Label labelPassword;
	private Label labelOpenAccount;
	private TextField textFieldOAName;
	private TextField textFieldOASurname;
	private TextField textFieldOAEmail;
	private PasswordField passwordFieldOAPassword;
	private Button buttonCreateAccount;
	private Image imageLogo;
	private Image applicationIcon;
	ListUser listUser = new ListUser();

	// arquitetura básica, tem esses três métodos

	public void initComponent() {
		pane = new AnchorPane();
		pane.setPrefSize(500, 300);

		textFieldUserLogin = new TextField();
		textFieldUserLogin.setPromptText("Digite aqui");
		
		passwordFieldUserLogin = new PasswordField();
		passwordFieldUserLogin.setPromptText("Digite aqui");
		
		buttonLogin = new Button("Login");
		buttonExit = new Button("Sair");	
		
		imageLogo = new Image("file:///D:/PROJETOS/Padrao-loja/Padrao/img/facebook-logo.png");
		labelLogoTipo = new Label("", new ImageView(imageLogo));
		
		labelUser = new Label("Email ou Telefone");
		labelPassword = new Label("Senha");
		
		labelOpenAccount = new Label("Abra uma conta");
		
		textFieldOAName = new TextField();
		textFieldOAName.setPromptText("Nome");
		
		textFieldOASurname = new TextField();
		textFieldOASurname.setPromptText("Sobrenome");
		
		textFieldOAEmail = new TextField();
		textFieldOAEmail.setPromptText("Email");
		
		passwordFieldOAPassword = new PasswordField();
		passwordFieldOAPassword.setPromptText("Nova Senha");
		
		buttonCreateAccount = new Button("Criar Conta");
		
		applicationIcon = new Image("file:///D:/PROJETOS/Padrao-loja/Padrao/img/facebook-icon.png");
		
		

	}

	public void initLayout() {
		textFieldUserLogin.setLayoutX(160);
		textFieldUserLogin.setLayoutY(40);
		
		passwordFieldUserLogin.setLayoutX(340);
		passwordFieldUserLogin.setLayoutY(40);
		
		buttonLogin.setLayoutX(340);
		buttonLogin.setLayoutY(70);
		buttonLogin.setPrefSize(150, 35);
		
		buttonExit.setLayoutX(410);
		buttonExit.setLayoutY(250);
		buttonExit.setPrefSize(80, 40);
		
		labelLogoTipo.setLayoutX(25);
		labelLogoTipo.setLayoutY(20);
		
		labelUser.setLayoutX(160);
		labelUser.setLayoutY(25);
		
		labelPassword.setLayoutX(340);
		labelPassword.setLayoutY(25);
		
		labelOpenAccount.setLayoutX(10);
		labelOpenAccount.setLayoutY(120);
		
		textFieldOAName.setLayoutX(10);
		textFieldOAName.setLayoutY(145);
		
		textFieldOASurname.setLayoutX(170);
		textFieldOASurname.setLayoutY(145);
		
		textFieldOAEmail.setLayoutX(10);
		textFieldOAEmail.setLayoutY(180);
		textFieldOAEmail.setPrefSize(310, 25);
		
		passwordFieldOAPassword.setLayoutX(10);
		passwordFieldOAPassword.setLayoutY(215);
		passwordFieldOAPassword.setPrefSize(310, 25);
		
		buttonCreateAccount.setLayoutX(10);
		buttonCreateAccount.setLayoutY(250);
		buttonCreateAccount.setPrefSize(100, 40);
		
		
		pane.getChildren().addAll(labelLogoTipo, labelUser, textFieldUserLogin, 
				labelPassword,passwordFieldUserLogin, buttonLogin, buttonExit, 
				labelOpenAccount, textFieldOAName, textFieldOASurname, textFieldOAEmail,
				passwordFieldOAPassword,buttonCreateAccount);
		
		

	}

	public void initListeners() {
		buttonExit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fecharApp();
			}
		});

		buttonLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logar();
			}
		});
		
		buttonCreateAccount.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				createAccount();
			}
			
		});

	}

	public void logar() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		if (listUser.verifyLogin(textFieldUserLogin.getText(), passwordFieldUserLogin.getText())) {
			alert.setContentText("Login realizado com sucesso!");
		} else {
			alert.setContentText("Email ou senha errado!");
			
		}
		alert.showAndWait();
	}
	
	public void fecharApp() {
		System.exit(0);
	}

	public void createAccount(){
		String text = "";
		Alert alert = new Alert(AlertType.INFORMATION);

		if(textFieldOAName.getText().trim().equals("")) {
			text = "Preencha o seu nome!";
			
		}else if(textFieldOASurname.getText().trim().equals("")){
			text = "Preencha o seu sobrenome!";
			
		}else if(textFieldOAEmail.getText().trim().equals("")){
			text = "Preencha o seu email!";
			
		}else if(passwordFieldOAPassword.getText().trim().equals("")){
			text = "Digite a sua senha!";
		}else {
			text = "Cadastro realizado com sucesso\nFaça o seu login!";
			User newUser = new User();
			
			newUser.setName(textFieldOAName.getText());
			newUser.setSurname(textFieldOASurname.getText());
			newUser.setEmail(textFieldOAEmail.getText());
			newUser.setPassword(passwordFieldOAPassword.getText());
			
			listUser.addUser(newUser);
			
			clearFields();
		}
		alert.setContentText(text);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	public void clearFields() {
		textFieldOAName.setText("");
		textFieldOASurname.setText("");
		textFieldOAEmail.setText("");
		passwordFieldOAPassword.setText("");
	}
	
	@Override
    public void start(Stage stage) {
    	initComponent();
    	initListeners();
    	initStage(stage);
    	initLayout();
    	stage = App.stage;
    }
	
    private void initStage(Stage stage) {
    	Scene scene = new Scene(pane);
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.setTitle("Facebook");
    	stage.getIcons().add(applicationIcon);
    	stage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}