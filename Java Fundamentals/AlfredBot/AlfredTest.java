public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();  //done
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");  // done
        String testDateAnnouncement = alfredBot.dateAnnouncement();  //done
        
        String alexisTest = alfredBot.respondBeforeAlexis( // done
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis( // done
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis( // done
            "Maybe that's what Batman is about. Not winning. But failing.."
        );

        String whoTouchedTheBatmobile = alfredBot.batmobileTouched("Robin");  // done


        
        // Print the greetings to test.
        System.out.println("---Test Greeting---");
        System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        System.out.println("---Test Guest Greeting");
        System.out.println(testGuestGreeting);
        System.out.println("---Test Date announcement");
        System.out.println(testDateAnnouncement);
        System.out.println("---Test alexis test");
        System.out.println(alexisTest);
        System.out.println("---Test Alfred test");
        System.out.println(alfredTest);
        System.out.println("---Test Not Relevant convo ");
        System.out.println(notRelevantTest);
        
        // Ninja bonus
        System.out.println("---Test Don't Touch The Batmobile");
        System.out.println(whoTouchedTheBatmobile);
    }
}
