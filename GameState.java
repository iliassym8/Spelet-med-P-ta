
import java.util.Scanner;

public class GameState {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.setUpGame();

        Combat combat = new Combat();

        combat.startCombat(gameManager.getPlayer1(), gameManager.getPlayer2());

        System.out.println("Want to play again!? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("yes")) {
            gameManager.setUpGame();
            combat.startCombat(gameManager.getPlayer1(), gameManager.getPlayer2());
        } else {
            System.out.println("Thanks for playing!");
        }

    }
}
