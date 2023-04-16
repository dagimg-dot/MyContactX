package components.button._button;

import components.button.groupButton.GroupButtonController;
import components.button.nameButton.NameButtonController;
import components.button.phoneButton.PhoneButtonController;
import javafx.scene.control.Button;


public class ButtonFactory {
    public Button createButton (String buttonText, Double width, Double height, String stylePath) {
        Button button = new Button(buttonText);
        button.setPrefSize(width, height);
        button.getStylesheets().add(stylePath);
        button.getStyleClass().add("button-style");
        this.getType(buttonText, button);
        return button;
    }

    public Button createButton (String buttonText, Double width, Double height) {
        Button button = new Button(buttonText);
        button.setPrefSize(width, height);
        button.getStylesheets().add("components/button/_button/buttonStyle.css");
        button.getStyleClass().add("button-style");
        this.getType(buttonText, button);
        return button;
    }

    public void getType(String buttonText,Button button) {
        if(buttonText.equalsIgnoreCase("Name")){
            button.setOnAction(e -> (new NameButtonController()).onClick());
        } else if(buttonText.equalsIgnoreCase("Phone No.")){
            button.setOnAction(e -> (new PhoneButtonController()).onClick());
        } else if(buttonText.equalsIgnoreCase("Group")) {
            button.setOnAction(e -> (new GroupButtonController()).onClick());
        }
        
    }
}