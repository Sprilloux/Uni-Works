
import java.util.ArrayList;


public class MMS {
    private double totalCredits;
    private double GasdeductionRate;
    private double DollarAvailable;
    private double deductionRate;
    private int PayPerCredit;
    private String type;
    private String name;
    private double expense;
    private Memberships Memberships;
    private ArrayList<MMSlip> MMslips;
    private SuperMarket SuperMarket;




    public MMS(SuperMarket SuperMarket, Memberships Memberships)
    {
        this.SuperMarket = SuperMarket;
        this.Memberships = Memberships;
        MMslips = new ArrayList<MMSlip>();
        this.name = SuperMarket.getName();
        for (Membership membership : Memberships.getList(name,type,totalCredits,GasdeductionRate,DollarAvailable,deductionRate,PayPerCredit,expense)){
            MMslips.add(new MMSlip(membership));
        }

    }




    public void MMSmenu(String name){
        
        helpMenu();
        char choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
        while (choice != 'X') {
            switch (choice) {
                case 'F':
                    getSlipInfo();
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
                    break;
                case 'V':
                    MMSview();
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
                    break;
                case 'A':

                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
                    break;
                case 'R':

                    choice = Utils.choice("\nSession Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
                    break;
                case 'S':

                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");
                    break;

                case 'X':
                    break;
                default:

                    helpMenu();
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (F/V/A/R/S/X)");

            }
        }
        System.out.println("\nSuperMarket Menu:");
    }

    public  void getSlipInfo(){
        boolean state = false;
        String name = Utils.string("Name");
        for (MMSlip mmslip : MMslips){
            if(mmslip.hasname(name)){
                String nameM = mmslip.getName();
                String type = mmslip.getType();
                double expense = mmslip.getExpense();
                int c = getPayPerCredit(type);
                double credit = c * expense;
                int dollars = (int)credit / 200;
                Utils.slipHeader();
                System.out.format(Utils.mmsFormat,nameM,expense,credit,dollars,type);
                Utils.slipTableEnd();
                state = true;
            }

        }
        if(!state){
            System.out.print("Slip details does not exist for " + name + "!\n");
        }
    }

    private void MMSview(){
        
        double totalExpense = 0;
        double totalCredits = 0;
        float totalDollars = 0;
        int totalPPC = 0;
        double totalDDR = 0;
        double totalGDDR = 0;
        double avgPPC = 0;
        double avgDDR = 0;
        double avgGDDR = 0;
        Utils.Totalslipheader();
        for (MMSlip mmslip : MMslips){

            String nameM = mmslip.getName();
            String type = mmslip.getType();
            double expense = mmslip.getExpense();
            int c = getPayPerCredit(type);
            double i = getdeductionRate(type);
            double b = getGasdeductionRate(type);
            double credit = c * expense;
            int dollars = (int)credit / 200;
            System.out.format(Utils.mmsFormat,nameM,expense,credit,dollars,type);
        }
        Utils.TotalslipTableEnd();
        System.out.print("\n");
        Utils.TotalSumHeader();
        for (MMSlip mmslip : MMslips){
            String type = mmslip.getType();
            double expense = mmslip.getExpense();
            int c = getPayPerCredit(type);
            double i = getdeductionRate(type);
            double b = getGasdeductionRate(type);
            double credit = c * expense;
            int dollars = (int)credit / 200;
            totalExpense += expense;
            totalDollars += dollars;
            totalCredits += credit;
            totalPPC += c;
            totalDDR += i;
            totalGDDR += b;
            avgPPC = totalPPC / (double)MMslips.size();
            avgDDR = totalDDR / (double)MMslips.size();
            avgGDDR = totalGDDR / (double)MMslips.size();

        }
        System.out.format(Utils.sumFormat,"Total expense", totalExpense);
        System.out.format(Utils.sumFormat,"Total credits", totalCredits);
        System.out.format(Utils.sumFormat,"Total dollars", totalDollars);
        System.out.format(Utils.sumFormat,"Average pay per credit", avgPPC);
        System.out.format(Utils.sumFormat,"Average deduction rate", avgDDR);
        System.out.format(Utils.sumFormat,"Average gas deduction rate", avgGDDR);
        Utils.TotalSumTableEnd();


    }

    private int getPayPerCredit(String type){

        if (type.equals("Bronze"))
            return PayPerCredit = 20;
        else if (type.equals("Silver"))
            return PayPerCredit = 10;
        else if (type.equals("Gold"))
            return PayPerCredit = 8;
        else if (type.equals("Diamond"))
            return PayPerCredit = 6;
        else
            return PayPerCredit = 4;

    }



    private double getdeductionRate(String type){

        if (type.equals("Bronze"))
            return deductionRate = 0.05;
        else if (type.equals("Silver"))
            return deductionRate = 0.1;
        else if (type.equals("Gold"))
            return deductionRate = 0.15;
        else if (type.equals("Diamond"))
            return deductionRate = 0.2;
        else
            return deductionRate = 0.25;

    }

    private double getGasdeductionRate(String type){

        if (type.equals("Bronze"))
            return GasdeductionRate = 0.1;
        else if (type.equals("Silver"))
            return GasdeductionRate = 0.15;
        else if (type.equals("Gold"))
            return GasdeductionRate = 0.2;
        else if (type.equals("Diamond"))
            return GasdeductionRate = 0.25;
        else
            return GasdeductionRate = 0.3;

    }
    private void helpMenu(){
        System.out.println("MMS Menu: ");
        System.out.println("F- Find Slip Details");
        System.out.println("V- View MMS Report");
        System.out.println("A- Archive MMS Report");
        System.out.println("R- Retrieve MMS Report");
        System.out.println("S- Show MMS Log");
        System.out.println("X- Close");
    }

}

