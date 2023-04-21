package components.container.popUp;

import components.button.newButton.NewButtonController;
import components.container._container.Container;
import javafx.scene.layout.AnchorPane;

public class NewContactForm extends Container {
    public AnchorPane root;
    public NewButtonController newButtonController;

    public NewContactForm(AnchorPane root, double formWidth, double formHeight) {
        super(root, formHeight, formHeight);
        this.root = root;
        this.setPrefSize(formWidth, formHeight);
        AnchorPane.setLeftAnchor(this,((root.getWidth() - formWidth) / 2));
        AnchorPane.setTopAnchor(this,((root.getHeight() - formHeight) / 2));
        this.setStyle("-fx-background-color: white;-fx-background-radius: 18; -fx-border-color: #5B5B5B; -fx-border-radius: 15; -fx-border-width: 6"); 
        
        // add listener to window width and height properties so that the new contact form is always centered
        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            // adjust pane layoutX property
            AnchorPane.setLeftAnchor(this,((newVal.doubleValue() - this.getPrefWidth()) / 2));
        });

        root.heightProperty().addListener((obs, oldVal, newVal) -> {
            // adjust pane layoutY property
            AnchorPane.setTopAnchor(this,((newVal.doubleValue() - this.getPrefHeight()) / 2));
        });
        
    }
    
    public void render() {
        root.getChildren().add(this);        
    }
}