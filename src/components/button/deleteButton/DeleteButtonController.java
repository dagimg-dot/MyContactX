package components.button.deleteButton;

import controller.Controller;
import components.container.contactList.ContactListController;

public class DeleteButtonController implements Controller {
    public void onClick() {
        System.out.println("Delete button clicked");
		
		ContactListController contactListController = new ContactListController();
		contactListController.deleteContact();	

    }
}
