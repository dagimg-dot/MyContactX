package screens;

import components.HamburgerMenuIcon.HamburgerMenuIcon;
import components.container.Container;
import components.container.ContainerFactory;
import components.search.SearchTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeScreen {
    public static void build(Stage primaryStage) {
        // set the title of the window
        primaryStage.setTitle("Contact Manager");

        // create the root node
        AnchorPane root = new AnchorPane();

        // create the scene
        Scene scene = new Scene(root, 1200,768);
        
        // set the min width and height of the window
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(768);

        // create the grid
        GridPane grid = new GridPane();

        // create container to be added to the grid
        ContainerFactory containerFactory = new ContainerFactory(scene);

        Container mainContainer = containerFactory.getType("MAIN");
        Container bottomContainer = containerFactory.getType("BOTTOM");
        Container leftContainer = containerFactory.getType("LEFT");

        // add the containers to the grid
        grid.add(mainContainer, 0, 0);
        grid.add(bottomContainer, 0, 1);
        grid.add(leftContainer, 1, 0, 1, 2);

        // Set the column and row constraints for the GridPane
        setConstraints(grid, scene);

        // set padding for the anchor pane
        AnchorPane.setTopAnchor(grid, 15.0);
        AnchorPane.setBottomAnchor(grid, 15.0);
        AnchorPane.setLeftAnchor(grid, 15.0);
        AnchorPane.setRightAnchor(grid, 15.0);

        // set the gap between the rows and columns
        grid.setHgap(15);
        grid.setVgap(15);

        // Add the GridPane to the root
        root.getChildren().add(grid);

        // set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();

        // create the mainContainer components
        drawComponentsMain(mainContainer, scene);

        // create the bottomContainer components
        // drawComponentsBottom(bottomContainer, scene);

        // create the leftContainer components
        // drawComponentsLeft(leftContainer, scene);

    }

    public static void drawComponentsMain(Container mainContainer, Scene scene) {
        // create the header HBox
        HBox mainContainerHeader = new HBox();
        mainContainerHeader.setPrefSize(scene.getWidth()*0.65, scene.getHeight()*0.1);
        HBox iconButton = new HBox();
        HBox searchField = new HBox();
        
        // create the hamburger menu icon
        HamburgerMenuIcon hamburgerMenu = new HamburgerMenuIcon(FontAwesomeIcons.BARS, "3em", Color.BLACK);
        FontAwesomeIcon hamburgerMenuIcon =  hamburgerMenu.build();
        
        // set margin for the hamburger menu icon
        HBox.setMargin(hamburgerMenuIcon, new Insets(20, 10, 10, 15));

        // add the hamburger menu icon to the iconButton HBox
        iconButton.getChildren().add(hamburgerMenuIcon);

        // add the iconButton HBox to the main container header HBox
        mainContainerHeader.getChildren().add(iconButton);
        
        // create the search text field
        SearchTextField searchTextField = new SearchTextField("Search", 250, 28);

        // add the search text field to the searchField HBox
        searchField.getChildren().add(searchTextField);

        // add the searchField HBox to the main container header HBox
        mainContainerHeader.getChildren().add(searchField);

        // center the search text field in the header HBox
        searchField.setAlignment(Pos.CENTER);    

        // set the width of the header HBox relative to the width of the main container
        mainContainerHeader.prefWidthProperty().bind(mainContainer.widthProperty());

        // set the width of the search text field relative to the width of the header HBox
        searchField.prefWidthProperty().bind(mainContainerHeader.widthProperty());

        // add all the rows to the main container
        mainContainer.getChildren().add(mainContainerHeader);
    }

    public static void setConstraints(GridPane grid, Scene scene) {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(scene.getWidth() * 0.65);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(scene.getWidth() * 0.35);

        grid.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(scene.getHeight() * 0.9);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(scene.getHeight() * 0.1);

        grid.getRowConstraints().addAll(row1, row2);


    }
}