package components.textfield.formfield;

import components.textfield._textfield.CustomTextField;

public class FormField extends CustomTextField {
    public FormField(String placeholder) {
        super(placeholder);
        this.getStylesheets().add("components/textfield/formfield/FormField.css");
        this.getStyleClass().add("form-field");
    }
}