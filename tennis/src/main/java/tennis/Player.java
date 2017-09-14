package tennis;

public class Player {

    private int score;
    private String name;

    public Player(String name) {
        this.score = 0;
        this.name = name;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public void incrementScore() {
        this.score++;
    }

    public boolean hasSameScoreThan(Player player) {
        return score == player.score;
    }

    public boolean isScoreHigherThan(int score) {
        return this.score > score;
    }

    public String formatScore() {
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

    public static String endGameMessage(Player player1, Player player2) {
        final Player winner = maxScore(player1, player2);
        if (scoreGapLessThanTwo(player1, player2)) {
            return "Advantage " + winner.name;
        } else {
            return "Win for " + winner.name;
        }
    }

    private static boolean scoreGapLessThanTwo(Player player1, Player player2) {
        int scoreGap = player1.score - player2.score;
        return Math.abs(scoreGap) < 2;
    }

    private static Player maxScore(Player player1, Player player2) {
        if (player1.isScoreHigherThan(player2.score)) {
            return player1;
        } else {
            return player2;
        }
    }
}
