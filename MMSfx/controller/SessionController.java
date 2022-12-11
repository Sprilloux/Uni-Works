package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;


public class SessionController extends Controller<Session> {

    private Session session = new Session();

    @FXML private void handleLogin(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/book.png"));
        ViewLoader.showStage(session, "/view/MMSlogin.fxml","Sign in", stage);

    }

    @FXML private void exit(ActionEvent event){
        stage.close();
    }


}

