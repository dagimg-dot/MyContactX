package components.search;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SearchTextField extends TextField {
    private Pane searchIconContainer;
    
    public SearchTextField(String promptText, double width, double height) {
        super();
        setPrefSize(width, height);
        FontAwesomeIcon searchIcon = new FontAwesomeIcon();
        searchIcon.setIcon(FontAwesomeIcons.SEARCH);
        searchIcon.setFill(Color.valueOf("#625E5E"));
        searchIconContainer = new HBox(searchIcon);
        searchIconContainer.getStyleClass().add("pane");
        searchIconContainer.getStyleClass().add("search-icon-container");
        getChildren().add(0,searchIconContainer);
        setPromptText(promptText);
        setAlignment(Pos.CENTER);
        this.getStylesheets().add("components/search/SearchTextField.css");
        this.getStyleClass().add("search-text-field");
    }
}