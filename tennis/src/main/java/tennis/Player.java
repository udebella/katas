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
}
