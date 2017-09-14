package tennis;

public class Player {

    private int score;
    private String name;

    public Player(String name) {
        this.score = 0;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
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
}
