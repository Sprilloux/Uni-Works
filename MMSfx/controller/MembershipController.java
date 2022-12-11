package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Membership;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;



public class MembershipController extends Controller<Membership> {

    @FXML private TextField NameTf;
    @FXML private TextField EmailTf;
    @FXML private TextField PhoneTf;
    @FXML private TextField AddressTf;
    @FXML private TextField IDTf;
    @FXML private TextField ExpenseTf;
    @FXML private Text TypeTxt;
    @FXML private Button AddBtn;
    @FXML private Button UpdateBtn;

     @FXML private void initialize(){

        NameTf.setText(getMembership().getName());
        EmailTf.setText(getMembership().getEmail());
        PhoneTf.setText(getMembership().getPhone());
        AddressTf.setText(getMembership().getAddress());
        IDTf.setText(getMembership().getID());
        TypeTxt.setText(getMembership().getType());
        ExpenseTf.setText(Double.toString(getMembership().getexpense()));
        UpdateBtn.setDisable(NameTf.getText().equals(""));
        AddBtn.setDisable(!NameTf.getText().equals(""));
    }


    public final Membership getMembership(){return model;}

    @FXML private void handleAdd() throws Exception{
        Validator validator = new Validator();
        if(validator.isValid(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()))){
            getMembership().updateDetails(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                    AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()));
            getMembership().getSuperMarket().addMembership(getMembership());
        }
        else {
            validator.generateErrors(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                    AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()));
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/error.png"));
            ViewLoader.showStage(validator,"/view/error.fxml", "Input Exceptions",stage);
        }


    }


    @FXML private void handleQuit(){stage.close();}

    @FXML private void handleUpdate() throws Exception{
        Validator validator = new Validator();
        if(validator.isValid(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()))){
            getMembership().updateDetails(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                    AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()));
        }
        else {
            validator.generateErrors(NameTf.getText(),EmailTf.getText(),PhoneTf.getText(),
                    AddressTf.getText(),IDTf.getText(),Double.parseDouble(ExpenseTf.getText()));
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/error.png"));
            ViewLoader.showStage(validator,"/view/error.fxml", "Input Exceptions",stage);
        }

    }


}

