import java.util.ArrayList;
import java.util.Arrays;

class TestOrders{
    public static void main (String[] args) {


        Item drink1 = new Item("Mocha", 4.50);
        Item drink2 = new Item("Hot Chocolate", 3.50);
        Item drink3 = new Item("Drip Coffee", 2.50);
        Item drink4 = new Item("Cappuccino", 5.50);
        ArrayList<Item> itemList1 = new ArrayList<Item>(){
            {
                add(drink1);
                add(drink2);
                add(drink3);
            }
        };


        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Timmy Trumpet");
        Order order4 = new Order("Gryffin");
        Order order5 = new Order("William Black");
        Order order6 = new Order("Woolie", itemList1);

        //starting point for above orders
        System.out.println("----------------Display initial orders");
        order1.displayOrder();
        order2.displayOrder();
        order3.displayOrder();
        order4.displayOrder();
        order5.displayOrder();
        order6.displayOrder();

        // add 2 drinks for everyone 
        order1.setItems(drink1);
        order1.setItems(drink2);
        order2.setItems(drink3);
        order2.setItems(drink4);
        order3.setItems(drink1);
        order3.setItems(drink2);
        order4.setItems(drink3);
        order4.setItems(drink4);
        order5.setItems(drink1);
        order5.setItems(drink2);
        order6.setItems(drink3);
        order6.setItems(drink4);


        // assign names to 'guest' orders
        order1.setName("Tiesto");
        order2.setName("Cash Cash");

        System.out.printf("\n");

        // Show order total
        System.out.println("----------------Show Order Totals");
        order1.showTotal();
        order2.showTotal();
        order3.showTotal();
        order4.showTotal();
        order5.showTotal();
        order6.showTotal();

        System.out.printf("\n");

        // display again with updated drink list
        System.out.println("----------------Show Updated Orders");
        order1.displayOrder();
        order2.displayOrder();
        order3.displayOrder();
        order4.displayOrder();
        order5.displayOrder();
        order6.displayOrder();
        

        // Display order status
        System.out.printf("\n");
        System.out.println("----------------Show Orders Status");
        order1.getStatusMessage(true);
        order2.getStatusMessage(false);
        order3.getStatusMessage(true);
        order4.getStatusMessage(false);
        order5.getStatusMessage(true);
        order6.getStatusMessage(false);



        // System.out.println(order2);
        // System.out.println(order2.getItems());


        // order2.setItems(drink3);
        // System.out.println(order2.getItems());
        // System.out.println(order2.getName());


        // order1.setName("Mike");
        // System.out.println(order1.getName());
        // System.out.println(order1.getIsReady());
        // order1.setIsReady(true);
        // System.out.println(order1.getIsReady());
        
        
        
        // order3.displayOrder();

        


    }

}