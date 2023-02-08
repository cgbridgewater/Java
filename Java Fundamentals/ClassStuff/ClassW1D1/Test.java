public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        //return "Hello World";

        //Variables
        int myInteger = 2;
        Integer intObject = 3; //Objects can go into arrays!  primative cannot
        long myLong = 15;
        double myDouble = 2.99;
        boolean myBool = true;
        String myString = "I am a string";
        char myChar = 'a'; //OLD type

        // Conditionals
        if (myBool) {
            System.out.println("it's True!");
        } else {
            System.out.println("it's false");
        }
        
        // Ternary
        System.out.println(myBool ? "It's True!":"It's False!");
        
        
        //Switch case
        switch(myInteger) {
            case 0:
                System.out.println("one");
                break;
            case 1:
                System.out.println("two");
                break;
            case 2:
                System.out.println("three");
                break;
            default:
                System.out.println("default statement");
        }

        // Looping
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}
