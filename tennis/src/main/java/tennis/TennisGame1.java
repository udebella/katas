package tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName)) {
            player1.incrementScore();
        } else {
            player2.incrementScore();
        }
    }

    public String getScore() {
        String score;

        score = formatScore(player1.getScore());
        score += "-";
        if (player1.getScore() == player2.getScore()) {
            score += "All";

            if(player1.getScore() > 2) {
                score = "Deuce";
            }
        } else {
            score += formatScore(player2.getScore());

            if (player1.getScore() >= 4 || player2.getScore() >= 4) {
                int minusResult = player1.getScore() - player2.getScore();
                if (Math.abs(minusResult) == 1) {
                    score = "Advantage ";
                } else {
                    score = "Win for ";
                }
                if (minusResult > 0) {
                    score += player1.getName();
                } else {
                    score += player2.getName();
                }
            }
        }
        return score;
    }

    private String formatScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return null;
    }
}
