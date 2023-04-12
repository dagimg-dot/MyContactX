package components.HamburgerMenuIcon;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.paint.Color;

public class HamburgerMenuIcon{
    public HamburgerMenuController hamburgerMenuController;
    public String size;
    public Color color;
    public FontAwesomeIcons icon;

    public HamburgerMenuIcon(FontAwesomeIcons icon, String size, Color color) {
        this.hamburgerMenuController = new HamburgerMenuController();
        this.size = size;
        this.color = color;
        this.icon = icon;
    }

    public FontAwesomeIcon build() {
        FontAwesomeIcon hamburgerMenuIcon = new FontAwesomeIcon();
        hamburgerMenuIcon.setIcon(this.icon);
        hamburgerMenuIcon.setSize(this.size);
        hamburgerMenuIcon.setFill(this.color);
        hamburgerMenuIcon.setOnMouseClicked(e -> this.hamburgerMenuController.openMenu());

        return hamburgerMenuIcon;
    }


}