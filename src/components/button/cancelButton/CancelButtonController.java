package components.button.cancelButton;

import controller.Controller;
import screens.HomeScreen;

public class CancelButtonController implements Controller {
    public void onClick() {
        // Test
        System.out.println("Cancel button clicked");
     
        HomeScreen.showNewContactForm();
    }
}