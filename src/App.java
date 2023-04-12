import javafx.application.Application;
import javafx.stage.Stage;
import screens.HomeScreen;


public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HomeScreen.build(primaryStage);
    }
}
