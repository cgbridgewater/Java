public class TestGreeter {
    public static void main (String [] args){

        Greeter g = new Greeter();

        String greeting =g.greet();
        System.out.println(greeting);

        String greetingWithName = g.greet("Chris");
        System.out.println(greetingWithName);

        String anotherGreetingWithName = g.greet("Chris", "Bridgewater");
        System.out.println(anotherGreetingWithName);


        System.out.println("\n");

        Greeter.testGreeting("Christoph");


        // if (greeting.equals("Hello World") || greetingWithName.equals("Hello Chris")){
        //     System.out.println("Test Successful");
        // } else{
        //     System.out.println("Test Failed");
        // }

    }
}