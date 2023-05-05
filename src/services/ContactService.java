package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import StateX.StateX;

import models.Contact;

public class ContactService {
    private Connection connection;
    private static ContactService instance = null;

    private ContactService() {
    }

    public static ContactService getInstance() {
        if (instance == null) {
            instance = new ContactService();
        }
        return instance;
    }


    public ArrayList<Contact> fetchContacts() throws SQLException {
        ArrayList<Contact> contacts = new ArrayList<>();
        

        connection = Database.getConnection();

        System.out.println(connection);

        if(connection != null) {
            StateX.isDatabaseConnected = true;
            String query = "SELECT * FROM contact";
            PreparedStatement statement = connection.prepareStatement(query);
    
    
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String city = resultSet.getString("city");
                String group = resultSet.getString("groupname");
    
                Contact contact = new Contact(id,name, email, phone, city, group);
                contacts.add(contact);
            }
    
            resultSet.close();
            statement.close();
    
        }
        
        return contacts;
        
    }

    public void saveContact(Contact contact) throws SQLException {
        connection = Database.getConnection();

        String query = "INSERT INTO contact (name, email, phone, city, groupname) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, contact.getName());
        statement.setString(2, contact.getEmail());
        statement.setString(3, contact.getPhone_no());
        statement.setString(4, contact.getCity());
        statement.setString(5, contact.getGroup());

        statement.executeUpdate();

        statement.close();
    }

    public void deleteContact(Contact contact) throws SQLException {
        connection = Database.getConnection();

        String query = "DELETE FROM contact WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, contact.getId());

        statement.executeUpdate();

        statement.close();
    }

    public void updateContact(Contact contact) throws SQLException {
        connection = Database.getConnection();

        String query = "UPDATE contact SET name = ?, email = ?, phone = ?, city = ?, groupname = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, contact.getName());
        statement.setString(2, contact.getEmail());
        statement.setString(3, contact.getPhone_no());
        statement.setString(4, contact.getCity());
        statement.setString(5, contact.getGroup());

        statement.setInt(6, contact.getId());


        statement.executeUpdate();

        statement.close();
    }


}
