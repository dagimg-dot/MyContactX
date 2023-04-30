package StateX;

import java.util.Map;

import components.textfield.formfield.FormField;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import models.Contact;

public class StateX {
    public static int selectedContactIndex = -1;
    public static VBox contactVBox;
    public static ObservableList<Contact> contacts;
    public static Map<String, FormField> editContactFormFields;
}