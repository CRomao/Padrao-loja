package br.com.fapce.teste;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Home extends Application{
	private AnchorPane pane;
	private static Stage stage;
	private Label labelLogoTipo;
	private TextField textFieldSearch;
	private Button buttonUserPerfil, buttonPagInitial, buttonCreate, buttonFriends, 
	buttonMessenger, buttonNotifications, buttonHelp, buttonExit;
	//private User userLogged;
	
	//public Home(User userLogged) {
//		setUserLogged(userLogged);
//	}
	
	
	//public User getUserLogged() {
//		return userLogged;
	//}


	//public void setUserLogged(User userLogged) {
	//	this.userLogged = userLogged;
	//}


	public void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(850, 550);
		
		labelLogoTipo = new Label("Facebook");
		textFieldSearch = new TextField();
		textFieldSearch.setPromptText("Procurar...");
		
	//	buttonUserPerfil = new Button(getUserLogged().getName());
		
		
		
	}
	
	public void initLayouts(){
		
		labelLogoTipo.setLayoutX(10);
		labelLogoTipo.setLayoutX(10);
		
		textFieldSearch.setLayoutX(25);
		textFieldSearch.setLayoutY(10);
		
		buttonUserPerfil.setLayoutX(40);
		buttonUserPerfil.setLayoutY(10);
		
		
		
		pane.getChildren().addAll(labelLogoTipo, textFieldSearch, buttonUserPerfil);
	}
	
	public void initListeners() {
		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
    	initComponents();
    	initListeners();
    	initStage(stage);
    	initLayouts();
    	stage = Home.stage;
		
	}
	
	  private void initStage(Stage stage) {
	    	Scene scene = new Scene(pane);
	    	stage.setScene(scene);
	    	stage.setResizable(false);
	    	stage.setTitle("Facebook - Home");
	    	//stage.getIcons().add(applicationIcon);
	    	stage.show();

		}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Home.stage = stage;
	}

	public static void main(String[] args) {
		launch();
	}
	
}
