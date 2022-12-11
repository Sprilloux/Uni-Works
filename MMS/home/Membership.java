public class Membership {
    private String ID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type;
    private double expense;
    private int payPerCredit;
    private double totalCredits;
    private double GasdeductionRate;
    private int DollarAvailable;

    private double deductionRate;


    public Membership(String ID, String name, String email, String phone, String address, double expense)
    {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.expense = expense;
        this.type = getType(expense);
        this.payPerCredit = getPayPerCredit(type);
        this.totalCredits = payPerCredit * expense;
        this.GasdeductionRate = getGasdeductionRate(type);
        this.deductionRate = getdeductionRate(type);
        this.DollarAvailable = (int)totalCredits / 200;



    }

    public String getType(double expense){
        
        if (expense < 500){
            return type = "Bronze";
        }
        else if (500 <= expense && expense < 1500){
            return type = "Silver";
        }
        else if (1500 <= expense && expense < 3000){
            return type = "Gold";
        }
        else if (3000 <= expense && expense < 5000){
            return type = "Diamond";
        }
        else {
            return type = "Platinum";
        }
    }

    public int getPayPerCredit(String type){
        
            if (type.equals("Bronze"))
                return payPerCredit = 20;
            else if (type.equals("Silver"))
                return payPerCredit = 10;
            else if (type.equals("Gold"))
                return payPerCredit = 8;
            else if (type.equals("Diamond"))
                return payPerCredit = 6;
            else
                return payPerCredit = 4;
        
    }

    public double getTotalCredits(int PerCredit, double expense){
        return PerCredit * expense;
    }

    public double getdeductionRate(String type){
        switch (type) {
            case "Bronze":
                return deductionRate = 0.05;
            case "Silver":
                return deductionRate = 0.1;
            case "Gold":
                return deductionRate = 0.15;
            case "Diamond":
                return deductionRate = 0.2;
            default:
                return deductionRate = 0.25;
        }
    }

    public double getGasdeductionRate(String type){
        switch (type) {
            case "Bronze":
                return GasdeductionRate = 0.1;
            case "Silver":
                return GasdeductionRate = 0.15;
            case "Gold":
                return GasdeductionRate = 0.2;
            case "Diamond":
                return GasdeductionRate = 0.25;
            default:
                return GasdeductionRate = 0.3;
        }
    }

    public int getDollarAvailable(double totalCredits){
        return (int)totalCredits / 200;
    }
    public Boolean hasName(String name){return name.equals(this.name);}

    public String getName(){
        return this.name;
    }

    public double getExpense(){
        return this.expense;
    }

    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){
        return this.email;
    }

    //public String getAddress(){return this.address;}

    //public String getID(){return this.ID;}

    public void setName(String name){this.name = name;}

    public void setEmail(String email){this.email = email;}

    public void setPhone(String phone){this.phone = phone;}

    public void setExpense(double expense){this.expense = expense;}

    public void setAddress(String address){this.address = address;}

    public void setID(String ID){this.ID = ID;}



}




