package components.textfield._textfield;

public class TextFieldListener {
    public TextFieldListener(CustomTextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            textField.setValue(newValue);
        });
    }
}