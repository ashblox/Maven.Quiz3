package rocks.zipcode.io.quiz3.objectorientation.enums;

/**
 * @author leon on 09/12/2018.
 */
public enum RockPaperScissorHandSign {
    ROCK, PAPER, SCISSOR;

    public RockPaperScissorHandSign getWinner() {
        RockPaperScissorHandSign winner = null;
        switch (this) {
            case ROCK:
                winner = PAPER;
                break;
            case PAPER:
                winner = SCISSOR;
                break;
            case SCISSOR:
                winner = ROCK;
                break;
        }
        return winner;
    }

    public RockPaperScissorHandSign getLoser() {
        RockPaperScissorHandSign loser = null;
        switch (this) {
            case ROCK:
                loser = SCISSOR;
                break;
            case PAPER:
                loser = ROCK;
                break;
            case SCISSOR:
                loser = PAPER;
                break;
        }
        return loser;
    }
}
