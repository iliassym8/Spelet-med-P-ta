public class GameManager {
    private static int highScorePlayer1;
    private static int highScorePlayer2;        
    private static int RoundsPlayed;

    private static Player player1;
    private static Player player2;

    private static Player currentPlayer;

    public GameManager() {
        highScorePlayer1 = 0;
        highScorePlayer2 = 0;
        RoundsPlayed = 0;
    }

    public static int getHighScorePlayer1() {
        return highScorePlayer1;
    }

    public static void setHighScorePlayer1(int highScorePlayer1) {
        GameManager.highScorePlayer1 = highScorePlayer1;
    }

    public static int getHighScorePlayer2() {
        return highScorePlayer2;
    }

    public static void setHighScorePlayer2(int highScorePlayer2) {
        GameManager.highScorePlayer2 = highScorePlayer2 ;
    }

    public static int getRoundsPlayed() {
        return RoundsPlayed;
    }
    public static void setRoundsPlayed(int roundsPlayed) {
        GameManager.RoundsPlayed = roundsPlayed;
    }
    public void setUpGame() {

        setHighScorePlayer1(0);
        setHighScorePlayer2(0);
        setRoundsPlayed(new java.util.Random().nextInt(2) + 1);

        player1 = new Player(10,"Pöta");
        player1.actions.add(new ActionKick());
        player1.actions.add(new ActionPunch());
        player1.actions.add(new ActionSpit());
        player1.actions.add(new ActionHeal());
        player2 = new Player(10,"Ilias");
        player2.actions.add(new ActionKick());
        player2.actions.add(new ActionPunch());
        player2.actions.add(new ActionSpit());
        player2.actions.add(new ActionHeal());
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static void setCurrentPlayer(Player player) {
        GameManager.currentPlayer = player;
    }
}
