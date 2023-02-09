import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

    public int getStreakGoal(int numWeeks){
        int count = 0;
        int sum = 0;
        while(count<=numWeeks) {
            sum += count;
            count++;
        }
            return sum;
    }


    public double getOrderTotal(double[] lineItems){
        double totalPrice = 0;
        for(int i = 0; i<= lineItems.length-1; i++) {
            totalPrice += lineItems[i];
        }
            return totalPrice;
    }



    //#3 //
    public void displayMenu(){
        ArrayList<String> menu = new ArrayList<String>();
        String names = "";
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        // cafeUtil.displayMenu(menu);
        for(int i = 0; i< menu.size(); i++){
            names += (i +" " + menu.get(i)+" \n\n" );
        }
        System.out.println(names);
    }


    //#4 //
    public void AddCustomer(){
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        System.out.println("Please Enter your name:");
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.println("Hello, "+ userName);
        System.out.println("There are " + (customers.size()-1) + " people in front of you");
        System.out.println("Waiting on drinks: " + customers);
    }

}

