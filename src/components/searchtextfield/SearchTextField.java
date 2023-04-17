package components.searchtextfield;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class SearchTextField extends TextField {
    
    public SearchTextField(String promptText, double width, double height) {
        super();
        setPrefSize(width, height);
        setPromptText(promptText);
        setAlignment(Pos.CENTER);
        this.getStylesheets().add("components/searchtextfield/SearchTextField.css");
        this.getStyleClass().add("search-text-field");
    }
}