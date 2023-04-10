package components.container;

import javafx.scene.Scene;

public class ContainerFactory {
    public Scene scene;

    public ContainerFactory (Scene scene) {
        this.scene = scene;
    }

    public Container getType(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("MAIN")) {
            return new Container(this.scene, 0.65, 0.9);
        } else if (type.equalsIgnoreCase("BOTTOM")) {
            return new Container(this.scene, 0.65, 0.1);
        } else if (type.equalsIgnoreCase("LEFT")) {
            return new Container(this.scene, 0.35, 1.0);
        }
        return null;
    }
}
