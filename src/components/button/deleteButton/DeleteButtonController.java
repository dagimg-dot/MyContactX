package components.button.deleteButton;

import controller.Controller;

import java.sql.SQLException;

import components.container.contactList.ContactListController;

public class DeleteButtonController implements Controller {
    public void onClick() {
        System.out.println("Delete button clicked");
		
		ContactListController contactListController = new ContactListController();
		try {
            contactListController.deleteContact();
        } catch (SQLException e) {
            e.printStackTrace();
        }	

    }
}
