import java.util.ArrayList;

public class MMSlip {

    private String name;
    private String type;
    private double totalCredits;
    private double GasdeductionRate;
    private int DollarAvailable;
    private double deductionRate;
    private int PayPerCredit;
    private double expense;
    public MMSlip(Membership membership) {

        this.name = membership.getName();
        this.expense = membership.getExpense();
        this.type = membership.getType(expense);
        this.totalCredits = membership.getTotalCredits(PayPerCredit,expense);
        this.GasdeductionRate = membership.getGasdeductionRate(type);
        this.DollarAvailable = membership.getDollarAvailable(totalCredits);
        this.deductionRate = membership.getdeductionRate(type);
        this.PayPerCredit = membership.getPayPerCredit(type);

    }



    public Boolean hasname(String name){return name.equals(this.name);}

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getDollar(){
        return this.DollarAvailable;
    }
    public double getCredit(){
        return this.totalCredits;
    }
    public double getExpense(){
        return this.expense;
    }

}


