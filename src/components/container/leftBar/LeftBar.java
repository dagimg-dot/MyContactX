package components.container.leftBar;

import components.container._container.Container;
import components.text.TextGenerator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LeftBar extends Container{
    public LeftBar(Scene scene, double widthPercentage, double heightPercentage) {
        super(scene, widthPercentage, heightPercentage);
        setPrefWidth(scene.getWidth() * widthPercentage);
        setPrefHeight(scene.getHeight() * heightPercentage);
        this.getStylesheets().add("components/container/_container/Container.css");
        this.getStyleClass().add("container");
    }

    public void render(Scene scene, GridPane grid) { 
        grid.add(this, 1, 0, 1, 2);


        VBox leftBarContainer = new VBox();
        leftBarContainer.prefWidthProperty().bind(this.widthProperty());
        leftBarContainer.prefHeightProperty().bind(this.heightProperty());
        leftBarContainer.setStyle("-fx-background-color: #D9D9D9; -fx-background-radius: 15;");

        
        HBox title = new HBox();
        
        // set the height and width of the title
        title.setPrefHeight(this.getPrefHeight() / 15);
        title.prefWidthProperty().bind(leftBarContainer.prefWidthProperty());

        // create the title text
        Text details = TextGenerator.generateText("Details");

        // set the alignment of the title
        title.setAlignment(Pos.CENTER);
        
        // add the title text to the title HBox
        title.getChildren().add(details);

        // set margin for the title
        VBox.setMargin(title, new Insets(10,10,10,10));

        // set the style of the title
        title.setStyle("-fx-background-color: #9B9595; -fx-background-radius: 15;");

        // add the title to the left bar container
        leftBarContainer.getChildren().addAll(title);
        this.getChildren().addAll(leftBarContainer);

    };
}