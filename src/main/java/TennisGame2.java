
public class TennisGame2 implements TennisGame
{
    private int p1Point = 0;
    private int p2Point = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score;
        if (isScoreEqual())
            score = equalScore();

        else if (isScoreGreaterThan4())
            score = scoreGreaterThan4();

        else
            score = differentScore(p1Point).concat("-").concat(differentScore(p2Point));

        return score;
    }

    private boolean isScoreGreaterThan4() {
        return p1Point >= 4 || p2Point >=4;
    }

    private boolean isScoreEqual() {
        return p1Point == p2Point;
    }

    private String equalScore() {
        switch(p1Point){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String scoreGreaterThan4() {
        int minusResult = p1Point - p2Point;
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

    private String differentScore(int scorePlayer) {
        switch(scorePlayer)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }

    public void wonPoint(String player) {
        if (player.equals(this.player1Name))
            p1Point++;
        else
            p2Point++;
    }
}