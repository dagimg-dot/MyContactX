package components.button.deleteButton;

import controller.Controller;
import javafx.scene.layout.HBox;
import models.Contact;
import StateX.StateX;

public class DeleteButtonController implements Controller {
    public void onClick() {
        System.out.println("Delete button clicked");

        if (StateX.selectedContactIndex != -1) {
            HBox selectedContact = (HBox) StateX.contactVBox.getChildren().get(StateX.selectedContactIndex);
            StateX.contactVBox.getChildren().remove(selectedContact);
            Contact.getContactList().remove(StateX.selectedContactIndex);
			StateX.contacts.remove(StateX.selectedContactIndex);
			StateX.selectedContactIndex = -1;
        }
    }
}
