package components.icon.searchIcon;

import components.textfield._textfield.TextFieldListener;
import components.textfield.searchtextfield.SearchTextField;
import controller.Controller;

public class SearchIconController implements Controller {
    public SearchTextField searchTextField;

    public SearchIconController(SearchTextField searchTextField) {
        this.searchTextField = searchTextField;

        // pass the this object to the SearchTextFieldListener
        new TextFieldListener(searchTextField);
    }

    public void onClick() {
            search();
        }

    public void search() { 
        // print what is written in the search text field
        String currText = searchTextField.getValue();
        System.out.println(currText);
    }
}