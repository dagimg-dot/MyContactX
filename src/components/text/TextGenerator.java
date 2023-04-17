package components.text;

import javafx.scene.text.Text;

public class TextGenerator {
    public static Text generateText(String text, int fontSize, String fontColor, String fontFamily) {
        Text _text = new Text(text);
        _text.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: " + fontColor + "; -fx-font-family: " + fontFamily + ";");
        return _text;
    }
}