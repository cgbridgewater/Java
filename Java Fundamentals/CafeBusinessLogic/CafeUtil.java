import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

    public int getStreakGoal(int numWeeks){
        // int numWeeks = 10;
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


    public void displayMenu(ArrayList<String> menuItems){
        String names = "";
        for(int i = 0; i< menuItems.size(); i++){
        names += (i +" " + menuItems.get(i)+" \n\n" );
        }
        System.out.println(names);
        // return names;
    }


    public void AddCustomer(ArrayList<String>customers){
        String customerList = "";
        for (int i = 0; i < customers.size(); i++) {
            customerList += customers.get(i) + "\n";
        }
            System.out.println(customerList);
        // return"spaceholder";
    }

}

