package components.icon.searchIcon;

import controller.Controller;

public class SearchIconController implements Controller {
    public SearchIconController() {
        super();
    }

    public void onClick() {
        search();
    }

    public void search() {
        System.out.println("Searching");
    }
}