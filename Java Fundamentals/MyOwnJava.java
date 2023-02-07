public class MyOwnJava {
    public static void main(String[] args) {
        System.out.println("My name is Chris B.\nI am 43 years old\nMy hometown is Creswell, OR\nI'm testing my GH Repo Change with this line."
        );


        System.out.println("---IF statement test---");
        boolean isRaining = true;
            
        if(isRaining) {
            System.out.println("Bring an umbrella.");
        }
        else {
            System.out.println("Have fun!");
        }


                System.out.println("---Switch Operator says....---");
                int day = 2;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There are only seven days in a week...");
        }


        System.out.println("---Another Switch Test---");
        int goals = 3;
        boolean watchReplay = false;

        System.out.println("Are we watching this?");

        switch(goals){
            case 0:
            System.out.println("Sounds like a boring game.");
                break;
            case 1:
            System.out.println("Was it a good goal?");
            watchReplay = true;
                break;
            case 2:
            System.out.println("Was it a tie?");
            watchReplay = true;
                break;
            case 3:
            System.out.println("I can't wait to see it!");
            watchReplay = true;
                break;
            default:
            System.out.println("More than 3 goals? I'm in!");
            watchReplay = true;
        }


        System.out.println("---Ternary test---");
        System.out.println(watchReplay ? "I'll see you in a bit." : "I'll pass.");
    }
}