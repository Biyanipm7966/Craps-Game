import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        while (playAgain) {
            int sum = rollDice(random);
            System.out.println("You rolled " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
                playAgain = askToPlayAgain(scanner);
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
                playAgain = askToPlayAgain(scanner);
            } else {
                int point = sum;
                System.out.println("The point is " + point);
                
                do {
                    sum = rollDice(random);
                    System.out.println("You rolled " + sum);
                } while (sum != point && sum != 7);

                if (sum == 7) {
                    System.out.println("You rolled 7. You lose.");
                } else {
                    System.out.println("You rolled the point. You win.");
                }
                
                playAgain = askToPlayAgain(scanner);
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
