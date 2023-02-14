public class Greeter {
    public String greet(String name){
        return createGreeting(name);
    }

    public String greet(){
        return createGreeting("World");
    }

    public String greet( String firstName, String lastName){
        return createGreeting(firstName + " " + lastName);
    }
//modifier// returnType // methodName (methodParameters) {methodBody }
    private String createGreeting(String toBeGreeted){
        return "Greetings " + toBeGreeted + ", welcome to Coding Dojo";
    }

    public static void testGreeting(String name){
        System.out.println("this is a test of a static method, " + name);
    }


}