package tennis;

import static tennis.Player.endGameMessage;

public class TennisGame1 implements TennisGame {

    private static final String SCORE_SEPARATOR = "-";
    private static final int END_GAME_LIMIT_SCORE = 3;
    private static final int DEUCE_LIMIT_SCORE = 2;

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.hasName(playerName)) {
            player1.incrementScore();
        } else {
            player2.incrementScore();
        }
    }

    public String getScore() {
        if (player1.hasSameScore(player2)) {
            return formatEqualityScore();
        } else {
            return formatDistinctScore();
        }
    }

    private String formatEqualityScore() {
        String score = formatScore(player1.formatScore(), "All");

        if(player1.hasMore(DEUCE_LIMIT_SCORE)) {
            score = "Deuce";
        }
        return score;
    }

    private String formatDistinctScore() {
        String score = formatScore(player1.formatScore(), player2.formatScore());

        if (player1.hasMore(END_GAME_LIMIT_SCORE) || player2.hasMore(END_GAME_LIMIT_SCORE)) {
            score = endGameMessage(player1, player2);
        }
        return score;
    }

    private String formatScore(String scorePlayer1, String scorePlayer2) {
        return scorePlayer1 + SCORE_SEPARATOR + scorePlayer2;
    }

}
