import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe2 {
    public static void main(String[] args) {
        
            CafeUtil2 appTest = new CafeUtil2();
        
        /* ============ App Test Cases ============= */


        // Test #1 //
        System.out.println("\n----- Streak Goal Test -----"); //DONE
        int num = 12;
        System.out.printf("Purchases needed by week " + num + " : %s \n\n", appTest.getStreakGoal(num));



        // Test #2 //
        System.out.println("----- Order Total Test-----"); //DONE
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n" , appTest.getOrderTotal(lineItems));



        //Test #3 //
        System.out.println("----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
            menu.add("drip coffee");
            menu.add("cappuccino");
            menu.add("latte");
            menu.add("mocha");
        appTest.displayMenu(menu);


        //Test #4 //
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();

        // --- Test 4 times --- //
        
        for (int i = 0; i < 5; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        
        //Test #3 Overloaded //
        System.out.println("----- Display Menu Test-----");
        ArrayList<String> drinks = new ArrayList<String>();
            drinks.add("drip coffee");
            drinks.add("cappuccino");
            drinks.add("latte");
            drinks.add("mocha");
        ArrayList<Double> price = new ArrayList<Double>();
            price.add(2.00);
            price.add(3.50);
            price.add(4.50);
            price.add(5.00);
        appTest.displayMenu(drinks, price);


    }
}
