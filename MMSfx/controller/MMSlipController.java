package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.MMSreport;
import javafx.scene.text.Text;

import java.text.DecimalFormat;


public class MMSlipController extends Controller<MMSreport> {
    @FXML Text TotalCreditsTxt;
    @FXML Text PPCreditTxt;
    @FXML Text TotalExpenseTxt;
    @FXML Text DollarAvailableTxt;
    @FXML Text GasDDRateTxt;
    @FXML Text DDRateTxt;

    @FXML private void initialize(){
        TotalCreditsTxt.setText(formattedString(getMMSReport().gettotalCredits()));
        PPCreditTxt.setText(formattedString(getMMSReport().getPayPerCredit()));
        TotalExpenseTxt.setText("$"+ formattedString(getMMSReport().getexpense()));
        DollarAvailableTxt.setText("$"+ formattedString(getMMSReport().getDollarAvailable()));
        GasDDRateTxt.setText(formattedString(getMMSReport().getGasdeductionRate()));
        DDRateTxt.setText(formattedString(getMMSReport().getdeductionRate()));
    }


    private String formattedString(Double value){

        return new DecimalFormat("###,##0.00").format(value);
    }

    public final MMSreport getMMSReport(){return model;}


    @FXML private void handlequit(){
        stage.close();
    }
}



