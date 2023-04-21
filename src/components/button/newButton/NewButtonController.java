package components.button.newButton;

import controller.Controller;
import screens.HomeScreen;

public class NewButtonController implements Controller {

    public void onClick() {
        // Test
        System.out.println("New button clicked");

        HomeScreen.showNewContactForm();
    }
}