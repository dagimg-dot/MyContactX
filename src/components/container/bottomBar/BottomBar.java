package components.container.bottomBar;

import components.button._button.ButtonFactory;
import components.container._container.Container;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BottomBar extends Container {
    public Scene scene;
    
    public BottomBar(Scene scene, double widthPercentage, double heightPercentage) {
        super(scene, widthPercentage, heightPercentage);
        this.scene = scene;
        setPrefWidth(scene.getWidth() * widthPercentage);
        setPrefHeight(scene.getHeight() * heightPercentage);
        this.getStylesheets().add("components/container/_container/Container.css");
        this.getStyleClass().add("container");
    }

    public void render(GridPane grid) {
        grid.add(this, 0, 1);

        HBox buttonContainer = new HBox();

        buttonContainer.prefWidthProperty().bind(this.widthProperty());
        buttonContainer.prefHeightProperty().bind(this.heightProperty());

        ButtonFactory buttonFactory = new ButtonFactory();
        // create the three buttons (new, edit, delete)
        Button newButton = buttonFactory.createButton("New", 100.0, 28.0);
        Button editButton = buttonFactory.createButton("Edit", 100.0, 28.0);
        Button deleteButton = buttonFactory.createButton("Delete", 100.0, 28.0);

        newButton.prefWidthProperty().bind(buttonContainer.widthProperty().divide(6));
        editButton.prefWidthProperty().bind(buttonContainer.widthProperty().divide(6));
        deleteButton.prefWidthProperty().bind(buttonContainer.widthProperty().divide(6));
        
        // set margin for the buttons created
        HBox.setMargin(newButton, new Insets( 0, 0, 0, 15));
        HBox.setMargin(editButton, new Insets( 0, 0, 0, 25));
        HBox.setMargin(deleteButton, new Insets( 0, 15, 0, 25));

        // add the buttons to the buttonContainer HBox
        buttonContainer.getChildren().addAll(newButton,editButton,deleteButton);

        // add the buttonContainer to the left bar
        this.getChildren().addAll(buttonContainer);

        buttonContainer.setAlignment(Pos.CENTER);
    };
}