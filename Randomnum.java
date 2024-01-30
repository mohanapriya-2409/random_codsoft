import java.util.Random;
import java.util.Scanner;

public class Randomnum {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc= new Scanner(System.in);

        // Game settings
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 3;
        int score = 0;
        int roundsPlayed = 0;
        String ans;


        do {
            
            roundsPlayed++;
            // Generate random number
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;

            // Game loop with attempt limit
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.println("Guess the number between " + minNumber + " and " + maxNumber + ": ");
                int guess = sc.nextInt();

                // Compare guess and provide feedback
                if (guess == randomNumber) {
                    System.out.println("You guessed it! Congratulations!");
                    score += maxAttempts - attempt + 1; // Bonus points for fewer attempts
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                // Check if guess attempts are exhausted
                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you ran out of guesses. The number was " + randomNumber + ".");
                }
            }

            // Ask for another round
            System.out.println("Play again? (y/n)");
            ans  = sc.next();

        } while (ans.equalsIgnoreCase("y"));

        // Display overall results
        System.out.println("Game Summary:");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Total Score: " + score);
        sc.close();
        System.out.println("Thanks for playing");
    }
}


