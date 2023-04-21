package components.icon._icon;

import components.icon.HamburgerMenuIcon.HamburgerMenuController;
import components.icon.searchIcon.SearchIconController;
import controller.Controller;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class CustomIcon {
    public String size;
    public int sizeInt;
    public String iconName;
    public Color color;
    public FontAwesomeIcons icon;
    public Controller controller;

    // constructor for font awesome icons with a click event
    public CustomIcon(FontAwesomeIcons icon, String size, Color color, Controller controller) {
        this.size = size;
        this.color = color;
        this.icon = icon;
        this.controller = controller;
    }

    // constructor for font awesome icons without a click event
    public CustomIcon(FontAwesomeIcons icon, String size, Color color) {
        this.size = size;
        this.color = color;
        this.icon = icon;
    }

    // constructor for icons from file without a click event
    public CustomIcon(String iconName, int size, Color color) {
        this.iconName = iconName;
        this.sizeInt = size;
        this.color = color;
    }


    // this method is used to build the font awesome icon with a click event
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

    // this method is used to build the font awesome icon without a click event
    public FontAwesomeIcon build() {
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setSize(this.size);
        icon.setFill(this.color);
        icon.setIcon(this.icon);

        return icon;
    }

    // this method is used to build the icon from file without a click event
    public SVGPath build(String type, String path) {
        SVGPath icon = new SVGPath();
        icon.setContent(path);
        icon.setFill(this.color);
        icon.setScaleX(this.sizeInt);
        icon.setScaleY(this.sizeInt);

        return icon;
    }

}