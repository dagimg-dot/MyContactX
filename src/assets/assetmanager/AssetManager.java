package assets.assetmanager;

import javafx.scene.text.Font;

public class AssetManager {
    public Font getFont(String fontName, int fontSize) {
        Font regularFont = Font.loadFont(getClass().getResourceAsStream("/assets/fonts/" + fontName + ".ttf"), fontSize);
        // Font regularFont = Font.loadFont(AssetManager.class.getResourceAsStream("/assets/fonts/Inter-Medium.ttf"), fontSize);
        return regularFont;
    }
}