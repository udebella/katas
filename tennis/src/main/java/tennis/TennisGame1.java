package tennis;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;

        score = formatScore(m_score1);
        score += "-";
        if (m_score1 == m_score2) {
            score += "All";
        } else {
            score += formatScore(m_score2);
        }
        if (m_score1 == m_score2 && m_score1 > 2) {
            score = "Deuce";
        }
        if (m_score1 != m_score2) {
            if (m_score1 >= 4 || m_score2 >= 4) {
                int minusResult = m_score1 - m_score2;
                if (minusResult == 1) score = "Advantage player1";
                else if (minusResult == -1) score = "Advantage player2";
                else if (minusResult >= 2) score = "Win for player1";
                else score = "Win for player2";
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
