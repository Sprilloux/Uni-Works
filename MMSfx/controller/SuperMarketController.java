package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.Image;


import javafx.stage.Stage;
import model.*;








public class SuperMarketController extends Controller<SuperMarket> {
    @FXML private  TextField FilteredNameTf;
    @FXML private  TextField FilteredEmailTf;
    @FXML private TableView<Membership> MembersTv;
    @FXML private TableColumn<Membership, String> nameC;
    @FXML private  TableColumn<Membership, String> emailC;
    @FXML private  TableColumn<Membership, String> phoneC;
    @FXML private Button delB;
    @FXML private Button selB;
    @FXML private Button slipB;

    @FXML private void initialize(){
        nameC.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailC.setCellValueFactory(cellData->cellData.getValue().emailProperty());
        phoneC.setCellValueFactory(cellData-> cellData.getValue().phoneProperty());
        MembersTv.getSelectionModel().selectedItemProperty().addListener((observable,oldSubject,newSubject) -> delB.setDisable(newSubject==null));
        MembersTv.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> selB.setDisable(newValue == null)));
        MembersTv.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> slipB.setDisable(newValue == null)));
        FilteredNameTf.textProperty().addListener((observable,oldValue,newValue) -> getSuperMarket().filterList(newValue,newValue));
        FilteredEmailTf.textProperty().addListener((observable,oldValue,newValue) -> getSuperMarket().filterList(newValue,newValue));
    }

    private String getName(){return FilteredNameTf.getText();}

    private String getEmail(){return  FilteredEmailTf.getText();}

    private Membership getMembership(){return MembersTv.getSelectionModel().getSelectedItem();}

    private String getName(Membership e){
        return e.getName();
    }
    public final SuperMarket getSuperMarket(){return model;}

    @FXML private void handleDelete() throws Exception{
        getSuperMarket().removeMembership(getMembership());
    }

    @FXML private void handleAdd()throws Exception{
        Stage stageAdd = new Stage();
        stageAdd.getIcons().add(new Image("view/edit.png"));
        stageAdd.setX(ViewLoader.X);
        stageAdd.setY(ViewLoader.Y);
        Membership membership = new Membership("","","","","",0.0);
        membership.setSuperMarket(getSuperMarket());
        ViewLoader.showStage(membership,"/view/Membership.fxml", "Adding New Membership",stageAdd);
    }
    @FXML private void handleSelect() throws Exception{
        Stage stageL = new Stage();
        stageL.getIcons().add(new Image("view/edit.png"));
        stageL.setX(ViewLoader.X);
        stageL.setY(ViewLoader.Y);

        ViewLoader.showStage(getMembership(),"/view/Membership.fxml", "Accessing File: "+ getName(getMembership()) ,stageL);
    }

    @FXML private void handleSlip() throws Exception{
        Stage stageS = new Stage();
        stageS.getIcons().add(new Image("view/edit.png"));
        stageS.setX(ViewLoader.X);
        stageS.setY(ViewLoader.Y);
        MMSreport mmSreport = new MMSreport(getMembership());

        ViewLoader.showStage(mmSreport,"/view/slip.fxml",  getName(getMembership()) + " SLIP Report",stageS);
    }

    @FXML private void handleReport() throws Exception{
        Stage stageL = new Stage();
        stageL.getIcons().add(new Image("view/uts.jpeg"));
        stageL.setX(ViewLoader.X);
        stageL.setY(ViewLoader.Y);
        MMS mms = new MMS(getSuperMarket());
        ViewLoader.showStage(mms, "/view/mms.fxml", "MMS Report", stageL);
    }
    @FXML private void handleClose() throws Exception{stage.close();}




}

