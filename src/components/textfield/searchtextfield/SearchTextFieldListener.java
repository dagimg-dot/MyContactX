package components.textfield.searchtextfield;

public class SearchTextFieldListener {
    public SearchTextFieldListener(SearchTextField searchTextField) {
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchTextField.setCurrText(newValue);
        });
    }
}