package components.icon.searchIcon;

import components.textfield.searchtextfield.SearchTextField;
import components.textfield.searchtextfield.SearchTextFieldListener;
import controller.Controller;

public class SearchIconController implements Controller {
    public SearchTextField searchTextField;

    public SearchIconController(SearchTextField searchTextField) {
        this.searchTextField = searchTextField;

        // pass the this object to the SearchTextFieldListener
        new SearchTextFieldListener(searchTextField);
    }

    public void onClick() {
            search();
        }

    public void search() { 
        // print what is written in the search text field
        String currText = searchTextField.getCurrText();
        System.out.println(currText);
    }
}