package services;

import java.util.ArrayList;

import models.Contact;

public class Database {
    public Database() {
    }

    public ArrayList<Contact> fetchContacts() {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        
        // create 5 contact manually
        contactList.add(new Contact("John Doe", "123456789", "Family"));
        contactList.add(new Contact("Jane Doe", "123456789", "Family"));
        contactList.add(new Contact("John Smith", "123456789", "Family"));
        contactList.add(new Contact("Jane Smith", "123456789", "Family"));
        contactList.add(new Contact("John Doe", "123456789", "Family"));

        return contactList;
    }
}