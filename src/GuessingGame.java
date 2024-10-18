
// Create a class for guessing games
// Keeps track of the total guesses allowed.
// Keeps track of the number of guesses that the user made.
// Holds the answer for the guessing game.

import java.util.Random;

public class GuessingGame {
    private int answer; // Don't allow the user to see the answer ever.
    private int guessesAllowed; // Don't let the user set the guesses ever.
    private int guessCount; // Update from within the nextGuess.
    private int currentGuess;

    // Constructor:

    // Creates a guessing game with a specific range and guesses entered by
    // the game creator.
    // Param:
    //  - int range: the range from which the random number can be selected.
    //  - int guessesAllowed: how many guesses the player will have to get
    //  the right answer.
    GuessingGame(int range, int guessesAllowed) {
        Random answerGenerator = new Random();
        answer = answerGenerator.nextInt(range) + 1;
        this.guessesAllowed = guessesAllowed;
        guessCount = 0;
    }

    // Getters:

    public int remainingGuesses() {
        return guessesAllowed - guessCount;
    }

    public int getCurrentGuess() {
        return currentGuess;
    }

    // Gets the users next guess and updates the guess counter.
    // Param:
    //  - int currentGuess: the users next guess.
    public void nextGuess(int currentGuess) {
        guessCount++;
        this.currentGuess = currentGuess;
    }

    // Checks if the users current guess is the answer and if so, returns
    // true otherwise, returns false.
    public boolean checkGuess() {
        return (currentGuess == answer);
    }

    // Gives the player a hint. A positive number means they need to guess
    // higher. A negative number means they need to guess lower. A zero means
    // they guessed right.
    // Return:
    //  - int hint: the users hint for their next guess.
    public int getHint() {
        int hint = 0;
        if (currentGuess < answer) {
            hint = -1;
        } else if (answer < currentGuess) {
            hint = 1;
        }
        return hint;
    }
}
