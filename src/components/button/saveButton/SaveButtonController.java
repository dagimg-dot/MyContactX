package components.button.saveButton;

import java.util.Map;

import components.container.contactList.ContactListController;
import components.textfield.formfield.FormField;
import controller.Controller;

public class SaveButtonController implements Controller {
    public Map<String, FormField> newContactFormFields;

    public SaveButtonController(Map<String, FormField> newContactFormFields) {
        this.newContactFormFields = newContactFormFields;
    }

    public void onClick() {
        // Test
        System.out.println("Save button clicked");

        // print the values of the form fields
        newContactFormFields.forEach((key, value) -> {
            System.out.println(key + ": " + value.getValue());
        });
        
        // call the ContactListController to update the contact list
        ContactListController contactListController = new ContactListController();
        contactListController.addContact(newContactFormFields);

        // clear the form fields
        newContactFormFields.forEach((key, value) -> {
            value.clear();
        });
    }
}