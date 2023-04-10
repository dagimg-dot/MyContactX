package components.container;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Container extends Pane{
  public Container (Scene scene, Double widthPercentage, Double heightPercentage) {
    super();
    setPrefWidth(scene.getWidth() * widthPercentage);
    setPrefHeight(scene.getHeight() * heightPercentage);
    setStyle("-fx-background-color: #D9D9D9; -fx-background-radius: 10;");
  }
}