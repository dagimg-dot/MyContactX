package components.text;

import javafx.scene.text.Text;

public class TextGenerator {
    public static Text generateText(String text, int fontSize, String fontColor, String fontFamily, String fontWeight) {
        Text _text = new Text(text);
        _text.setStyle("-fx-font-size: " + fontSize + "px; -fx-color: " + fontColor + "; -fx-font-family: " + fontFamily + ";" + " -fx-font-weight: " + fontWeight + ";");
        return _text;
    }
    
    public static Text generateText(String text) {
        Text _text = new Text(text);
        _text.setStyle("-fx-font-size: " + 20 + "px; -fx-color: " + "#000000" + "; -fx-font-family: " + "Times New Roman" + ";");
        return _text;
    }
}