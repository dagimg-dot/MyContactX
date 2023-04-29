package components.container.mainContainer;


import StateX.StateX;
import components.button._button.ButtonFactory;
import components.container._container.Container;
import components.container.contactList.ContactList;
import components.icon.HamburgerMenuIcon.HamburgerMenuController;
import components.icon._icon.CustomIcon;
import components.icon.searchIcon.SearchIconController;
import components.textfield.searchtextfield.SearchTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainContainer extends Container{
    public Scene scene;
    public MainContainer(Scene scene, double widthPercentage, double heightPercentage) {
        super(scene, widthPercentage, heightPercentage);
        this.scene = scene;
        setPrefWidth(scene.getWidth() * widthPercentage);
        setPrefHeight(scene.getHeight() * heightPercentage);
        this.getStylesheets().add("components/container/_container/Container.css");
        this.getStyleClass().add("container");
    }

    
    public void render(GridPane grid) {
        grid.add(this, 0, 0);
        VBox rows = new VBox(); 
        rows.setSpacing(5);
        rows.prefHeightProperty().bind(this.heightProperty());

        // create the header HBox
        HBox mainContainerHeader = new HBox();
        mainContainerHeader.setPrefSize(scene.getWidth()*0.65, scene.getHeight()*0.1);
        HBox iconButton = new HBox();
        HBox searchField = new HBox();
        
        // create the hamburger menu icon
        CustomIcon hamburgerMenu = new CustomIcon(FontAwesomeIcons.BARS, "3em", Color.BLACK, new HamburgerMenuController());
        FontAwesomeIcon hamburgerMenuIcon =  hamburgerMenu.build("hamburger-menu-icon");

        // set margin for the hamburger menu icon
        HBox.setMargin(hamburgerMenuIcon, new Insets(20, 10, 10, 15));

        // add the hamburger menu icon to the iconButton HBox
        iconButton.getChildren().add(hamburgerMenuIcon);

        // add the iconButton HBox to the main container header HBox
        mainContainerHeader.getChildren().add(iconButton);
        
        // create the search text field
        SearchTextField searchTextField = new SearchTextField("Search", 250, 28);
        
        // pass the search text field to the SearchIconController constructor
        SearchIconController searchIconController = new SearchIconController(searchTextField);

        // create the search icon
        CustomIcon search = new CustomIcon(FontAwesomeIcons.SEARCH, "1.5em", Color.valueOf("#625E5E"), searchIconController);
        FontAwesomeIcon searchIcon =  search.build("search-icon");
        
        // wrap the search icon in an HBox
        HBox searchIconHBox = new HBox();
        searchIconHBox.setPrefSize(45,45);
        searchIconHBox.setMaxHeight(45);
        searchIconHBox.getChildren().add(searchIcon);
        searchIconHBox.getStylesheets().add("components/icon/searchIcon/searchIcon.css");
        searchIconHBox.getStyleClass().add("search-icon");

        // center the search icon in the HBox
        searchIconHBox.setAlignment(Pos.CENTER);
        
        // set margin for the search icon 
        HBox.setMargin(searchIconHBox, new Insets(0, 0, 0, 5));

        // add the search text field to the searchField HBox
        searchField.getChildren().addAll(searchTextField,searchIconHBox);


        // add the searchField HBox to the main container header HBox
        mainContainerHeader.getChildren().add(searchField);


        // center the search text field in the header HBox
        searchField.setAlignment(Pos.CENTER);    
        
        // set the width of the header HBox relative to the width of the main container
        mainContainerHeader.prefWidthProperty().bind(this.widthProperty());

        // set the width of the search text field relative to the width of the header HBox
        searchField.prefWidthProperty().bind(mainContainerHeader.widthProperty());

        // create the titles HBox
        HBox titles = new HBox();
        titles.prefWidthProperty().bind(this.widthProperty());
        titles.setPadding(new Insets(0,0,10,0));

        // center the titles HBox vertically and horizontally
        titles.setAlignment(Pos.CENTER);


        // create the buttons
        ButtonFactory buttonFactory = new ButtonFactory();
        
        Button nameButton = buttonFactory.createButton("Name", 210.0, 28.0);
        Button phoneButton = buttonFactory.createButton("Phone No.", 210.0, 28.0);
        Button groupButton = buttonFactory.createButton("Group", 210.0, 28.0);
        

        // set the width of the buttons relative to the width of the titles HBox
        nameButton.prefWidthProperty().bind(titles.widthProperty().divide(3));
        phoneButton.prefWidthProperty().bind(titles.widthProperty().divide(3));
        groupButton.prefWidthProperty().bind(titles.widthProperty().divide(3));

        // make some space between the buttons
        HBox.setMargin(nameButton, new Insets( 0, 0, 0, 15));
        HBox.setMargin(phoneButton, new Insets( 0, 0, 0, 25));
        HBox.setMargin(groupButton, new Insets( 0, 15, 0, 25));

        // add the buttons to the titles HBox
        titles.getChildren().addAll(nameButton, phoneButton, groupButton);

        // create the contacts list using scroll pane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background: #D9D9D9; -fx-border-color: #D9D9D9;-fx-background-radius: 15;");
        
        scrollPane.maxWidthProperty().bind(this.widthProperty());
    
        // create the VBox that will contain the contacts list
        VBox vbox = new VBox();
        StateX.contactVBox = vbox; 
        vbox.setSpacing(7);
        vbox.setPadding(new Insets(0,5,5,15));
        vbox.setStyle("-fx-background-radius: 15;");
        
        // render the contacts list
        ContactList contactList = new ContactList(this);
        contactList.render(vbox, scene, scrollPane);

        // add the sample HBox to the scroll pane with a width of 100% and a height of 100%
        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // add the header HBox and the titles HBox to the rows VBox
        rows.getChildren().addAll(mainContainerHeader,titles,scrollPane);
        
        // add all the rows to the main container
        this.getChildren().add(rows);

    }
}    