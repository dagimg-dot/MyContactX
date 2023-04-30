package components.button.editButton;

import controller.Controller;
import screens.HomeScreen;
import StateX.StateX;
import components.container.contactList.ContactListController;

public class EditButtonController implements Controller {
    public void onClick() {
        // Test
        System.out.println("Edit button clicked");

        if(StateX.selectedContactIndex == -1) {
            System.out.println("No contact selected");
            return;
        } else {
            HomeScreen.showEditContactForm();
            ContactListController contactListController = new ContactListController();
            contactListController.fillContactForm();
        }

    }
}