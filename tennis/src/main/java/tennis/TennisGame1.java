package tennis;

import static tennis.Player.endGameMessage;

public class TennisGame1 implements TennisGame {

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
        String score;

        score = player1.formatScore();
        score += "-";
        if (player1.hasSameScore(player2)) {
            score += "All";

            if(player1.hasMore(2)) {
                score = "Deuce";
            }
        } else {
            score += player2.formatScore();

            if (player1.hasMore(3) || player2.hasMore(3)) {
                score = endGameMessage(player1, player2);
            }
        }
        return score;
    }

}
