package models;

import java.util.ArrayList;

import services.Database;

public class Contact {
    public String name;
    public String phone_no;
    public String group;
    public ArrayList<Contact> contactList = new ArrayList<Contact>();   

    public Contact() {
        this.contactList = new Database().fetchContacts();
    }

    public Contact(String name, String phone_no, String group) {
        this.name = name;
        this.phone_no = phone_no;
        this.group = group;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

}