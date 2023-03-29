import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import components.search.SearchTextField;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        primaryStage.setTitle("Contact Manager");
        primaryStage.setResizable(false);    // disabled resizing: because it's not supported yet and i am copying the coordinates and the size of the window from the design (figma)

        // first rectangle - main window
        Rectangle mainWindow = new Rectangle(24,17, 897, 905);
        mainWindow.setFill(Color.valueOf("D9D9D9"));
        mainWindow.setArcHeight(15);
        mainWindow.setArcWidth(15);

        // element 1 - search bar (inside main window) -> text field
        SearchTextField searchBar = new SearchTextField("Search", 361, 58, 281, 33);
        searchBar.getStylesheets().add("components/search/SearchTextField.css");

        /*
         * search icon is not added yet, because i don't know how.
         * some one should add it.
         */

        // element 2 - hamburger menu (inside main window) -> button
        /*
         * hamburger menu is not added yet.
         * some one should add it.
         */
        
        // second rectangle - bottom bar
        Rectangle bottomBar = new Rectangle(24, 936, 897, 71);
        bottomBar.setFill(Color.valueOf("D9D9D9"));
        bottomBar.setArcHeight(15);
        bottomBar.setArcWidth(15);
        
        // third rectangle - left bar
        Rectangle leftBar = new Rectangle(937, 17, 478, 990);
        leftBar.setFill(Color.valueOf("D9D9D9"));
        leftBar.setArcHeight(15);
        leftBar.setArcWidth(15);
        
        // add rectangles to root
        root.getChildren().addAll(mainWindow,bottomBar,leftBar,searchBar);
        
        Scene scene = new Scene(root, 1440, 1024);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
