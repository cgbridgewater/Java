public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        
        // Menu variables (add yours below)
        double mochaPrice = 3.50;
        double dripCoffee = 4.00;
        double latte = 4.99;
        double cappucino = 5.50;
        // double error = 0;

    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // #1
        System.out.println("customer scenario 1");
        System.out.println(generalGreeting + customer1);
        System.out.println(displayTotalMessage + dripCoffee + (isReadyOrder1 ? readyMessage:pendingMessage));


        // #2
        System.out.println("customer scenario 2");
        if(isReadyOrder4) {
        System.out.println(customer4 + readyMessage + ". " + displayTotalMessage + cappucino);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }


        // #3
        System.out.println("customer scenario 3");
        if(isReadyOrder2) {
        System.out.println(customer2 + readyMessage + ". " + displayTotalMessage + (cappucino*2));
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // #4
        System.out.println("customer scenario 4");
        double roundError = Math.round((latte-dripCoffee)*100)/100.0;
        System.out.println(customer3 + " " + displayTotalMessage + roundError + (isReadyOrder3 ? readyMessage:pendingMessage) );
    }
}
