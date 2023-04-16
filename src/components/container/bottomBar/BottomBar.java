package components.container.bottomBar;

import components.container._container.Container;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class BottomBar extends Container {
    public BottomBar(Scene scene, double widthPercentage, double heightPercentage) {
        super(scene, widthPercentage, heightPercentage);
        setPrefWidth(scene.getWidth() * widthPercentage);
        setPrefHeight(scene.getHeight() * heightPercentage);
        this.getStylesheets().add("components/container/_container/Container.css");
        this.getStyleClass().add("container");
    }

    public void render(Scene scene, GridPane grid) {
        grid.add(this, 0, 1);
    };
}