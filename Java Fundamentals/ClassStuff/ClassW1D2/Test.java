import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main (String[] args){

        Drink myDrink = new Drink("Mocha", 2.99, 12);
        // myDrink.name = "Mocha";
        // myDrink.price = 2.99;
        // myDrink.numberOfOunces= 12;

        String output = String.format("This is our %s. It costs %s and is %s ounces.", myDrink.getName(), myDrink.checkPrice(), myDrink.getOunces());
        System.out.println(output);







        //CODE HERE
        // Fixed Array
        // int[] myArray = new int [5];
        // myArray[0] = 12;
        // for(int i=0; i<myArray.length; i++)
        // System.out.println(myArray[i]);

        // ArrayList<Integer> myList = new ArrayList<Integer>();
        // .add(index, element to add)
        // myList.add(42)
        // for (int i= 0; i<=10 ; i++){
        //     myList.add(3*i);    
        // }
        // System.out.println(myList);
        // for(Integer number : myList){
        //     switch(number){
        //         case 1: number %2 && number %5;
        //         break;
        //         case 2: number %2;
        //         break;
        //         case 3: number %5;
        //         break;
        //         default:
        //     }
        // }

    }
}