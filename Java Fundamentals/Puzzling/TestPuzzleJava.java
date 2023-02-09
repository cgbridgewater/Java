
import java.util.ArrayList;
import java.util.Random;


public class TestPuzzleJava {
    
    public static void main(String[] args) {

        
        PuzzleJava generator = new PuzzleJava();


        System.out.println("----- Random Roll-----");

        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
            generator.getTenRolls(randomRolls);




        
        //..
        // Write your other test cases here.
        //..
    }
}




//getTenRolls
// make a method that will generate and return an array with 10 randome numbers 1-20 inclusive



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