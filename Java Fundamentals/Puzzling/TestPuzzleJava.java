
import java.util.ArrayList;
import java.util.Random;


public class TestPuzzleJava {
    
    public static void main(String[] args) {

        
        PuzzleJava generator = new PuzzleJava();


        System.out.println("\n----- Generate an array of Random Rolla-----");
        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
            generator.getTenRolls(randomRolls);
        
        
        
        System.out.println("\n----- Generate a single random letter-----");
        ArrayList<String> randomLetter = new ArrayList<String>();
            generator.getRandomLetter(randomLetter);

        
        System.out.println("\n----- Generate a random 8 letter password-----");
        String randomPW ="";
            generator.generatePassword(randomPW);




        // System.out.println("----- Generate a random passwords basedo on int input-----");
        // ArrayList<String> randomLetter = new ArrayList<String>();
            // int pwQty;
        //     generator.getNewPasswordSet(randomLetter, pwQty);




        // System.out.println("----- Truffle Array Shuffle-----");
        // ArrayList<String> shuffle = new ArrayList<String>();
        //     generator.shuffleArray(shuffle);


    }
}