package components.container._container;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class Container extends Pane{
  public Container(Scene scene, double widthPercentage, double heightPercentage) {
    super();
  }

  public Container(AnchorPane root, double formWidth, double formHeight) {
    super();
  }

  public void render() { 
  };
}