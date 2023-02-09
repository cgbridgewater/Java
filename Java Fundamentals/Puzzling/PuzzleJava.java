import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {


public void getTenRolls(ArrayList<Integer> randomRolls){
    Random randomNum = new Random(); //declares random function
    for (int i = 0; i < 10; i++) {
    Integer random = randomNum.nextInt(21); // makes random number
            randomRolls.add(random); // pushes random number to the array
    }
    System.out.println(randomRolls); 
}


// getRandomLetter
// create a method that will contain an array of the alphabet (26 values)
// generate a random index 0-25 to pull a random letter from the array and return that letter



// generatePassword
// white a method that uses the previous methode to create a random string of 8 characters and return the string



// getNewPasswordSet 
// write a method that takes an "int" length as an argument and creates an array of 8 charactor words. 
// The array should be the length of the "int" provided
// return the arraw of the passwords



// shuffleArray
// write a method that takes an array and mizes up the values in a random way (use random indexes within the array and swap values repeatedly)















}