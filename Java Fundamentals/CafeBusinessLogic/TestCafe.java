import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
            CafeUtil cafeUtil = new CafeUtil();
        
        /* ============ App Test Cases ============= */


        // Test #1 //
        System.out.println("\n----- Streak Goal Test -----"); //DONE
        int num = 12;
        System.out.printf("Purchases needed by week " + num + " : %s \n\n", cafeUtil.getStreakGoal(num));


        // Test #2 //
        System.out.println("----- Order Total Test-----"); //DONE
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n" , cafeUtil.getOrderTotal(lineItems));


        //Test #3 //
        System.out.println("----- Display Menu Test-----");
        cafeUtil.displayMenu();


        //Test #4 //
        System.out.println("\n----- Add Customer Test-----");
        cafeUtil.AddCustomer();


    }
}
