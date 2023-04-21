package components.container.contactList;

import components.container.mainContainer.MainContainer;
import components.text.TextGenerator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Contact;

public class ContactList {
    MainContainer mainContainer;

    public ContactList(MainContainer mainContainer) {
        this.mainContainer = mainContainer;
    }

    public void render(VBox vbox, Scene scene, ScrollPane scrollPane) {
        // get contacts from the ContactListController
        ObservableList<Contact> contacts = new ContactListController().showContactList(); 

        // add the list to the VBox by making each of them a HBox
        for (Contact contact : contacts) {
            HBoxBuilder(vbox, scene, contact, scrollPane);
        }
    }
    
    public void HBoxBuilder(VBox vbox, Scene scene,Contact contact,ScrollPane scrollPane) {
        HBox mainHBox = new HBox();
        
        // set minHeight of the HBox relative to the height of the scene
        mainHBox.setMinHeight(scene.getHeight() * 0.06);

        // set style of the HBox
        mainHBox.setStyle("-fx-background-color: #D1C9C9;-fx-background-radius: 15;");
        mainHBox.setAlignment(Pos.CENTER);
        
        // extract the contact details
        String name = contact.getName();
        String phone = contact.getPhone_no();
        String group = contact.getGroup();
        
        // create the HBoxes for the contact details
        HBox nameHBox = new HBox();
        HBox phoneHBox = new HBox();
        HBox groupHBox = new HBox();
        
        // style the contact details

        new TextGenerator();

        Text nameText = TextGenerator.generateText(name, 16, "#000000","Times New Roman");
        Text phoneText = TextGenerator.generateText(phone, 16, "#000000","Times New Roman");
        Text groupText = TextGenerator.generateText(group, 16, "#000000","Times New Roman");

        // add the contact details to the HBoxes
        nameHBox.getChildren().add(nameText);
        phoneHBox.getChildren().add(phoneText);
        groupHBox.getChildren().add(groupText);

        // center the contact details in the HBoxes
        nameHBox.setAlignment(Pos.CENTER); 
        phoneHBox.setAlignment(Pos.CENTER);
        groupHBox.setAlignment(Pos.CENTER);
        
        // create the titles HBox
        mainHBox.prefWidthProperty().bind(mainContainer.widthProperty());
        mainHBox.setPadding(new Insets(0,0,10,0));

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

        // add the main HBox to the VBox
        vbox.getChildren().add(mainHBox);   
    }
}