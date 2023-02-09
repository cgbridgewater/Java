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
    System.out.printf("Let me pull a randome letter out of thin air for you. Drumroll please.....  Here's your letter: %s", alphabetSoup[random]);
    System.out.printf("\n"); 
}


public void generatePassword(String randomPW){
    String[] letterOptions = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random letterPicker = new Random(); // declares random function
        for (int i = 0; i < 8; i++) { // Creates 10 slots in the array
        int randomLocation = letterPicker.nextInt(26); // makes a random number 
        // randomPW.add(letterOptions[randomLocation]);
        randomPW += letterOptions[randomLocation];
        }
    System.out.printf("Your random password is : %s ", randomPW); 
    System.out.printf("\n"); 
}
// generatePassword
// white a method that uses the previous methode to create a random string of 8 characters and return the string



// getNewPasswordSet 
// write a method that takes an "int" length as an argument and creates an array of 8 charactor words. 
// The array should be the length of the "int" provided
// return the arraw of the passwords



// shuffleArray
// write a method that takes an array and mizes up the values in a random way (use random indexes within the array and swap values repeatedly)















}