package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class ErrorController extends Controller<Validator>  {


    @FXML private Text nametxt;


    private Validator getValidator(){return model;}

    @FXML private void initialize(){
        String text = "";
        for(String error : getValidator().errors()){
            text += error;

        }
    nametxt.setText(text);

    }

    @FXML private void handleClose(){stage.close();}


}

