public class Session {
    private SuperMarkets superMarkets;

    public static void main(String[] args)
    {
        Session session = new Session();
        session.use();
    }
    public Session()
    {
        superMarkets  = new SuperMarkets();

    }


    private  void use(){
        help();
        char choice =readChoice();


        while (choice != 'X'){
            if (choice == 'L'){
                login();
                choice =readChoice();
            }
            else{
                help();
                choice = readChoice();
            }
        }
        System.out.print("\nSession Terminated!\n");
    }

    private void login(){
        String email = readEmail();
        String password = readPassword();
        superMarkets.Login(email, password);
    }

    public String readEmail(){
        return Utils.string("Email");
    }

    public  String readPassword(){
        return Utils.string("Password");
    }
    private  char readChoice(){
        return Utils.choice("Command (L/X)");
    }


    private  void help(){
        System.out.println("Membership Management System:");
        System.out.println("L- Login");
        System.out.println("X- Exit");
    }
}

