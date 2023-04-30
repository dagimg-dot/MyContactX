package components.container.contactList;

import java.util.ArrayList;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import models.Contact;
import StateX.StateX;
import components.textfield.formfield.FormField;

public class ContactListController {
    public ContactListController() {
    }

    public ObservableList<Contact> showContactList() {
        new Contact();
        ArrayList<Contact> contactList = Contact.getContactList();
        
        ObservableList<Contact> contacts = FXCollections.observableArrayList(contactList);

        return contacts;
    }

    public void addContact(Map<String, FormField> newContactFormFields) {
        System.out.println("Add Contact"); 

        // create a new contact
        Contact newContact = new Contact(
            newContactFormFields.get("Name").value,
            newContactFormFields.get("Phone").value,
            newContactFormFields.get("Group").value          
        );
        
        Contact.addContact(newContact);
        StateX.contacts.add(newContact);
    }

    public void fillContactForm() {
        
        // get the selected contact
        Contact selectedContact = Contact.getContactList().get(StateX.selectedContactIndex);
        
        System.out.println("Selected Contact: " + selectedContact.getName());
        
        // load the values from the contact model into the form fields
        StateX.editContactFormFields.get("Name").setText(selectedContact.getName());
        StateX.editContactFormFields.get("Phone").setText(selectedContact.getPhone_no());
        StateX.editContactFormFields.get("Group").setText(selectedContact.getGroup());
        
        System.out.println("Form Filled");
    }

    public void editContact() {
        System.out.println("Edit Contact");

        // get the selected contact
        Contact selectedContact = Contact.getContactList().get(StateX.selectedContactIndex);
        
        // update the contact model with the new values
        selectedContact.setName(StateX.editContactFormFields.get("Name").value);
        selectedContact.setPhone_no(StateX.editContactFormFields.get("Phone").value);
        selectedContact.setGroup(StateX.editContactFormFields.get("Group").value);

        // update the contact list
        Contact.getContactList().set(StateX.selectedContactIndex, selectedContact);
        StateX.contacts.set(StateX.selectedContactIndex, selectedContact);

    }

    public void deleteContact() {
        System.out.println("Delete Contact");
        
        
        if (StateX.selectedContactIndex != -1) {
            HBox selectedContact = (HBox) StateX.contactVBox.getChildren().get(StateX.selectedContactIndex);
            StateX.contactVBox.getChildren().remove(selectedContact);
            Contact.getContactList().remove(StateX.selectedContactIndex);
			StateX.contacts.remove(StateX.selectedContactIndex);
			StateX.selectedContactIndex = -1;
        }
    }

    public void searchContact() {
        System.out.println("Search Contact");
    }

}