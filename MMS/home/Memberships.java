

import java.lang.reflect.Member;
import java.util.ArrayList;

public class Memberships {

    private ArrayList<Membership> Memberships;


    public Memberships()
    {
        Memberships = new ArrayList<Membership>();
        Memberships.add(new Membership("13697480", "Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", 2134.5));
        Memberships.add(new Membership("14517880", "Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", 4512.2));
        Memberships.add(new Membership("13267102", "Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", 158.4));
        Memberships.add(new Membership("13678020", "Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", 7596.3));
        Memberships.add(new Membership("13972870", "Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", 1100.0));
        Memberships.add(new Membership("13859610", "Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", 6741.2));
    }

    public ArrayList<Membership> getList(String name, String type, double totCredit, double Gas, double Dollar, double ded, int Pay, double expense){
        for (Membership membership : Memberships){
            name = membership.getName();
            type = membership.getType(expense);
            expense = membership.getExpense();
            totCredit = membership.getTotalCredits(Pay,expense);
            Gas = membership.getGasdeductionRate(type);
            Dollar = membership.getDollarAvailable(totCredit);
            ded = membership.getdeductionRate(type);
            Pay = membership.getPayPerCredit(type);

        }
        return Memberships;
    }
    public void addMember(){
        String name = Utils.string("Name");
        String email = Utils.string("Email");
        String phone = Utils.string("Phone");
        String address = Utils.string("Address");
        String ID = Utils.string("ID");
        int expense = Utils.number("expense");
        Memberships.add(new Membership(ID, name, email, phone, address, expense));
        System.out.print(name + " record has been created.");

    }

    public void deleteMembership(){
        boolean state = false;
        String name = Utils.string("Name");
        for (Membership membership : Memberships){
            if(membership.hasName(name)){

                Memberships.remove(membership);
                System.out.print(name + " record has been deleted.");
                state = true;
                break;
            }

        }
        if(!state){
            System.out.print(name + " record does not exist!");
        }

    }

    public void viewMemberships(){
        Utils.membershipHeader();

        for (Membership membership : Memberships){
            double expense = membership.getExpense();
            String name = membership.getName();
            String phone = membership.getPhone();
            String type = membership.getType(expense);
            String email = membership.getEmail();
            System.out.format(Utils.membershipFormat, name,email, phone, type);
        }
        Utils.membershipTableEnd();
    }

    public void retrieveMember(){
        boolean state = false;
        String name = Utils.string("Name");
        for (Membership membership : Memberships){
            if(membership.hasName(name)){
                double expense = membership.getExpense();
                String nameM = membership.getName();
                String phone = membership.getPhone();
                String type = membership.getType(expense);
                String email = membership.getEmail();
                Utils.membershipHeader();
                System.out.format(Utils.membershipFormat, nameM,email, phone, type);
                Utils.membershipTableEnd();
                state = true;
                break;
            }

        }
        if(!state){
            System.out.print(name + " record does not exist!\n");
        }

    }

    public void updateMembers(){
        boolean state = false;
        String name = Utils.string("Name");
        for (Membership membership : Memberships){
            if(membership.hasName(name)){
                System.out.print("Updating " + name + " record: \n");
                int c = Memberships.indexOf(membership);

                String nameM = Utils.string("Name");
                String email = Utils.string("Email");
                String phone = Utils.string("Phone");
                String address = Utils.string("Address");
                String ID = Utils.string("ID");
                int expense = Utils.number("expense");
                Memberships.get(c).setName(nameM);
                Memberships.get(c).setEmail(email);
                Memberships.get(c).setPhone(phone);
                Memberships.get(c).setAddress(address);
                Memberships.get(c).setID(ID);
                double i = Memberships.get(c).getExpense();
                Memberships.get(c).setExpense(expense + i);
                System.out.println(nameM+" record has been updated.");
                state = true;
                break;
            }

        }
        if(!state){
            System.out.print(name + " record does not exist!\n");
        }
    }
}











