package tennis.game2;

import tennis.TennisGame;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point==0) {
            P1res = "Love";
        }
        if (P1point==1) {
            P1res = "Fifteen";
        }
        if (P1point==2) {
            P1res = "Thirty";
        }
        if (P1point==3) {
            P1res = "Forty";
        }
        if (P2point==0) {
            P2res = "Love";
        }
        if (P2point==1) {
            P2res = "Fifteen";
        }
        if (P2point==2) {
            P2res = "Thirty";
        }
        if (P2point==3) {
            P2res = "Forty";
        }

        if (P1point>P2point && P1point < 4)
        {
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            score = P1res + "-" + P2res;
        }
        if (P1point == P2point && P1point < 4)
        {
            score = P1res + "-All";
        }
        if (P1point==P2point && P1point>=3)
            score = "Deuce";
        
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (P1point>=4 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public void incrementFirstPlayerScore(){
        P1point++;
    }
    
    public void incrementSecondPlayerScore(){
        P2point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player))
            incrementFirstPlayerScore();
        else
            incrementSecondPlayerScore();
    }
}