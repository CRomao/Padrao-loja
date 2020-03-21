package br.com.loja.Padrao;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home extends Application{
	//parte de cima
	private BorderPane pane;
	private static Stage stage;
	private Label labelLogoTipo,labelFriends, 
	labelMessenger, labelNotifications, labelHelp;
	private TextField textFieldSearch;
	private Button buttonUserPerfil, buttonPagInitial, buttonCreate, buttonExit, buttonSearch;
	private User userLogged;
	//parte lateral esquerda
	private Button buttonFeed, buttonMessenger, buttonWatch, buttonMarketplace,
			buttonGroups, buttonCampaign, buttonPages, buttonEvents, buttonListFriends,
			buttonSeeMore, buttonUserName;
	private Label labelExplorar;
	
	
	public Home(User userLogged) {
		setUserLogged(userLogged);
	}
	
	
	public User getUserLogged() {
		return userLogged;
	}


	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}


	public void initComponents() {
		pane = new BorderPane();
		pane.setPrefSize(850, 550);
		
		HBox hBoxTop = initComponentesTop();
		pane.setTop(hBoxTop);
		

		
		//parte lateral esquerda
		buttonUserName = new Button(getUserLogged().getName() +" "+getUserLogged().getSurname());
		buttonFeed = new Button("Feed de Noticias");
		buttonMessenger = new Button("Messenger");
		buttonWatch = new Button("Watch");
		buttonMarketplace = new Button("MarketPlace");
		buttonGroups = new Button("Grupos");
		buttonCampaign = new Button("Campanha de arr...");
		buttonPages = new Button("Páginas");
		buttonEvents = new Button("Eventos");
		buttonListFriends = new Button("Lista de Amigos");
		buttonSeeMore = new Button("Ver mais...");
		
		labelExplorar = new Label("Explorar");
		
		
	}
	
	private HBox initComponentesTop() {
    	HBox top = new HBox(20);
    	
		labelLogoTipo = new Label("Facebook");
		labelLogoTipo.setAlignment(Pos.TOP_RIGHT);
		
		textFieldSearch = new TextField();
		textFieldSearch.setPromptText("Procurar...");
		textFieldSearch.setPrefSize(250, 25);
		textFieldSearch.setAlignment(Pos.TOP_RIGHT);
		
		buttonSearch = new Button("Pesquisar");
		buttonSearch.setAlignment(Pos.TOP_RIGHT);
		
		buttonUserPerfil = new Button(getUserLogged().getName());
		buttonUserPerfil.setAlignment(Pos.TOP_RIGHT);
		
		buttonPagInitial = new Button("Página Inicial");
		buttonPagInitial.setAlignment(Pos.TOP_RIGHT);
		
		buttonCreate = new Button("Criar");
		buttonCreate.setAlignment(Pos.TOP_RIGHT);
		
		labelFriends = new Label();
		
		labelMessenger = new Label();
		
		labelNotifications = new Label();
		
		labelHelp = new Label();
		
		buttonExit = new Button("Sair");
		buttonExit.setAlignment(Pos.TOP_RIGHT);
		
		top.getChildren().addAll(labelLogoTipo, textFieldSearch, buttonSearch, buttonUserPerfil,
				buttonPagInitial, buttonCreate, buttonExit);
		
		return top;
	}
	
	public void initLayouts(){
		
		/*labelLogoTipo.setLayoutX(10);
		labelLogoTipo.setLayoutY(10);
		
		textFieldSearch.setLayoutX(70);
		textFieldSearch.setLayoutY(10);
		textFieldSearch.setPrefSize(250, 25);
		
		buttonSearch.setLayoutX(323);
		buttonSearch.setLayoutY(10);
		
		buttonUserPerfil.setLayoutX(415);
		buttonUserPerfil.setLayoutY(10);
		
		buttonPagInitial.setLayoutX(480);
		buttonPagInitial.setLayoutY(10);*/
		
		//parte lateral esqueda
		
		buttonUserName.setLayoutX(5);
		buttonUserName.setLayoutY(40);
		
		buttonFeed.setLayoutX(5);
		buttonFeed.setLayoutY(80);
		
		buttonMessenger.setLayoutX(5);
		buttonMessenger.setLayoutY(120);
		
		buttonWatch.setLayoutX(5);
		buttonWatch.setLayoutY(160);
		
		buttonMarketplace.setLayoutX(5);
		buttonMarketplace.setLayoutY(200);
		
		labelExplorar.setLayoutX(5);
		labelExplorar.setLayoutY(240);
		
		buttonGroups.setLayoutX(5);
		buttonGroups.setLayoutY(280);
		
		buttonCampaign.setLayoutX(5);
		buttonCampaign.setLayoutY(320);
		
		buttonPages.setLayoutX(5);
		buttonPages.setLayoutY(360);
		
		buttonEvents.setLayoutX(5);
		buttonEvents.setLayoutY(400);
		
		buttonListFriends.setLayoutX(5);
		buttonListFriends.setLayoutY(440);
		
		buttonSeeMore.setLayoutX(5);
		buttonSeeMore.setLayoutY(480);
		
		
		
		
		
		
	//	pane.getChildren().addAll(labelLogoTipo, textFieldSearch, buttonSearch, buttonUserPerfil,
	//			buttonPagInitial, buttonUserName, buttonFeed, buttonMessenger, buttonWatch, 
	//			buttonMarketplace, labelExplorar, buttonGroups, buttonCampaign, buttonPages, 
	//			buttonEvents, buttonListFriends, buttonSeeMore);
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
	    	stage.setResizable(true);
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
