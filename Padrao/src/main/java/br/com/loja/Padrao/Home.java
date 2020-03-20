package br.com.loja.Padrao;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Home extends Application{
	private AnchorPane pane;
	private TextField textFieldUserLogin;
	private PasswordField passwordFieldUserLogin;
	private Button buttonLogin, buttonExit;
	private static Stage stage;
	
	public void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 1000);
	}
	
	public void initLayouts(){
		
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

	
	
}
