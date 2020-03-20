package com.fap.twitter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	private BorderPane pane;
	private Button btHome, btExplorer, btNotifications, btMensages, btBookmarks, btLists, btProfile, btMore, btTweet, btLike;
	private TextField tfSearch;
	private TextArea taMensagemTweet;
	private Label lMensageTweet;
	private static Stage stage;
	

    @Override
    public void start(Stage stage) {
    	initComponents();
    	initListeners();
    	initStage(stage);
    	initLayouts();
    	stage = App.stage;
    }

    public static void main(String[] args) {
        launch();
    }
 
    private void initStage(Stage stage) {
    	Scene scene = new Scene(pane);
    	stage.setScene(scene);
    	stage.setResizable(true);
    	stage.setTitle("Twitter");
    	stage.show();

	}

    private void initComponents() {
		pane = new BorderPane();
		pane.setPrefSize(800, 600);
		
		HBox hBoxTop = initComponentesTop();
		pane.setTop(hBoxTop);
		
		VBox vBoxMenu = initComponentesMenu();
		pane.setLeft(vBoxMenu);
		vBoxMenu.setAlignment(Pos.CENTER_RIGHT);
		
		VBox vBoxTweet = initComponentesTweet();
		pane.setCenter(vBoxTweet);
		vBoxMenu.setAlignment(Pos.CENTER);		
		
	}
    
    private HBox initComponentesTop() {
    	HBox top = new HBox(200);
		
    	Label logo = new Label("Twitter");
    	top.getChildren().add(logo);
		logo.setAlignment(Pos.TOP_RIGHT);
		
    	Label timeline = new Label("Página Principal");
    	top.getChildren().add(timeline);
		timeline.setAlignment(Pos.TOP_CENTER);
		
		tfSearch = new TextField("Buscar no Twitter");
    	top.getChildren().add(tfSearch);
    	tfSearch.setAlignment(Pos.TOP_LEFT);
		
		return top;
	}
    
    private VBox initComponentesMenu() {
		VBox vBoxMenu = new VBox(30);
		btHome = new Button("Home");
		btExplorer = new Button("Explorer");
		btNotifications = new Button("Notifications");
		btMensages = new Button("Mensages");
		btBookmarks = new Button("Bookmarks");
		btLists = new Button("Lists");
		btProfile = new Button("Profile"); 
		btMore = new Button("More");
		
		vBoxMenu.getChildren().addAll(btHome, btExplorer, btNotifications, btMensages, btBookmarks, btLists, btProfile, btMore);
		return vBoxMenu;
	}
    
    private VBox initComponentesTweet() {
		VBox vBoxMenu = new VBox(30);
		btTweet = new Button("Tweet");
		taMensagemTweet = new TextArea("Como está a sua vida hoje?");
		
		vBoxMenu.getChildren().addAll(taMensagemTweet, btTweet);
		return vBoxMenu;
	}
    
    private void initLayouts() {
		// TODO Auto-generated method stub

	}
    
   private void initListeners() {
	// TODO Auto-generated method stub

   }

}