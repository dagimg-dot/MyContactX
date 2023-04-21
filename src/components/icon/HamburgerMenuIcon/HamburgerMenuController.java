package components.icon.HamburgerMenuIcon;

import controller.Controller;

public class HamburgerMenuController implements Controller {
    public HamburgerMenuController() {
        super();
    }
    
    public void onClick() {
        openMenu();
    }


    public void openMenu() {
        System.out.println("Open Menu");
    }
}