import java.util.Arrays;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LearningJavaSyntax {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String wordToGuess = "elderberry";
        int attempts = 0;
        int maxAttempts = 6;
        boolean isWordGuessed = false;

        char[] wordGuessedArray = new char[wordToGuess.length()];

        Arrays.fill(wordGuessedArray, '_');

        while (!isWordGuessed && attempts != maxAttempts) {
            System.out.println("Current word: " + Arrays.toString(wordGuessedArray));
            System.out.println("Attempts: " + attempts + "/" + maxAttempts);
            System.out.println("Enter a letter: ");
            char letter = input.next().charAt(0);
            while (Character.isDigit(letter)) {
                System.out.println("Please enter a letter: ");
                letter = input.next().charAt(0);
            }
            letter = Character.toLowerCase(letter);

            boolean letterGuessed = false;


            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    letterGuessed = true;
                    wordGuessedArray[i] = letter;
                }
            }

            if (!letterGuessed) {
                attempts++;
                System.out.println("Wrong letter! Try again.");
            }

            if (wordToGuess.equals(String.valueOf(wordGuessedArray))) {
                isWordGuessed = true;
                System.out.println("Congratulations! You guessed the word!");
                System.out.println("The word was: " + wordToGuess);
            } else if (attempts == maxAttempts) {
                System.out.println("You lost! The word was: " + wordToGuess);
            }
        }
    }
}
