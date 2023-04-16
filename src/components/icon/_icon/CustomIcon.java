package components.icon._icon;

import components.icon.HamburgerMenuIcon.HamburgerMenuController;
import components.icon.searchIcon.SearchIconController;
import controller.Controller;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.paint.Color;

public class CustomIcon {
    public String size;
    public Color color;
    public FontAwesomeIcons icon;
    public Controller controller;

    public CustomIcon(FontAwesomeIcons icon, String size, Color color, Controller controller) {
        this.size = size;
        this.color = color;
        this.icon = icon;
        this.controller = controller;
    }

    public FontAwesomeIcon build(String type) {
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setSize(this.size);
        icon.setFill(this.color);
        icon.setIcon(this.icon);
        if (type.equalsIgnoreCase("hamburger-menu-icon")) {
            icon.setOnMouseClicked(e -> ((HamburgerMenuController) this.controller).openMenu());
        } else if (type.equalsIgnoreCase("search-icon")) {
            icon.setOnMouseClicked(e -> ((SearchIconController) this.controller).search());
        }


        return icon;
    }


}