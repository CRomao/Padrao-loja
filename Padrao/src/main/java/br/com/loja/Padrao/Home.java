package br.com.loja.Padrao;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		VBox vBoxMenu = initComponentsMenu();
		pane.setLeft(vBoxMenu);
		vBoxMenu.setAlignment(Pos.TOP_LEFT);
		
		VBox vBoxPosts = initComponentsPosts();
		pane.setCenter(vBoxPosts);
		vBoxPosts.setAlignment(Pos.CENTER);	
		
		VBox vBoxMenuRight = initComponentsRight();
		pane.setRight(vBoxMenuRight);
		vBoxMenuRight.setAlignment(Pos.TOP_RIGHT);
		
		
	}
	
	private HBox initComponentesTop() {
    	HBox top = new HBox(20);
    	
		labelLogoTipo = new Label("Facebook");
		labelLogoTipo.setAlignment(Pos.TOP_LEFT);
		
		textFieldSearch = new TextField();
		textFieldSearch.setPromptText("Procurar...");
		textFieldSearch.setPrefSize(250, 25);
		textFieldSearch.setAlignment(Pos.TOP_LEFT);
		
		buttonSearch = new Button("Pesquisar");
		buttonSearch.setAlignment(Pos.TOP_LEFT);
		
		buttonUserPerfil = new Button(getUserLogged().getName());
		buttonUserPerfil.setAlignment(Pos.TOP_LEFT);
		
		buttonPagInitial = new Button("Página Inicial");
		buttonPagInitial.setAlignment(Pos.TOP_LEFT);
		
		buttonCreate = new Button("Criar");
		buttonCreate.setAlignment(Pos.TOP_LEFT);
		
		labelFriends = new Label();
		
		labelMessenger = new Label();
		
		labelNotifications = new Label();
		
		labelHelp = new Label();
		
		buttonExit = new Button("Sair");
		buttonExit.setAlignment(Pos.TOP_LEFT);
		
		top.getChildren().addAll(labelLogoTipo, textFieldSearch, buttonSearch, buttonUserPerfil,
				buttonPagInitial, buttonCreate, buttonExit);
		
		return top;
	}
	
    private VBox initComponentsMenu() {
    	VBox vBoxMenu = new VBox(20);
    	//parte lateral esquerda
		buttonUserName = new Button(getUserLogged().getName() +" "+getUserLogged().getSurname());
		buttonUserName.setPrefSize(200, 30);
		buttonFeed = new Button("Feed de Noticias");
		buttonFeed.setPrefSize(200, 30);
		buttonMessenger = new Button("Messenger");
		buttonMessenger.setPrefSize(200, 30);
		buttonWatch = new Button("Watch");
		buttonWatch.setPrefSize(200, 30);
		buttonMarketplace = new Button("MarketPlace");
		buttonMarketplace.setPrefSize(200, 30);
		buttonGroups = new Button("Grupos");
		buttonGroups.setPrefSize(200, 30);
		buttonCampaign = new Button("Campanha de arr...");
		buttonCampaign.setPrefSize(200, 30);
		buttonPages = new Button("Páginas");
		buttonPages.setPrefSize(200, 30);
		buttonEvents = new Button("Eventos");
		buttonEvents.setPrefSize(200, 30);
		buttonListFriends = new Button("Lista de Amigos");
		buttonListFriends.setPrefSize(200, 30);
		buttonSeeMore = new Button("Ver mais...");
		buttonSeeMore.setPrefSize(200, 30);
		
		labelExplorar = new Label("Explorar");
		
		vBoxMenu.getChildren().addAll(buttonUserName, buttonFeed, buttonMessenger, buttonWatch, 
				buttonMarketplace, labelExplorar, buttonGroups, buttonCampaign, buttonPages, 
				buttonEvents, buttonListFriends, buttonSeeMore);
		return vBoxMenu;
	}
    
    private VBox initComponentsRight() {
    	VBox vBoxMenu = new VBox(20);
    	//parte lateral esquerda

		
 		Button buttonInformationRight = new Button("Aniversariantes");
 		buttonInformationRight.setPrefSize(200, 30);
 		Button buttonInformationRight2 = new Button("Mais relevantes no MarketPlace");
 		buttonInformationRight2.setPrefSize(200, 30);
 		Button buttonInformationRight3 = new Button("Patrocinado");
 		buttonInformationRight3.setPrefSize(200, 30);
 		Button buttonInformationRight4 = new Button("Anúncio");
 		buttonInformationRight4.setPrefSize(200, 30);
 		TextArea textAreaPostRight = new TextArea();
 		textAreaPostRight.setPromptText("Pesoas que curtiram a foto do momento");
 		textAreaPostRight.setPrefSize(200, 150);
 		TextArea textAreaPostRight2 = new TextArea();
 		textAreaPostRight2.setPromptText("Pesoas que curtiram a foto do momento");
 		textAreaPostRight2.setPrefSize(200, 150);
 		
 		
 		vBoxMenu.getChildren().addAll(buttonInformationRight, buttonInformationRight2,
 				buttonInformationRight3, buttonInformationRight4,textAreaPostRight, 
 				textAreaPostRight2);
		return vBoxMenu;
	}
    
    private VBox initComponentsPosts() {
 		VBox vBoxMenu = new VBox(20);
 		TextArea textAreaPost = new TextArea();
 		textAreaPost.setPromptText("No que você está pensando, Cicero?");
 		
 		TextArea textAreaPost2 = new TextArea();
 		textAreaPost2.setPromptText("Stories");
 		
 		TextArea textAreaPost3 = new TextArea();
 		textAreaPost3.setPromptText("Publicação");
 		
 		TextArea textAreaPost4 = new TextArea();
 		textAreaPost4.setPromptText("Publicação");
 		
 		vBoxMenu.getChildren().addAll(textAreaPost, textAreaPost2,textAreaPost3, textAreaPost4);
 		return vBoxMenu;
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
