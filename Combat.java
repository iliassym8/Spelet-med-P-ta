
import java.util.Random;
import java.util.Scanner;

public class Combat {

    Scanner scanner = new Scanner(System.in);

    public void startCombat(Player player1, Player player2) {

        while (player1.getLife() > 0 && player2.getLife() > 0) {
            if (GameManager.getRoundsPlayed() % 2 == 0) {

                GameManager.setCurrentPlayer(player1);

                performAction(player1, player2);
            } else {
                GameManager.setCurrentPlayer(player2);
                
                performAction(player2, player1);
            }
            if (player1.getLife() <= 0) {
                System.out.println(player2.getName() + " wins!");
                break;
            } else if (player2.getLife() <= 0) {
                System.out.println(player1.getName() + " wins!");
                break;
            }
        }
    }

    ;
public void performAction(Player attacker, Player defender) {
        System.out.println(attacker.getName() + "'s turn. Choose an action:");

        for (int i = 0; i < attacker.actions.size(); i++) {
            System.out.println((i + 1) + ". " + attacker.actions.get(i).getName());
        }

        int choice = scanner.nextInt();
        int randomNumber = new Random().nextInt(10) + 1;

        if (choice < 1 || choice > attacker.actions.size()) {
            System.out.println("Invalid action. Turn skipped.");
        } else if (randomNumber == 1) {
            System.out.println("You missed! Turn skipped.");
        } else {
            attacker.actions.get(choice - 1).effect(defender);
        }

        // Advance the turn whether the attack hits, misses, or is invalid.
        GameManager.setRoundsPlayed(GameManager.getRoundsPlayed() + 1);
    }
}
