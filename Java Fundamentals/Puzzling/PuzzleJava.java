import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {


public void getTenRolls(ArrayList<Integer> randomRolls){
    Random randomNum = new Random(); //declares random function
        for (int i = 0; i < 10; i++) { // Creates 10 slots in the array
            Integer random = randomNum.nextInt(21); // makes random number
            randomRolls.add(random); // pushes random number to the array
        }
    System.out.println(randomRolls); 
}


public void getRandomLetter(ArrayList<String> randomLetter){
    String[] alphabetSoup = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random randomInt = new Random(); // declares random function
    int random = randomInt.nextInt(26); // makes a random number
    System.out.printf("Let me pull a random letter out of thin air for you. Drumroll please.....  Here's your letter: %s", alphabetSoup[random]);
    System.out.printf("\n"); 
}


public void generatePassword(String randomPW){
    String[] letterOptions = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random letterPicker = new Random(); // declares random function
        for (int i = 0; i < 8; i++) { // Creates 8 slots in the string
        int randomLocation = letterPicker.nextInt(26); // makes a random number 
        randomPW += letterOptions[randomLocation];//concatinates the new letter with the old ones
        }
    System.out.printf("Your random password is : %s ", randomPW); 
    System.out.printf("\n"); 
}


public void getNewPasswordSet(String randomPassword, int pwQty){
    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random letterSelector = new Random(); // declares random function
    ArrayList<String> passwordArray = new ArrayList<String>();
    int count = 0;
        while (count < pwQty) {
        // for (int i = 0; i < pwQty; i++) {
            for (int ii = 0; ii < 8; ii++) { // Creates 8 slots in the string
                int randomLocation = letterSelector.nextInt(26); // makes a random number 
                randomPassword += alphabet[randomLocation]; //concatinates the new letter with the old ones
                }
            // System.out.printf("Your random password is : %s ", randomPassword); // print each password before adding to string for trouble shooting
            // System.out.printf("\n"); 
            passwordArray.add(randomPassword);
            randomPassword = "";
            count++;
        }

    System.out.printf("\nYour list of %s passwords is : %s ",pwQty, passwordArray); 
    System.out.printf("\n"); 
}



// getNewPasswordSet 
// write a method that takes an "int" length as an argument and creates an array of 8 charactor passwords. 
// The array should be the length of the "int" provided
// return the arraw of the passwords



// shuffleArray
// write a method that takes an array and mizes up the values in a random way (use random indexes within the array and swap values repeatedly)















}