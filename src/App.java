import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import components.search.SearchTextField;
import components.container.ContainerFactory;
import components.container.Container;


public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Contact Manager");

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, 1200,768);
        
        // set the min width and height of the window

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(768);
        
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

        // add the search text field to the main container

        SearchTextField searchTextField = new SearchTextField("Search", 250, 28);
        searchTextField.setPosition(mainContainer.getWidth(), mainContainer.getHeight());

        mainContainer.getChildren().add(searchTextField);

    }

    public void setConstraints(GridPane grid, Scene scene) {
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
