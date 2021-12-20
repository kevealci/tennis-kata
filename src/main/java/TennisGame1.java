
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score;
        if (isScoreEqual())
            score = equalScoreString();
        else if (isScoreGreaterThan4())
            score = scoreGreaterThan4();
        else
            score = differentScore(scorePlayer1).concat("-").concat(differentScore(scorePlayer2));

        return score;
        }

    private boolean isScoreGreaterThan4() {
        return scorePlayer1 >=4 || scorePlayer2 >=4;
    }

    private boolean isScoreEqual() {
        return scorePlayer1 == scorePlayer2;
    }

    private String differentScore(int scorePlayer) {
        switch(scorePlayer)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }


    private String scoreGreaterThan4() {
        int minusResult = scorePlayer1 - scorePlayer2;
        switch(minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
        }
    }

    private String advantageScore(int minusResult){
        return minusResult ==1 ? "Advantage ".concat(player1Name) : "Advantage ".concat(player2Name);
    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for ".concat(player1Name): "Win for ".concat(player2Name);
    }

    private String equalScoreString() {
        switch (scorePlayer1)
        {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }
}
