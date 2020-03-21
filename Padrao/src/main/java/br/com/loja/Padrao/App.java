package br.com.loja.Padrao;

import java.io.File;
import java.net.URI;
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
	private File dirImageLogo;
	private File dirApplicationIcon;

	// arquitetura básica, tem esses três métodos

	public void initComponents() { //função para inicializar os componentes
		pane = new AnchorPane();
		pane.setPrefSize(500, 300);

		textFieldUserLogin = new TextField();
		textFieldUserLogin.setPromptText("Digite seu Email");

		passwordFieldUserLogin = new PasswordField();
		passwordFieldUserLogin.setPromptText("Digite sua senha");

		buttonLogin = new Button("Login");
		buttonExit = new Button("Sair");

		dirImageLogo = new File("img/facebook-logo.png"); 
		String file = (dirImageLogo.toURI().toString()); //Pegar o diretório absoluto da imagem
		imageLogo = new Image(file);
		labelLogoTipo = new Label("", new ImageView(imageLogo));

		labelUser = new Label("Email");
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

		dirApplicationIcon = new File("img/facebook-icon.png");
		String fileIcon = (dirApplicationIcon.toURI().toString());
		applicationIcon = new Image(fileIcon);

	}

	public void initLayouts() {//função para iniciar as estilizações dos componentes
		textFieldUserLogin.setLayoutX(160);
		textFieldUserLogin.setLayoutY(40);

		passwordFieldUserLogin.setLayoutX(340);
		passwordFieldUserLogin.setLayoutY(40);

		buttonLogin.setLayoutX(340);
		buttonLogin.setLayoutY(70);
		buttonLogin.setPrefSize(150, 35);
		buttonLogin.setStyle("-fx-background-color: #3498DB;");

		buttonExit.setLayoutX(410);
		buttonExit.setLayoutY(250);
		buttonExit.setPrefSize(80, 40);
		buttonExit.setStyle("-fx-background-color: #EC7063;");

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
		buttonCreateAccount.setStyle("-fx-background-color: #2ECC71;");

		pane.getChildren().addAll(labelLogoTipo, labelUser, textFieldUserLogin, labelPassword, passwordFieldUserLogin,
				buttonLogin, buttonExit, labelOpenAccount, textFieldOAName, textFieldOASurname, textFieldOAEmail,
				passwordFieldOAPassword, buttonCreateAccount);
	}

	public void initListeners() { // Função para executar os eventos associados aos botões
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

	public void logar() {//Função para fazer o login
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		//Abaixo é verificado se existe no ArrayList, se existir, ele traz a tela Home
		if (listUser.verifyLogin(textFieldUserLogin.getText(), passwordFieldUserLogin.getText())) {
			textFieldUserLogin.setText("");
			passwordFieldUserLogin.setText("");
			alert.setContentText("Login realizado com sucesso!");
			alert.showAndWait();

			Home home = new Home(listUser.getUserLogged(), listUser);
			Stage stageHome = new Stage();
			try {
				home.start(stageHome);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			alert.setContentText("Email ou senha inválido!");
			alert.showAndWait();

		}

	}

	public void fecharApp() {//Função para fechar a aplicação
		System.exit(0);
	}

	public void createAccount() {//Função para criar uma nova conta
		String text = "";
		Alert alert = new Alert(AlertType.INFORMATION);

		if (textFieldOAName.getText().trim().equals("")) {
			text = "Preencha o seu nome!";

		} else if (textFieldOASurname.getText().trim().equals("")) {
			text = "Preencha o seu sobrenome!";

		} else if (textFieldOAEmail.getText().trim().equals("")) {
			text = "Preencha o seu email!";

		} else if (passwordFieldOAPassword.getText().trim().equals("")) {
			text = "Digite a sua senha!";
		} else {
			//caso todos os campos estejam preenchidos, cria-se um novo usuário e adiciona na lista
			text = "Cadastro realizado com sucesso!\nJá pode fazer o seu login!";
			
			User newUser = new User();
			newUser.setName(textFieldOAName.getText());
			newUser.setSurname(textFieldOASurname.getText());
			newUser.setEmail(textFieldOAEmail.getText());
			newUser.setPassword(passwordFieldOAPassword.getText());

			listUser.addUser(newUser);

			clearFields();//Após adicionar, chama a função para limpar os campos
		}
		alert.setContentText(text);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	public void clearFields() {//Função para limpar os campos quando o usuário finalizar o cadastro
		textFieldOAName.setText("");
		textFieldOASurname.setText("");
		textFieldOAEmail.setText("");
		passwordFieldOAPassword.setText("");
	}

	@Override
	public void start(Stage stage) {//Função para dar start
		initComponents();
		initListeners();
		initStage(stage);
		initLayouts();
		stage = App.stage;
	}

	private void initStage(Stage stage) {//Função para iniciar o stage
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