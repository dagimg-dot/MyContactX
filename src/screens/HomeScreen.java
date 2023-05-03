package screens;

import components.container._container.ContainerFactory;
import components.container.bottomBar.BottomBar;
import components.container.leftBar.LeftBar;
import components.container.mainContainer.MainContainer;
import components.container.popUp.EditContactForm;
import components.container.popUp.NewContactForm;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class HomeScreen {
    public static boolean isNewContactFormVisible = false;
    public static boolean isEditContactFormVisible = false;
    public static NewContactForm newContactForm;
    public static EditContactForm editContactForm;

    public static void build(Stage primaryStage) {
        // set the title of the window
        primaryStage.setTitle("MyContactX");

        // create the root node
        AnchorPane root = new AnchorPane(); 

        // create the scene 
        Scene scene = new Scene(root, 1200,768);
        
       // set the min width and height of the stage
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(768);

        // create the grid
        GridPane grid = new GridPane();

        // create container to be added to the grid
        ContainerFactory containerFactory = new ContainerFactory(scene);

        // create the main container and render it
        MainContainer mainContainer = (MainContainer) containerFactory.getType("MAIN");
        mainContainer.render(grid);

        // create the bottom container and render it
        BottomBar bottomBar = (BottomBar) containerFactory.getType("BOTTOM");
        bottomBar.render(grid);

        // create the left container and render it
        LeftBar leftBar = (LeftBar) containerFactory.getType("LEFT");
        leftBar.render(grid);

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

        // create a new contact form 
        newContactForm =  new NewContactForm(root, 450, 650);
        
        // create a edit contact form
        editContactForm =  new EditContactForm(root, 450, 650);
        

        // Add the GridPane to the root
        root.getChildren().add(grid);

        // render the new contact form and hide it
        newContactForm.render();
        newContactForm.setVisible(false);
        
        // render the edit contact form and hide it
        editContactForm.render();
        editContactForm.setVisible(false);
        
        // set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void hideNewContactForm() {
        newContactForm.setVisible(false);
        isNewContactFormVisible = false;
    }

    public static void hideEditContactForm() {
        editContactForm.setVisible(false);
        isEditContactFormVisible = false;
    }

    public static void showNewContactForm() {
        if (isEditContactFormVisible) {
            return;
        }
        if(!isNewContactFormVisible) {
            newContactForm.setVisible(true);
            isNewContactFormVisible = true;
            return;
        }
    }

    public static void showEditContactForm() {
        if (isNewContactFormVisible) {
            return;
        }
        if(!isEditContactFormVisible) {
            editContactForm.setVisible(false);
            isEditContactFormVisible = false;
            return;
        }
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