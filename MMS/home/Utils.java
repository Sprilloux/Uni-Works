import java.util.*;


public class Utils{
    private static final Scanner scanner = new Scanner(System.in);
    public static final String mmsFormat = "| %-18s | %-13.2f | %-13.2f | %-13d | %-8s |%n";
    public static final String membershipFormat = "| %-20s | %-25s | %-10s | %-10s |%n";
    public static final String sumFormat = "| %-26s |  %-11.2f  |%n";
    public static final String logFormat = "| %-12s |  %-11s   |%n";
    
    
    public static String string(String prompt){
        System.out.print(prompt+": ");
        return scanner.nextLine();
    }
    
    public static char choice(String prompt){
        System.out.print(prompt+": ");
        return scanner.nextLine().charAt(0);
    }
    
    public static double amount(String prompt){
        System.out.print(prompt+": ");
        double value = scanner.nextDouble();
	    scanner.nextLine();
	    return value;
        
    }
    
    public static boolean check(String prompt){
        System.out.print(prompt+": ");
        String s=scanner.nextLine();
        if (!s.equals("2022AUT"))//promo code
           return false;
        else 
           return true;
    }
    
    public static int number(String prompt){
        System.out.print(prompt+": ");
        int value = scanner.nextInt();
		scanner.nextLine(); 
		return value;
    }
    
    public static String formattedValue(String symbol, double value){
        return String.format(symbol+"%.2f", value);
    }
    
    public static void membershipHeader( ){
         System.out.format("+----------------------+---------------------------+------------+------------+%n");
         System.out.format("| Membership Name      | Email                     |  Phone     | Type       |%n");
         System.out.format("+----------------------+---------------------------+------------+------------+%n");
    }
    public static void membershipTableEnd(){
        System.out.format("+----------------------+---------------------------+------------+------------+%n");
    }
    public static void slipTableEnd()
    {
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");
    }
    public static void Totalslipheader()
    {
        System.out.println("MMS Report: ");
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");
        System.out.format("| Membership Name    | Expense       | Credit        | Dollars       | Type     |%n");
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");
    }
    public static void TotalslipTableEnd()
    {
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");

    }
    public static void slipHeader( ){
        System.out.println("Slip Details:");
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");
        System.out.format("| Membership Name    | Expense       | Credit        | Dollars       | Type     |%n");
        System.out.format("+--------------------+---------------+---------------+---------------+----------+%n");

    }
    public static void TotalSumHeader()
    {
        System.out.format("+----------------------------+---------------+%n");
    }
    public static void TotalSumTableEnd()
    {
        System.out.format("+----------------------------+---------------+%n");
    }
    public static void logHeader( ){
        System.out.println("MMS Archive:");
        System.out.format("+--------------+----------------+%n");
        System.out.format("| MMS Record   |  RecordID      |%n");
        System.out.format("+--------------+----------------+%n");
    }
    public static void LogTableEnd()
    {
        System.out.format("+--------------+----------------+%n");
    }
}

