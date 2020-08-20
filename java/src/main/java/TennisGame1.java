
public class TennisGame1 implements TennisGame {

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1)) {
            scorePlayer1 += 1;
            return;
        }
        scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore;
        if (scorePlayer1 == scorePlayer2) {
            score = switch (scorePlayer1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
            return score;
        }
        if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            int minusResult = scorePlayer1 - scorePlayer2;
            if (minusResult == 1) {
                score = "Advantage " + PLAYER_1;
            } else if (minusResult == -1) {
                score = "Advantage " + PLAYER_2;
            } else if (minusResult >= 2) {
                score = "Win for " + PLAYER_1;
            } else {
                score = "Win for " + PLAYER_2;
            }
            return score;
        }
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scorePlayer1;
            } else {
                score += "-";
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case 0 -> score += "Love";
                case 1 -> score += "Fifteen";
                case 2 -> score += "Thirty";
                case 3 -> score += "Forty";
            }
        }
        return score;
    }
}
