import java.util.ArrayList;
import java.util.Arrays;

class TestOrders{
    public static void main (String[] args) {

        // Create menu items - mocha, latte, drip coffee and capuccino
        Drink mocha = new Drink();
        mocha.name = "Mocha";
        mocha.price = 3.50;

        Drink latte = new Drink();
        latte.name = "Latte";
        latte.price = 3.25;

        Drink dripCoffee = new Drink();
        dripCoffee.name = "Drip Coffee";
        dripCoffee.price = 2.50;

        Drink capuccino = new Drink();
        capuccino.name = "Capuccino";
        capuccino.price = 4.00;


        // Create four orders
        Order order1 = new Order();
        order1.name = "Gryffin";


        Order order2 = new Order();
        order2.name = "Woolie";


        Order order3 = new Order();
        order3.name = "Timmy Trumpet";


        Order order4 = new Order();
        order4.name = "William Black";


        // add drinks to each order
        order1.drinks.add(mocha);
        order1.total += mocha.price;
        order1.drinks.add(dripCoffee);
        order1.total += dripCoffee.price;


        order2.drinks.add(mocha);
        order2.total += mocha.price;


        order3.drinks.add(capuccino);
        order3.total += capuccino.price;


        order4.drinks.add(latte);
        order4.total += latte.price;


        // add 2 more drinks to order 4
        order4.drinks.add(latte);
        order4.drinks.add(latte);
        order4.total += latte.price*2;

        // order status's
        order1.ready = false;
        order2.ready = false;
        order3.ready= true;
        order4.ready= true;





        // Order variables -- order1, order2 etc.
    
        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.println(order1.name);
        // System.out.printf("Name: %s\n", order1.name);
        System.out.println("if i print an order, do I get an object back? My guess is yes");
        System.out.println(order1);
        System.out.println("Yup looks like it");
        System.out.printf("Hi %s, your total is: $%.2f\n",order1.name, order1.total);
        System.out.printf("Hi %s, your total is: $%.2f\n",order2.name, order2.total);
        System.out.printf("Hi %s, your total is: $%.2f\n",order3.name, order3.total);
        System.out.printf("Hi %s, your total is: $%.2f\n",order4.name, order4.total);


        if(order1.ready) {
        System.out.printf("%s your order is ready\n", order1.name );
        }
        else {
            System.out.printf("%s wait for the drop....\n", order1.name);
        }


        if(order2.ready) {
        System.out.printf("%s your order is ready\n", order2.name );
        }
        else {
            System.out.printf("%s wait for the drop....\n", order2.name);
        }


        if(order3.ready) {
        System.out.printf("%s your order is ready\n", order3.name );
        }
        else {
            System.out.printf("%s wait for the drop....\n", order3.name);
        }


        if(order4.ready) {
        System.out.printf("%s your order is ready\n", order4.name );
        }
        else {
            System.out.printf("%s wait for the drop....\n", order4.name);

        }
    


  




        // System.out.printf("Ready: %s\n", order1.ready);
    }
}