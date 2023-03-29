package components.search;

import javafx.scene.control.TextField;

public class SearchTextField extends TextField {
    
    public SearchTextField(String promptText, double width, double height, double layoutX, double layoutY) {
        super();
        setPrefSize(width, height);
        setLayoutX(layoutX);
        setLayoutY(layoutY);
        setPromptText(promptText);
        this.getStyleClass().add("search-text-field");
    }
}