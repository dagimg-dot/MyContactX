package components.search;

import javafx.scene.control.TextField;

public class SearchTextField extends TextField {
    private Double _width;
    
    public SearchTextField(String promptText, double width, double height) {
        super();
        this._width = width;
        setPrefSize(width, height);
        setPromptText(promptText);
        this.getStylesheets().add("components/search/SearchTextField.css");
        this.getStyleClass().add("search-text-field");
    }

    public void setPosition(double mWidth, double mHeight) {
        this.setLayoutX((mWidth - _width)/2);
        this.setLayoutY(mHeight*0.03);
    }
}