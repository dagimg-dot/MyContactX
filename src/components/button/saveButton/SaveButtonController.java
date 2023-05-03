package components.button.saveButton;

import java.util.HashMap;
import java.util.Map;

import components.container.contactList.ContactListController;
import components.textfield.formfield.FormField;
import controller.Controller;
import screens.HomeScreen;

public class SaveButtonController implements Controller {
    public Map<String, FormField> newContactFormFields;
    public Map<String, Boolean> isFilled = new HashMap<>();

    public SaveButtonController(Map<String, FormField> newContactFormFields) {
        this.newContactFormFields = newContactFormFields;
    }

    public void onClick() {
        // Test
        System.out.println("Save button clicked");

        // print the values of the form fields
        newContactFormFields.forEach((key, value) -> {
            System.out.println(key + ": " + value.getText());
        });
        
        // call the ContactListController to update the contact list
        ContactListController contactListController = new ContactListController();
        contactListController.addContact();

        // clear the form fields
        newContactFormFields.forEach((key, value) -> {
            value.clear();
        });

        // close the PopUp form when the save button is clicked
        HomeScreen.hideNewContactForm();
    }
}