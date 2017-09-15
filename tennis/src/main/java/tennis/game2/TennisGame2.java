package tennis.game2;

import tennis.TennisGame;

public class TennisGame2 implements TennisGame {
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
        if (P1point < 4 || P2point < 4) {
            score = formatEarlyGameScore();
        }
        if (P1point >= 3 && P2point >= 3) {
            score = "Advantage " + winner();
            if (P1point == P2point) {
                score = "Deuce";
            }
        }
        if (P1point >= 4 || P2point >= 4) {
            if (Math.abs(P1point - P2point) >= 2) {
                score = "Win for " + winner();
            }
        }
        return score;
    }

    private String formatEarlyGameScore() {
        String score;
        String p1res = pointToScoreName(P1point);
        String p2res = pointToScoreName(P2point);
        score = p1res + "-" + p2res;
        if (P1point == P2point) {
            score = p1res + "-All";
        }
        return score;
    }

    private String winner() {
        if (P1point > P2point) {
            return player1Name;
        }
        return player2Name;
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

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1point++;
        } else {
            P2point++;
        }
    }
}