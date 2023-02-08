public class StringDemo {
    public static void main(String[] args) {
        //.length
        System.out.println("---Using string.length---");
        String ninja = ("Coding Dojo is Awesome!");
        int length = ninja.length();
        System.out.println(ninja);
        System.out.println( "The length of that string is : " + length );


        //.concat
        System.out.println("---Using string.concat---");
        String string1 = "My name is ";
        String string2 = "Chris";
        String string3 = string1.concat(string2);
        System.out.println(string3);


        // .format 
        System.out.println( "---Another way to concatenating things together---" );
        String ninja2 = String.format("Hi %s, you owe me $%.2f!", "Jack", 25.0);
        System.out.println(ninja2);
        System.out.println(string2 + " says, 'pay up sucka!'");


        // .indexOf
        System.out.println( "---Using index---" );
        String ninjas = "welcome to Coding Dojo!";
        int a = ninjas.indexOf("Coding");
        int b = ninjas.indexOf("co");
        int c = ninjas.indexOf("pizza");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        // .trim
        System.out.println( "---Using trim---" );
        String sentence = "   spaces everywhere!   ";
        System.out.println(sentence.trim());


        // Equality
        System.out.println( "---Using equality---" );
        String d = new String( "Dojo" );
        System.out.println( d == "Dojo" );
        // surprisingly this will print out `false`

        String e = new String( "Dojo" );
        System.out.println( e.equals("Dojo") );
        // this actually will print out `true`

        System.out.println( "---TREAT YO SELF!---" );




    }
}