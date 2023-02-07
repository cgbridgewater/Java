import java.util.Date;
public class AlfredQuotes {
    
    // basic greeting
    public String basicGreeting() {
        return "Welcome to the BatCave!  Please don't touch the Batmobile.";
    }

    // guest greeting with name in function
    public String guestGreeting(String name) {
            return "Welcome to the Wayne Mannor " + name;
    }

    // using date time to announce time of day
    public String dateAnnouncement() {
        Date date = new Date();
        return "The Official Bat Time is " + date;
    }
    
    //using an IF statement to utilize indexOf to inspect string for specific words present and respond
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis")>=0) {
            return "Don't ask her, she doesn't know anything if she can't google what it is";
        }
        else if(conversation.indexOf("Alfred")>0) {
            return "Right away sir, I will find that for you...";
        }
        else {
            return "That's good stuff sir, let me know if I can help with anything, like unplugging your FBI, I mean 'Alexa' device.";
        }
    }
    
	// NINJA BONUS method overload
    public String guestGreeting2(String name, String dayPeriod) {
        return String.format("Good %s, %s. Welcome to the Batcave", dayPeriod, name);
    }

    // SENSEI BONUS making my own method
    public String batmobileTouched(String name) {
        return name + ", I wasn't joking when I told you not to touch the Batmobile! Who do you think I am, The Joker?";
    }
}

