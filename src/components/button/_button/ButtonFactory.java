package components.button._button;

import components.button.deleteButton.DeleteButtonController;
import components.button.editButton.EditButtonController;
import components.button.groupButton.GroupButtonController;
import components.button.nameButton.NameButtonController;
import components.button.newButton.NewButtonController;
import components.button.phoneButton.PhoneButtonController;
import javafx.scene.control.Button;


public class ButtonFactory {
    public Button createButton (String buttonText, Double width, Double height, String stylePath) {
        Button button = new Button(buttonText);
        button.setPrefSize(width, height);
        button.getStylesheets().add(stylePath);
        button.getStyleClass().add("button-style");
        this.setButtonAction(buttonText, button);
        return button;
    }

    public Button createButton (String buttonText, Double width, Double height) {
        Button button = new Button(buttonText);
        button.setPrefSize(width, height);
        button.getStylesheets().add("components/button/_button/buttonStyle.css");
        button.getStyleClass().add("button-style");
        this.setButtonAction(buttonText, button);
        return button;
    }

    public void setButtonAction(String buttonText,Button button) {
        switch(buttonText) {
            case "Name":
               button.setOnAction(e -> new NameButtonController().onClick());
               break;
            case "Phone No.":
               button.setOnAction(e -> new PhoneButtonController().onClick());
               break;
            case "Group":
               button.setOnAction(e -> new GroupButtonController().onClick());
               break;
            case "New":
               button.setOnAction(e -> new NewButtonController().onClick());
               break;
            case "Edit":
               button.setOnAction(e -> new EditButtonController().onClick());
               break;
            case "Delete":
               button.setOnAction(e -> new DeleteButtonController().onClick());
               break;
            default:
               break;
         }
            
    }
}