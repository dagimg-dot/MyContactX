package components.container.contactList;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
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

    public void handleHBoxSelection(VBox vbox, HBox mainHBox,int idx) {
        mainHBox.setOnMouseClicked(e -> {
            if (StateX.selectedContactIndex == -1) {
                mainHBox.setStyle("-fx-background-color: #6151C1;-fx-background-radius: 15; -fx-border-radius: 15;");
                handleColorChange(mainHBox, Color.WHITE);
                StateX.selectedContactIndex = idx;
                System.out.println(idx);
            }
            else {
                if(StateX.selectedContactIndex == idx) {
                    mainHBox.setStyle("-fx-background-color: #E3E0E0;-fx-background-radius: 15;");
                    handleColorChange(mainHBox, Color.valueOf("#554D4D"));
                    StateX.selectedContactIndex = -1;
                    System.out.println(idx);
                    return;
                }
                HBox prevMainHBox = (HBox) vbox.getChildren().get(StateX.selectedContactIndex);
                prevMainHBox.setStyle("-fx-background-color: #E3E0E0;-fx-background-radius: 15;");
                handleColorChange(prevMainHBox, Color.valueOf("#554D4D"));
                mainHBox.setStyle("-fx-background-color: #6151C1;-fx-background-radius: 15;-fx-text-fill: #white; -fx-border-radius: 15;");
                handleColorChange(mainHBox, Color.WHITE);
                StateX.selectedContactIndex = idx;
                System.out.println(idx);
            }
        });
    }

    public void handleHBoxHover(HBox mainHBox) {
        mainHBox.setOnMouseEntered(e -> {
            if (StateX.selectedContactIndex == -1) {
                mainHBox.setStyle("-fx-background-color: #E3E0E0;-fx-background-radius: 15;-fx-border-color: #6151C1; -fx-border-width:4px; -fx-border-radius: 15;");
            }
        });
        mainHBox.setOnMouseExited(e -> {
            if (StateX.selectedContactIndex == -1) {
                mainHBox.setStyle("-fx-background-color: #E3E0E0;-fx-background-radius: 15;");
            }
        });
    }

    public void handleColorChange(HBox hbox,Paint color) {
        for(Node node : hbox.getChildren()) {
            if(node instanceof HBox) {
                for(Node node2 : ((HBox) node).getChildren()) {
                    if(node2 instanceof Text) {
                        ((Text) node2).setFill(color);
                    }
                }
            }
        }
    }

}