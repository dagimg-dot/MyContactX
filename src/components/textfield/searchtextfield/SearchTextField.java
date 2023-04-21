package components.textfield.searchtextfield;

import components.textfield._textfield.CustomTextField;
import javafx.geometry.Pos;

public class SearchTextField extends CustomTextField {
    
    public SearchTextField(String promptText, double width, double height) {
        super(promptText);
        setPrefSize(width, height);
        setAlignment(Pos.CENTER);
        this.getStylesheets().add("components/textfield/searchtextfield/SearchTextField.css");
        this.getStyleClass().add("search-text-field");
    }
}