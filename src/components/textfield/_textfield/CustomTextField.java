package components.textfield._textfield;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField {
    public String value;

    public CustomTextField(String placeholder) {
        super();
        this.setPromptText(placeholder);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}