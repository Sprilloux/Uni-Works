package controller;

import javafx.scene.control.Label;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;



public class MMSLoginController extends Controller<Session>  {
    @FXML private TextField emailTf;
    @FXML private TextField passwordTf;

    @FXML private  Label stateTxt;

    public final Session getSession(){
        return model;
    }
    private String getEmail(){return emailTf.getText();}

    private String getName(SuperMarket superMarket){

        return superMarket.getName();
    }
    private void setEmail(){
        emailTf.setText("");
    }

    private void setPassword(){
        passwordTf.setText("");
    }
    private String getPassword(){return passwordTf.getText();}
    @FXML private  void handleLogin(ActionEvent event) throws Exception{
        String email = getEmail();
        String password = getPassword();
        if(getSession().getSuperMarket(email,password) != null){
            Stage stage = new Stage();
            stage.getIcons().add(new Image("view/SuperMarket.png"));
            ViewLoader.showStage(new SuperMarket(), "/view/SuperMarket.fxml", "Session Admin: "+getName(getSession().getSuperMarket(email,password))  ,stage);
        }
        else{
            stateTxt.setText("Incorrect login details");
            setEmail();
            setPassword();

        }

    }
    @FXML private void exit(ActionEvent event){
        stage.close();
    }
}


