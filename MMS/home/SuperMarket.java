
import java.util.Arrays;

public class SuperMarket {
    private String name;
    private String email;
    private String password;
    private Memberships Memberships;
    private MMSLog mMSLog;

    private MMS mms;




    public SuperMarket(String name,String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        mMSLog = new MMSLog();
        Memberships = new Memberships();
        mms = new MMS(this, Memberships);
    }


    public Boolean hasEmail(String email){return email.equals(this.email);}

    public Boolean hasPassword(String password){return password.equals(this.password);}

    public String getName(){
        return this.name;
    }

    public void adminLog(String name){
        helpMenu();
        SuperMarket superMarket = new SuperMarket(name,email,password);
        //System.out.print("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X): ");
        char choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
        while (choice != 'X'){
            switch(choice){
                case 'C':
                        Memberships.addMember();
                        choice = Utils.choice("\nSession Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                        break;
                case 'R':
                    Memberships.retrieveMember();
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                    break;
                case 'U':
                        Memberships.updateMembers();
                        choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                        break;
                case 'D':
                        Memberships.deleteMembership();
                        choice = Utils.choice("\nSession Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                        break;
                case 'V':
                        Memberships.viewMemberships();
                        choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                        break;
                case 'M':
                        mms.MMSmenu(name);
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                case 'X':
                        break;
                default:
                    
                    helpMenu();
                    choice = Utils.choice("Session Admin: " + name + " - Menu Commands (C/R/U/D/V/M/X)");
                    
            }

        }
        System.out.println("\nMMS Management System:");

    }


    private void helpMenu(){
        System.out.println("Admin Menu: ");
        System.out.println("C- Add Membership");
        System.out.println("R- View Membership");
        System.out.println("U- Update Membership");
        System.out.println("D- Delete Membership");
        System.out.println("V- View Memberships");
        System.out.println("M- MMS Menu");
        System.out.println("X- Logout");
    }
}



