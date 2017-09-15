package tennis.game2;

import tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    private static final String SCORE_SEPARATOR = "-";
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isEquality()) {
            return formatEqualityScore();
        }
        if (isAdvantage()) {
            return "Advantage " + winner();
        }
        if (isWin()) {
            return "Win for " + winner();
        }
        return printScore(pointToScoreName(P2point));
    }

    private String formatEqualityScore() {
        if (P1point < 3) {
            return printScore("All");
        }
        return "Deuce";
    }

    private boolean isAdvantage() {
        return P1point >= 3 && P2point >= 3 && differenceOfOnePoint();
    }

    private boolean differenceOfOnePoint() {
        return Math.abs(P1point - P2point) == 1;
    }

    private String printScore(String secondPart) {
        return pointToScoreName(P1point) + SCORE_SEPARATOR + secondPart;
    }

    private boolean isEquality() {
        return P1point == P2point;
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
        return isPotentialWin() && atLeastDifferenceOfTwo();
    }

    private boolean isPotentialWin() {
        return P1point > 3 || P2point > 3;
    }

    private boolean atLeastDifferenceOfTwo() {
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