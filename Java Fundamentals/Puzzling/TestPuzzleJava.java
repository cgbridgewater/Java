import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class TestPuzzleJava {

    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();



        //#1
        System.out.println("\n----- Generate an array of Random Rolls-----");
        ArrayList<Integer> randomRolls = new ArrayList<Integer>();
            generator.getTenRolls(randomRolls);



        //#2
        System.out.println("\n----- Generate a single random letter-----");
        ArrayList<String> randomLetter = new ArrayList<String>();
            generator.getRandomLetter(randomLetter);



        //#3
        System.out.println("\n----- Generate a random 8 letter password-----");
        String randomPW ="";
            generator.generatePassword(randomPW);



        //#4
        System.out.println("\n----- Generate a random passwords based on 'int' input-----");
        String randomPassword = "";
        System.out.println("\n Please enter the number of random passwords you would like created: \n");
        // int pwQty = 5;
        Scanner in = new Scanner(System.in);
        int pwQty = in.nextInt();
            generator.getNewPasswordSet(randomPassword, pwQty);



        // #5
        System.out.println("\n\n----- Truffle Array Shuffle-----");        
            generator.shuffleArray();


    }
}