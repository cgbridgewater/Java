import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Welcome to the BatCave!  Please don't touch the Batmobile.";
    }
    
    // public String guestGreeting(String name) {
    //         return "Welcome to the Wayne Mannor " + name;
    // }
                                            //,int dayPeriod
    public String guestGreeting(String name) {
        // if(name){
            return "Welcome to the Wayne Mannor " + name;
        }
        // else if(dayPeriod) { 
            // Int time = new simpleDateFormat();
        //         if(dayPeriod >=5 && dayPeriod < 11)
        //         return String.format("Good morning, $. Welcome to the Batcave", name);
        //         if(dayPeriod >=11 && dayPeriod <16 )
        //         return String.format("Good afternoon, $. Welcome to the Batcave", name);
        //         if(dayPeriod >=16 && dayPeriod <5 )
        //         return String.format("Good evening, $. Welcome to the Batcave", name);
        // }
    // }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The date is " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis")>=0) {
             return "Don't ask her, she doesn't know anything if she can't google what it is";
        }
        else if(conversation.indexOf("Alfred")>0) {
            return "Right away sir, I will find that for you";
        }
        else {
            return "That's good stuff sir, let me know if I can help with anything, like unplugging your FBI, I mean 'Alexa' device.";
        }

        // return "Don't ask her, she doesn't know anything.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String batmobileTouched(String name) {
        return name + ", I wasn't joking when I told you not to touch the Batmobile! I am not the Joker ";
    }
}

