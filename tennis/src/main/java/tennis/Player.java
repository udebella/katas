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

    public boolean hasSameScore(Player player) {
        return score == player.score;
    }

    public boolean hasMore(int score) {
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
        String score;
        int minusResult = player1.score - player2.score;
        if (Math.abs(minusResult) == 1) {
            score = maxScore(player1, player2).advantage();
        } else {
            score = maxScore(player1, player2).win();
        }
        return score;
    }

    private String advantage() {
        return "Advantage " + name;
    }

    private String win() {
        return "Win for " + name;
    }

    private static Player maxScore(Player player1, Player player2) {
        if (player1.score - player2.score > 0) {
            return player1;
        } else {
            return player2;
        }
    }
}
