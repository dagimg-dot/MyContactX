package components.button.editButton;

import controller.Controller;
import screens.HomeScreen;

public class EditButtonController implements Controller {
    public void onClick() {
        // Test
        System.out.println("Edit button clicked");
        
        HomeScreen.showEditContactForm();
    }
}