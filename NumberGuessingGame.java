package codesoft;


    import java.util.Random;
import java.util.Scanner;

    public class NumberGuessingGame {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int min = 1;
            int max = 100;
            int rounds = 0;
            int totalScore = 0;

            System.out.println("This is your favourite number guessing game");


            boolean playAgain = true;
            while (playAgain) {
                rounds++;
                int randomNumber = random.nextInt(max - min + 1) + min;
                int attempts = 0;
                int maxAttempts = 7;
                boolean hasWon = false;

                System.out.println("\nRound " + rounds + ":");
                System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
                System.out.println("You have " + maxAttempts + " attempts to guess it!");


                while (attempts < maxAttempts && !hasWon) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == randomNumber) {
                        System.out.println("wow! You have enter the correct number!");
                        hasWon = true;
                        totalScore += (maxAttempts - attempts + 1); // Score based on attempts
                    } else if (guess > randomNumber) {
                        System.out.println("No this is so far .. think smaller");
                    } else {
                        System.out.println("No this is so far .. think larger");
                    }

                    if (!hasWon && attempts == maxAttempts) {
                        System.out.println("Now you don't have any another chance. The correct number was " + randomNumber);
                    }
                }


                System.out.print("Do you want to play another round? (yes/no): ");
                String response = scanner.next().toLowerCase();
                playAgain = response.equals("yes");
            }


            System.out.println("\nGame Over! You played " + rounds + " rounds.");
            System.out.println("Your total score is: " + totalScore);
            scanner.close();
        }
    }


