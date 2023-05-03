package components.button.confirmButton;

import java.sql.SQLException;
import java.util.Map;

import components.container.contactList.ContactListController;
import components.textfield.formfield.FormField;
import controller.Controller;
import screens.HomeScreen;

public class ConfirmButtonController implements Controller {
    public Map<String, FormField> editContactFormFields;

    public ConfirmButtonController(Map<String, FormField> editContactFormFields) {
        this.editContactFormFields = editContactFormFields;
    }

    public void onClick() {
        // Test
        System.out.println("Confirm button clicked");
       
        // print the values of the form fields
        editContactFormFields.forEach((key, value) -> {
            System.out.println(key + ": " + value.getValue());
        });

        // call the ContactListController to update the contact list
        ContactListController contactListController = new ContactListController();
        try {
            contactListController.editContact();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // close the PopUp form when the confirm button is clicked
        HomeScreen.hideEditContactForm();

    }
}