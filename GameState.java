public class GameState {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.setUpGame();

        Combat combat = new Combat();

        System.out.println("Welcome to the game!");
        System.out.println(gameManager.getPlayer1().getName());
        System.out.println(gameManager.getPlayer2().getName());
        System.out.println(gameManager.getPlayer1().getLife());
        System.out.println(gameManager.getPlayer2().getLife());

        combat.startCombat(gameManager.getPlayer1(), gameManager.getPlayer2());

        System.out.println(gameManager.getPlayer1().getLife());
        System.out.println(gameManager.getPlayer2().getLife());
    }
}
