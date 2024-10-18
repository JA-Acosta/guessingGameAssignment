/* Programmer: JAAR
*  Assignment Chapter: 5 question 18
*   Date modified: 10/17/2024
*   IDE/Tool used: IntelliJ
*/

// Creates an instance of a guessing game where a random number is generated
// and the user has to try to guess it.

/*
* Random Number Guessing Game Enhancement
 Enhance the program that you wrote for Programming Challenge 17 so that it
 * keeps a count of the number of guesses that the user makes. When the user
 * correctly guesses the random number, the program should display the number
 *  of guesses.
* */

import java.util.Scanner;

public class Main {
    private static final int RANGE = 100;
    private static final int GUESSES_ALLOWED = 3;
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame(RANGE, GUESSES_ALLOWED);
        Scanner input = new Scanner(System.in);
        intro();
        System.out.print("Enter your 1st guess: "); // fencepost
        game.nextGuess(getInput(input));
        while (game.remainingGuesses() != 0 &&
                !game.checkGuess()) {
            if (game.getHint() < 0) {
                System.out.println("Guess higher!");
            } else if (0 < game.getHint()) {
                System.out.println("Guess lower!");
            }
            System.out.print("Enter your next guess: ");
            game.nextGuess(getInput(input));
        }
        System.out.println();
        outro(game);
    }

    // Generates the introduction prompt for the program.
    public static void intro(){
        System.out.println("Lets play a guessing game!");
        System.out.println("I'm thinking of a number...");
        try { // has a slight delay.
            Thread.sleep(2500);
            System.out.println("I got it!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Asks the user for an input until they enter a positive integer.
    // Return:
    //  - int input: the integer the user entered.
    public  static int getInput(Scanner input) {
        int guess;
        do {
            try {
                guess = Integer.parseInt(input.nextLine());
                if (guess < 1 || RANGE < guess) {
                    throw new NumberFormatException("Enter a positive number!");
                }
                return guess;
            } catch (NumberFormatException e) {
                System.out.println("Your Input was invalid!");
                System.out.print("Enter another response: ");
            }
        } while (true);
    }

    // Checks how the game ended and gives a prompt based on it.
    // GuessingGame game: Contains the information used to validate how the
    // game ended.
    public static void outro(GuessingGame game) {
        if (game.checkGuess()) {
            System.out.printf("The answer was %d",
                    game.getCurrentGuess());
            System.out.println();
            System.out.println();
        }
        if (game.remainingGuesses() == GUESSES_ALLOWED - 1) {
            System.out.println("You got it on your first try!");
            System.out.println("Way to go!");
        } else if (game.remainingGuesses() != 0) {
            System.out.printf("You got it in %d guesses.",
                    GUESSES_ALLOWED - game.remainingGuesses());
            System.out.println();
        } else {
            System.out.println("Thank you for playing. You'll get it next " +
                    "time");
        }
    }
}