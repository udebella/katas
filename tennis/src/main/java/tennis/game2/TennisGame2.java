package tennis.game2;

import tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public static final String SCORE_SEPARATOR = "-";
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        final String firstPlayerScore = pointToScoreName(P1point);
        if (P1point < 4 || P2point < 4) {
            score = firstPlayerScore + SCORE_SEPARATOR;
            score += pointToScoreName(P2point);
        }
        if (P1point >= 3 && P2point >= 3) {
            score = "Advantage " + winner();
        }
        if (isWin()) {
            score = "Win for " + winner();
        }
        if (P1point == P2point) {
            score = "Deuce";
            if (P1point < 3) {
                score = firstPlayerScore + SCORE_SEPARATOR + "All";
            }
        }
        return score;
    }

    private String pointToScoreName(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String winner() {
        if (P1point > P2point) {
            return player1Name;
        }
        return player2Name;
    }

    private boolean isWin() {
        return isPotentialWin() && atLeastTwoPointDifference();
    }

    private boolean isPotentialWin() {
        return P1point > 3 || P2point > 3;
    }

    private boolean atLeastTwoPointDifference() {
        return Math.abs(P1point - P2point) >= 2;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1point++;
        } else {
            P2point++;
        }
    }
}