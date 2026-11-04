
import java.util.Scanner;

public class GameState {

    public static void main(String[] args) {

        Music.playMusic();

        GameManager gameManager = new GameManager();
        gameManager.setUpGame();

        Combat combat = new Combat();
        showFightScreen();
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

    public static void showFightScreen() {
        String reset = "\u001B[0m";
        String gold = "\u001B[93m";
        String red = "\u001B[91m";
        String cyan = "\u001B[96m";

        System.out.println(gold + """
         ███████╗██╗ ██████╗ ██╗  ██╗████████╗██╗
         ██╔════╝██║██╔════╝ ██║  ██║╚══██╔══╝██║
         █████╗  ██║██║  ███╗███████║   ██║   ██║
         ██╔══╝  ██║██║   ██║██╔══██║   ██║   ╚═╝
         ██║     ██║╚██████╔╝██║  ██║   ██║   ██╗
         ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝
        """ + reset);

        // Each letter becomes a colored pixel.
        String[] fighters = {
            "     HHHH                  HHHH     ",
            "    HHHHHH                HHHHHH    ",
            "    HSSSSS                SSSSSH    ",
            "    SSXSSS                SSSXSS    ",
            "     SSSSS                SSSSS     ",
            "      SS                    SS      ",
            "    SSSSSS  RR          BB  SSSSSS   ",
            "   SSSSSSS RRRR        BBBB SSSSSSS  ",
            "  SSSSSSSSSRRRR        BBBBSSSSSSSS  ",
            "  SSRSSSSSS RR          BB SSSSSBSS  ",
            "  RRRRSSSSS                SSSSBBBB  ",
            "  RRRRSSSSS                SSSSBBBB  ",
            "   RR SSSSS                SSSSS BB ",
            "     WWWWWW                WWWWWW   ",
            "     RRRRRR                BBBBBB   ",
            "     RRRRRRR              BBBBBBB   ",
            "     RRR RRR              BBB BBB   ",
            "     SSS  SSS            SSS  SSS   ",
            "     SSS   SS            SS   SSS   ",
            "     SS    SSS          SSS    SS   ",
            "    KKK    KKK          KKK    KKK  ",
            "   KKKK    KKKK        KKKK    KKKK "
        };

        for (String row : fighters) {
            System.out.print("  ");
            for (char pixel : row.toCharArray()) {
                String color = switch (pixel) {
                    case 'H' ->
                        "\u001B[38;5;94m";  // Hair
                    case 'S' ->
                        "\u001B[38;5;216m"; // Skin
                    case 'X' ->
                        "\u001B[38;5;232m"; // Eyes
                    case 'R' ->
                        "\u001B[38;5;196m"; // Red gloves / shorts
                    case 'B' ->
                        "\u001B[38;5;33m";  // Blue gloves / shorts
                    case 'W' ->
                        "\u001B[38;5;255m"; // Waistband
                    case 'K' ->
                        "\u001B[38;5;240m"; // Boots
                    default ->
                        "";
                };

                System.out.print(pixel == ' '
                        ? "  "
                        : color + "██" + reset);
            }
            System.out.println();
        }

        System.out.println(
                "\u001B[90m" + "═".repeat(76) + reset
        );
        System.out.println(
                "          " + red + GameManager.getPlayer1().getName()
                + gold + "              VS              "
                + cyan + GameManager.getPlayer2().getName() + reset
        );
        System.out.println(
                "\n" + gold + "                         ★  ROUND 1  ★" + reset
        );
    }

}
