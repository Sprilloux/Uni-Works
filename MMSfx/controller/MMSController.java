package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;
import java.text.DecimalFormat;

public class MMSController extends Controller<MMS>{


    @FXML private TableView<Membership> listTv;
    @FXML private TableColumn<Membership,String> nameColumn;
    @FXML private TableColumn<Membership,String> typeColumn;
    @FXML private TableColumn<Membership,String> expenseColumn;
    @FXML private TableColumn<Membership,String> creditsColumn;
    @FXML private TableColumn<Membership,String> gasDeductionColumn;
    @FXML private TableColumn<Membership,String> deductionColumn;
    @FXML private TableColumn<Membership,String> payPerCreditColumn;
    @FXML private TableColumn<Membership,String> dollarColumn;
    @FXML private Text totalExpenseTxt;
    @FXML private Text avgPPC;
    @FXML private Text avarageGasDedTxt;
    @FXML private Text totalCreditsTxt;
    @FXML private Text avarageDeductionTxt;
    @FXML private Text totalDolTxt;

    @FXML private void initialize(){
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        expenseColumn.setCellValueFactory(cellData -> cellData.getValue().expenseProperty().asString("%.2f"));
        creditsColumn.setCellValueFactory(cellData -> cellData.getValue().totalCreditsProperty().asString("%.2f"));
        gasDeductionColumn.setCellValueFactory(cellData -> cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
        deductionColumn.setCellValueFactory(cellData -> cellData.getValue().deductionRateProperty().asString("%.2f"));
        payPerCreditColumn.setCellValueFactory(cellData -> cellData.getValue().payPerCreditProperty().asString("%.2f"));
        dollarColumn.setCellValueFactory(cellData -> cellData.getValue().DollarAvailableProperty().asString("$%d").concat(".00"));
        totalCreditsTxt.setText("$" + formattedString(getMMS().getTotalCredits()));
        avarageGasDedTxt.setText(formattedString(getMMS().getAvgGasdeductionRate()));
        totalExpenseTxt.setText("$" + formattedString(getMMS().getTotalExpense()));
        avarageDeductionTxt.setText(formattedString(getMMS().getAvgdeductionRate()));
        totalDolTxt.setText(formattedString(model.getTotalDollarAvailable()));
        avgPPC.setText(formattedString(getMMS().getAvgPayPerCredit()));
    }

    public final MMS getMMS(){return model;}

    @FXML private void handleClose(){stage.close();}
    private String formattedString(Double value){

        return new DecimalFormat("###,##0.00").format(value);
    }



}

