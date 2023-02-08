import java.util.ArrayList;

class Loops {
    public static void main(String[] args) {

        // Desired output:01234
        System.out.println("---NO LOOP");
        System.out.println(0);
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);

        
        // Desired output:01234
        // For loop (increase by 1)
        System.out.println("---FOR LOOP Increase by 1");
        for(int i = 0; i<5; i++) {
            System.out.println(i);
        }

        // For loop (increase by 2)
        System.out.println("---FOR LOOP Increase by 2");
        for(int i = 0; i<5; i+=2) {
            System.out.println(i);
        }        
            
        // For loop (increase by 2)
        System.out.println("---FOR LOOP Decend from 5 to 0");
        for(int i = 5; i>=0; i--) {
            System.out.println(i);
        }        

        //While loop
        System.out.println("---WHILE LOOP");
        int count = 0;
        while(count<5) {
            System.out.println(count);
            count++;
        }
        
        //enhanced loop
        System.out.println("---ENHANCED LOOP");
        String[] fruits = {"banana", "orange", "apple","kiwi"};
        for(String s : fruits) {
            System.out.println(s);
        }
        
        
        //for loop iterating over the length of an array
        System.out.println("---Iterating over LOOP of an array length");
        ArrayList<Object> dynamicArray = new ArrayList<Object>();
        dynamicArray.add("hello");
        dynamicArray.add("world");
        dynamicArray.add("etc");
        for (int i = 0; i < dynamicArray.size(); i++){
            System.out.println(dynamicArray.get(i));
        }
        

        //NEEDS ARRAY BUILT TO WORK//
        // System.out.println("---assign element to manipulate");
        // for(int i = 0; i < dynamicArray.size(); i++){
            //     String name = dynamicArray.get(i);
            //     System.out.println("hello " + name);
            //     // other operations using name
            // }
            
            
        System.out.println("---enhanced for loop");
        ArrayList<Object> dynamicArray2 = new ArrayList<Object>();
        dynamicArray2.add("hello");
        dynamicArray2.add("world");
        dynamicArray2.add("etc");
        for(Object name : dynamicArray2){
            System.out.println("hello " + name);
            // other operations using name
        }


        // Use a for loop to print all odd numbers on the same line
        // Expected output: 13579
        System.out.println("---Practice printing 1 3 5 7 9");
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i =1; i <10; i +=2){
            System.out.println(i);
            // System.out.println(numbers);
        }
    }
}