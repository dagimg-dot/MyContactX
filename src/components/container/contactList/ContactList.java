package components.container.contactList;

import components.container.mainContainer.MainContainer;
import components.text.TextGenerator;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import models.Contact;

import java.sql.SQLException;

import StateX.StateX;

public class ContactList {
    MainContainer mainContainer;
    ContactListController contactListController;

    public ContactList(MainContainer mainContainer) {
        this.mainContainer = mainContainer;
    }

    public void render(VBox vbox, Scene scene, ScrollPane scrollPane) throws SQLException {
        // get contacts from the ContactListController
        contactListController = new ContactListController();
        ObservableList<Contact> contacts = contactListController.showContactList();
        StateX.contacts = contacts;
        
        // if the contacts list is empty, show a message
        if (contacts.isEmpty() && StateX.isDatabaseConnected == false) {
            TextFlow text = new TextFlow();
            Text text1 = TextGenerator.generateText("Contacts can not be displayed,", "Poppins-SemiBold",20, "#554D4D");
            Text text2 = TextGenerator.generateText("Server is down", "Poppins-SemiBold",20, "#554D4D");
            text.setTextAlignment(TextAlignment.CENTER);
            text.getChildren().addAll(text1, new Text("\n"), text2);
            vbox.getChildren().add(text);
            return;
        }

        // render the contacts
        for (Contact contact : contacts) {
            int idx = contacts.indexOf(contact);
            HBox hbox = HBoxBuilder(vbox, scene, contact, scrollPane,idx,contacts);
            vbox.getChildren().add(hbox);
        }

        // add a listener to the contacts list
        contacts.addListener(new ListChangeListener<Contact>() {
            @Override
            public void onChanged(Change<? extends Contact> c) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // clear the vbox
                        vbox.getChildren().clear();

                        // re-render the contacts
                        for (Contact contact : contacts) {
                            int idx = contacts.indexOf(contact);
                            HBox hbox = HBoxBuilder(vbox, scene, contact, scrollPane,idx,contacts);
                            vbox.getChildren().add(hbox);
                        }
                    }
                });
            }
        });
        
    }
    
    public HBox HBoxBuilder(VBox vbox, Scene scene,Contact contact,ScrollPane scrollPane,int idx, ObservableList<Contact> contacts) {
        HBox mainHBox = new HBox();

        // set minHeight of the HBox relative to the height of the scene
        mainHBox.setMinHeight(scene.getHeight() * 0.06);

        // set style of the HBox
        mainHBox.setStyle("-fx-background-color: #E3E0E0;-fx-background-radius: 15;");
        // mainHBox.setAlignment(Pos.CENTER);
        
        // extract the contact details
        String name = contact.getName();
        String phone = contact.getPhone_no();
        String group = contact.getGroup();
        
        // create the HBoxes for the contact details
        HBox nameHBox = new HBox();
        HBox phoneHBox = new HBox();
        HBox groupHBox = new HBox();
        
        // style the contact details
        
        Text nameText = TextGenerator.generateText(name,"Poppins-Regular", 18, "#554D4D");
        Text phoneText = TextGenerator.generateText(phone,"Poppins-Regular", 18, "#554D4D");
        Text groupText = TextGenerator.generateText(group,"Poppins-Regular", 18, "#554D4D");

        // add the contact details to the HBoxes
        nameHBox.getChildren().add(nameText);
        phoneHBox.getChildren().add(phoneText);
        groupHBox.getChildren().add(groupText);
        
        // center the contact details in the HBoxes
        nameHBox.setAlignment(Pos.CENTER_LEFT); 
        phoneHBox.setAlignment(Pos.CENTER_LEFT);
        groupHBox.setAlignment(Pos.CENTER_LEFT);

        // set padding for each HBox
        nameHBox.setPadding(new Insets(0, 0, 0, 15));
        phoneHBox.setPadding(new Insets(0, 0, 0, 15));
        groupHBox.setPadding(new Insets(0, 0, 0, 15));
        
        // create the titles HBox
        mainHBox.prefWidthProperty().bind(mainContainer.widthProperty());
        
        // center the titles HBox vertically and horizontally
        mainHBox.setAlignment(Pos.CENTER);
        
        // set the width of the buttons relative to the width of the titles HBox
        nameHBox.prefWidthProperty().bind(mainHBox.widthProperty().divide(3));
        phoneHBox.prefWidthProperty().bind(mainHBox.widthProperty().divide(3));
        groupHBox.prefWidthProperty().bind(mainHBox.widthProperty().divide(3));
        
        // make some space between the buttons
        HBox.setMargin(nameHBox, new Insets( 0, 0, 0, 15));
        HBox.setMargin(phoneHBox, new Insets( 0, 0, 0, 25));
        HBox.setMargin(groupHBox, new Insets( 0, 15, 0, 25));
        
        // add the buttons to the titles HBox
        mainHBox.getChildren().addAll(nameHBox, phoneHBox, groupHBox);
        
        // set the selectedContactIndex to the index of the contact that was clicked
        contactListController.handleHBoxSelection(vbox,mainHBox,idx);

        // set the hover effect for the HBox
        contactListController.handleHBoxHover(mainHBox);

        // add the main HBox to the VBox
        return mainHBox;  
    }

}