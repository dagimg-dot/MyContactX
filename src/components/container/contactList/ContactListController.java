package components.container.contactList;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import models.Contact;
import services.ContactService;
import StateX.StateX;

public class ContactListController {
    private ContactService contactService = ContactService.getInstance();

    public ContactListController() {
    }

    public ObservableList<Contact> showContactList() throws SQLException {
        new Contact();
        ArrayList<Contact> contactList = Contact.getContactList();
        
        ObservableList<Contact> contacts = FXCollections.observableArrayList(contactList);

        return contacts;
    }

    public void addContact() throws SQLException {
        System.out.println("Add Contact"); 

        // create a new contact
        Contact newContact = new Contact(
            StateX.newContactFormFields.get("Name").value,
            StateX.newContactFormFields.get("Email").value,
            StateX.newContactFormFields.get("Phone").value,
            StateX.newContactFormFields.get("City").value,  
            StateX.newContactFormFields.get("Group").value
        );
        
        Contact.addContact(newContact);
        StateX.contacts.add(newContact);
        contactService.saveContact(newContact);
    }

    public void fillContactForm() {
        
        // get the selected contact
        Contact selectedContact = Contact.getContactList().get(StateX.selectedContactIndex);
        
        System.out.println("Selected Contact: " + selectedContact.getName());
        
        // load the values from the contact model into the form fields
        StateX.editContactFormFields.get("Name").setText(selectedContact.getName());
        StateX.editContactFormFields.get("Email").setText(selectedContact.getEmail());
        StateX.editContactFormFields.get("Phone").setText(selectedContact.getPhone_no());
        StateX.editContactFormFields.get("City").setText(selectedContact.getCity());
        StateX.editContactFormFields.get("Group").setText(selectedContact.getGroup());
        
        System.out.println("Form Filled");
    }

    public void editContact() throws SQLException {
        System.out.println("Edit Contact");

        // get the selected contact
        Contact selectedContact = Contact.getContactList().get(StateX.selectedContactIndex);
        
        // update the contact model with the new values
        selectedContact.setName(StateX.editContactFormFields.get("Name").value);
        selectedContact.setEmail(StateX.editContactFormFields.get("Email").value);
        selectedContact.setPhone_no(StateX.editContactFormFields.get("Phone").value);
        selectedContact.setCity(StateX.editContactFormFields.get("City").value);
        selectedContact.setGroup(StateX.editContactFormFields.get("Group").value);

        // update the contact list
        Contact.getContactList().set(StateX.selectedContactIndex, selectedContact);
        StateX.contacts.set(StateX.selectedContactIndex, selectedContact);
        contactService.updateContact(selectedContact);
        StateX.selectedContactIndex = -1;

    }

    public void deleteContact() throws SQLException {
        System.out.println("Delete Contact");
        
        
        if (StateX.selectedContactIndex != -1) {
            HBox selectedContactHBox = (HBox) StateX.contactVBox.getChildren().get(StateX.selectedContactIndex);
            StateX.contactVBox.getChildren().remove(selectedContactHBox);
            Contact selectedContact = Contact.getContactList().get(StateX.selectedContactIndex);
			StateX.contacts.remove(StateX.selectedContactIndex);
            Contact.getContactList().remove(StateX.selectedContactIndex);
            contactService.deleteContact(selectedContact);
			StateX.selectedContactIndex = -1;
        }
    }

    public void searchContact() {
        System.out.println("Search Contact");
    }

}