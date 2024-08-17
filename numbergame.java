import java.util.Scanner;
import java.util.Random;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain;

        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess a number between " + min + " and " + max + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Guess Number: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}

