package components.container.popUp;

import java.util.HashMap;
import java.util.Map;

import components.button._button.ButtonFactory;
import components.button.newButton.NewButtonController;
import components.container._container.Container;
import components.icon._icon.CustomIcon;
import components.text.TextGenerator;
import components.textfield.formfield.FormField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NewContactForm extends Container {
    public AnchorPane root;
    public NewButtonController newButtonController;
    public Map<String,TextField> textFields = new HashMap<>();

    public NewContactForm(AnchorPane root, double formWidth, double formHeight) {
        super(root, formHeight, formHeight);
        this.root = root;
        this.setPrefSize(formWidth, formHeight);
        AnchorPane.setLeftAnchor(this,((root.getWidth() - formWidth) / 2));
        AnchorPane.setTopAnchor(this,((root.getHeight() - formHeight) / 2));
        this.setStyle("-fx-background-color: white;-fx-background-radius: 18; -fx-border-color: #5B5B5B; -fx-border-radius: 15; -fx-border-width: 6"); 
        
        // add listener to window width and height properties so that the new contact form is always centered
        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            // adjust pane layoutX property
            AnchorPane.setLeftAnchor(this,((newVal.doubleValue() - this.getPrefWidth()) / 2));
        });

        root.heightProperty().addListener((obs, oldVal, newVal) -> {
            // adjust pane layoutY property
            AnchorPane.setTopAnchor(this,((newVal.doubleValue() - this.getPrefHeight()) / 2));
        });
        
    }
    
    public void render() {
        // create the form container
        VBox formContainer = new VBox();
        formContainer.setPrefSize(this.getPrefWidth(), this.getPrefHeight());
        
        // create VBox Wrapper
        VBox wrapper = new VBox(18);
        wrapper.setPrefSize(this.getPrefWidth(), this.getPrefHeight());
        
        // set margin for the header HBox
        VBox.setMargin(wrapper, new Insets(25, 25, 25, 25));
        
        // header HBox
        HBox header = new HBox(15);
        header.setPrefSize(this.getPrefWidth(), this.getPrefHeight() * 0.1);
        header.setAlignment(Pos.CENTER);

        // create the contacts icon 
        CustomIcon contactsIcon = new CustomIcon(FontAwesomeIcons.USER, "4em", Color.valueOf("#5B5B5B")); 
        FontAwesomeIcon conIcon =  contactsIcon.build();
       
        // create header text
        Text addNewContact = TextGenerator.generateText("Add new contact", 25, "#000000", "Times New Roman","bold");

        // add the contacts icon and header text to the header HBox
        header.getChildren().addAll(conIcon, addNewContact);

        // create 5 HBoxes for the form using the formRowBuilder method
        HBox name = formRowBuilder("Name");
        HBox email = formRowBuilder("Email");
        HBox phone = formRowBuilder("Phone ");
        HBox city = formRowBuilder("City");
        HBox group = formRowBuilder("Group");

        // create HBox for save and cancel buttons
        HBox buttonContainer = new HBox(20);
        buttonContainer.setPrefSize(this.getPrefWidth(), this.getPrefHeight() * 0.1);

        ButtonFactory buttonFactory = new ButtonFactory();

        // create save button and cancel button
        Button saveButton = buttonFactory.createButton("Save", 85.0, 20.0);
        Button cancelButton = buttonFactory.createButton("Cancel", 85.0, 20.0);
        
        // center the buttons
        buttonContainer.setAlignment(Pos.CENTER);

        // add save and cancel buttons to the button container
        buttonContainer.getChildren().addAll(saveButton, cancelButton);


        // add the header to the form container
        wrapper.getChildren().addAll(header, name, email, phone, city, group, buttonContainer);

        // add the wrapper to the form container
        formContainer.getChildren().add(wrapper);

        // add the form container to the new contact form
        this.getChildren().add(formContainer);

        root.getChildren().add(this);        
    }

    public HBox formRowBuilder(String label) {
        HBox hbox = new HBox();
        hbox.setPrefSize(this.getPrefWidth(), this.getPrefHeight() * 0.1);

        // create VBox Wrapper
        VBox componentWrapper = new VBox(3);
        componentWrapper.setPrefWidth(this.getPrefWidth());

        // create header text
        Text componentLabel = TextGenerator.generateText(label, 17, "#D1C9C9", "Times New Roman", "bold");
        
        // set margin for the header text
        VBox.setMargin(componentLabel, new Insets(0, 0, 0, 9));

        // create textfield
        FormField componentTextField = new FormField(label);

        // add textfield to the textfields map
        textFields.put(label, componentTextField);

        // add text and textfield to the name wrapper
        componentWrapper.getChildren().addAll(componentLabel, componentTextField);

        // add the name wrapper to the name HBox
        hbox.getChildren().add(componentWrapper);

        return hbox;
    }

}