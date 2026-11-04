public class GameManager {
    private static int highScore;
    private static int RoundsPlayed;

    private static Player player1;
    private static Player player2;

    public GameManager() {
        highScore = 0;
        RoundsPlayed = 0;
    }

    public int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        GameManager.highScore = highScore;
    }

    public static int getRoundsPlayed() {
        return RoundsPlayed;
    }

    public static void setRoundsPlayed(int roundsPlayed) {
        GameManager.RoundsPlayed = roundsPlayed;
    }
    public void setUpGame() {

        setHighScore(0);
        setRoundsPlayed(1);

        player1 = new Player(10,"Pöta");
        player1.actions.add(new ActionKick());
        player2 = new Player(10,"Ilias");
        player2.actions.add(new ActionKick());
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }
}
