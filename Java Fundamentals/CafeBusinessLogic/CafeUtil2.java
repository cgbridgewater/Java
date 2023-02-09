import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil2 {

    // #1 // DONE
    public int getStreakGoal(int numWeeks){
        int count = 0;
        int sum = 0;
        while(count<=numWeeks) {
            sum += count;
            count++;
        }
            return sum;
    }


    // #2 // DONE
    public double getOrderTotal(double[] lineItems){
        double totalPrice = 0;
        for(int i = 0; i<= lineItems.length-1; i++) {
            totalPrice += lineItems[i];
        }
            return totalPrice;
    }


    //#3 // DONE!!
    public void displayMenu(ArrayList<String> menu){
        // String drinkNames = "";
        for(int i = 0; i< menu.size(); i++){
            // drinkNames += (i +" " + menu.get(i)+" \n\n" );
        System.out.printf("%s %s \n", i, menu.get(i));
        }
        // System.out.println(drinkNames);
    }


    //#4 // 
    public void addCustomer(ArrayList<String> listOfCustomers ){
        System.out.println("Please Enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!", userName);
        System.out.printf("There are %s people in front of you. \n", listOfCustomers.size());
        listOfCustomers.add(userName);
        System.out.printf("Waiting on drinks: %s", listOfCustomers);
    }



    //#3 Overloaded // DONE!!
    public void displayMenu(ArrayList<String> menu, ArrayList<Double>price){
        // String drinkNames = "";
        for(int i = 0; i< menu.size(); i++){
            // drinkNames += (i +" " + menu.get(i)+" \n\n" );
        System.out.printf("%s %s $%.2f\n", i, menu.get(i), price.get(i));
        }
        // System.out.println(drinkNames);
    }





}

