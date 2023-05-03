package models;

import java.sql.SQLException;
import java.util.ArrayList;

import services.ContactService;

public class Contact {
    private int id;
    private String name;
    private String email;
    private String phone_no;
    private String city;
    private String group;
    public static ArrayList<Contact> contactList = new ArrayList<Contact>();   
    private static ContactService contactService = ContactService.getInstance();

    public Contact() throws SQLException {
        contactList = contactService.fetchContacts();
    }

    public Contact(int id,String name, String email, String phone_no, String city, String group) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.city = city;
        this.group = group;
    }

    public Contact(String name, String email, String phone_no, String city, String group) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.city = city;
        this.group = group;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static ArrayList<Contact> getContactList() {
        return contactList;
    }

    public static void addContact(Contact contact) {
        contactList.add(contact);
    }

}