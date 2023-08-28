import java.util.Random;
import java.util.Scanner;

public class task1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess what it is?");

            while (!guessedCorrectly && attempts < 5) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainInput = scanner.next();

            if (playAgainInput.equalsIgnoreCase("n")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your score is " + score + ".");
        scanner.close();
    }
}