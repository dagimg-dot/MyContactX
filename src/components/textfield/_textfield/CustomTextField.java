package components.textfield._textfield;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField {
    public CustomTextField(String placeholder) {
        super();
        this.setPromptText(placeholder);
    }
}