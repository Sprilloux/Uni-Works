
import javax.naming.Name;
import java.util.ArrayList;

public class SuperMarkets {

    ArrayList<SuperMarket> SuperMarkets;

    public SuperMarkets() {
        SuperMarkets = new ArrayList<SuperMarket>();
        SuperMarkets.add(new SuperMarket("John Smith" , "john.smith@uts.com" , "user222"));
        SuperMarkets.add(new SuperMarket("Jane Tyler" , "jane.tyler@uts.com" , "super123"));
    }

    public void Login(String email, String Password){
        boolean state = false;
        for(SuperMarket supermarket: SuperMarkets){

            if (supermarket.hasEmail(email) && supermarket.hasPassword(Password)){
                String name = supermarket.getName();
                supermarket.adminLog(name);
                state = true;

            }


        }
        if (!state){
            System.out.println("Incorrect SuperMarket details!");
        }



    }



}


