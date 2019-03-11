package rocks.zipcode.io.quiz3.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon on 09/12/2018.
 */
public class TicTacToe {

    private String[][] board;

    public TicTacToe(String[][] board) {
        this.board = board;
    }

    public TicTacToe() {
    }

    public String[] getRow(Integer value) {
        return board[value];
    }

    public String[] getColumn(Integer value) {
        String[] column = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][value];
        }
        return column;
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        String[] row = getRow(rowIndex);
        return isArrayHomogenous(row);
    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        String[] column = getColumn(columnIndex);
        return isArrayHomogenous(column);
    }

    public Boolean isDiagonalOneHomogenous() {
        String[] diag1 = {board[0][0], board[1][1], board[2][2]};
        return isArrayHomogenous(diag1);
    }

    public Boolean isDiagonalTwoHomogenous() {
        String[] diag2 = {board[0][2], board[1][1], board[2][0]};
        return isArrayHomogenous(diag2);
    }

    public Boolean isArrayHomogenous(String[] array) {
        boolean isHomogenous = true;
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i-1])) {
                isHomogenous = false;
            }
        }
        return isHomogenous;
    }

    public boolean isAnyRowAWinner() {
        boolean isAnyRowAWinner = false;
        for (int i = 0; i < board.length; i++) {
            if (isRowHomogenous(i)) {
                isAnyRowAWinner = true;
            }
        }
        return isAnyRowAWinner;
    }

    public Boolean isAnyColumnAWinner() {
        boolean isAnyColumnAWinner = false;
        for (int i = 0; i < board.length; i++) {
            if (isColumnHomogeneous(i)) {
                isAnyColumnAWinner = true;
            }
        }
        return isAnyColumnAWinner;
    }

    public Boolean isAnyDiagonalAWinner() {
        return isDiagonalOneHomogenous() || isDiagonalTwoHomogenous();
    }

    public String getWinner() {
        String winner = "";
        for (int i = 0; i < board.length; i++) {
            if (isRowHomogenous(i)) {
                winner = board[i][0];
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (isColumnHomogeneous(i)) {
                winner = board[0][i];
            }
        }
        if (isDiagonalOneHomogenous()) {
            winner = board[0][0];
        }
        if (isDiagonalTwoHomogenous()) {
            winner = board[0][2];
        }
        return winner;
    }

    public String[][] getBoard() {
        return board;
    }
}
