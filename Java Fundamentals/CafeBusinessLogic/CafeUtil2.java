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
    // public double getOrderTotal(double[] lineItems){
    //     double totalPrice = 0;
    //     for(int i = 0; i<= lineItems.length-1; i++) {
    //         totalPrice += lineItems[i];
    //     }
    //         return totalPrice;
    // }

    public double getOrderTotal(double[] lineItems){
        double totalPrice = 0;

        for (double price: lineItems) {
            totalPrice+= price;
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




        // #Ninja Price Charting //  DONE need qty discount still!
    public void printPriceChart(String bulkCoffee, double price, int maxQuantity){
        System.out.printf("%s\n", bulkCoffee); // display bulk item name
        for(int quantity = 1; quantity <= maxQuantity; quantity++) {    // if quantity is less than or equal to Max increase list
            if (quantity == 1) {
                System.out.printf("%s - $%.2f\n", quantity, quantity * price); // display quantity and multiplier
            }
            else
                System.out.printf("%s - $%.2f\n", quantity, (quantity * price)-((quantity-1)*0.5)); // display quantity and multiplier




        }
        System.out.println("\n");
    }




    //#Ninja Overloaded // DONE!!
    public boolean displayMenu(ArrayList<String> menu, ArrayList<Double> prices){
        if(menu.size() != prices.size()){
            System.out.printf("Menu Item and Price List does not match!!");
            return false;
        } 
        for(int i = 0; i< menu.size(); i++){
        System.out.printf("%s %s $%.2f\n", i, menu.get(i), prices.get(i));
        }
        return true;
    }


    //#Ninja Barista Input Test//
        public void addCustomers(ArrayList<String> customerList ){
        boolean dunzo = false;
        String newName;
        while (!dunzo) {
            System.out.println("\n Input a customer name or Slap That Q button to stop:");
            newName = System.console().readLine();
            if (newName.equals("Q")) {
                dunzo = true;
                System.out.println("Bye Felicia");
                return;
            }
            else if (newName.equals("q")) {
                dunzo = true;
                System.out.println("Bye Felicia");
                return;
            }
            customerList.add(newName);
            System.out.printf("%s was added to the list. \n" , newName);
            System.out.printf("Drinks in que for:  %s " ,customerList);
        }
    }

}

