package components.textfield._textfield;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

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

    public TextFormatter<String> formatter(String regex) {
        return new TextFormatter<>(change -> {
            if (change.getControlNewText().matches(regex)) {
                return change;
            } else {
                return null;
            }
        });
    }
}