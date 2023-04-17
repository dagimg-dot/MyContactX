package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Contact;

public class ContactListController {
    public ContactListController() {
    }

    public ObservableList<Contact> showContactList() {
        ArrayList<Contact> contactList = new Contact().getContactList();
        ObservableList<Contact> contacts = FXCollections.observableArrayList(contactList);
        return contacts;
    }

    public void showContactGroup(String group) {
        System.out.println("Showing Contact Group:" + group);
    }
    
    public void addContact() {
        System.out.println("Add Contact");
    }

    public void editContact() {
        System.out.println("Edit Contact");
    }

    public void deleteContact() {
        System.out.println("Delete Contact");
    }

    public void searchContact() {
        System.out.println("Search Contact");
    }

}