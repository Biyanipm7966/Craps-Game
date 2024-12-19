import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int sum = rollDice(random);
            int point = 0;
            System.out.println("Rolling dice...");
            System.out.println("Die 1: " + (sum - random.nextInt(6)));
            System.out.println("Die 2: " + (sum - (sum - 1 - random.nextInt(6))));
            System.out.println("Total: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
                playAgain = askToPlayAgain(scanner);
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
                playAgain = askToPlayAgain(scanner);
            } else {
                point = sum;
                System.out.println("The point is " + point);

                do {
                    sum = rollDice(random);
                    System.out.println("Rolling dice...");
                    System.out.println("Die 1: " + (sum - random.nextInt(6)));
                    System.out.println("Die 2: " + (sum - (sum - 1 - random.nextInt(6))));
                    System.out.println("Total: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        playAgain = askToPlayAgain(scanner);
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost!");
                        playAgain = askToPlayAgain(scanner);
                    } else {
                        System.out.println("Trying for point...");
                    }
                } while (sum != point && sum != 7);
            }
        }

        System.out.println("Thanks for playing Craps!");
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Do you want to play again? (y/n)");
        String answer = scanner.nextLine();
        return answer.equalsIgnoreCase("y");
    }
}
