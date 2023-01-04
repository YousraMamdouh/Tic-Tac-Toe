package tictactoeclient;

import java.util.Objects;

public class MultiplayerGame {
    private final String playerOne;
    private final String playerTwo;
    private final String[] board;
    private int round;
    private boolean isP1Turn;

    public MultiplayerGame() {
        playerOne = "Player A";
        playerTwo = "Player B";
        board = new String[]{"n", "n", "n",
                             "n", "n", "n",
                             "n", "n", "n"};
        round = 0;
        isP1Turn = true;
    }


    private boolean playerOneMove(int cell) {
        boolean ret = false;
        if (Objects.equals(board[cell], "n")) {
            board[cell] = "x";
            ret = true;
            round++;
            System.out.println("Player One played 'X' in cell " + cell + " round " + round);
        }
        return ret;
    }

    private boolean playerTwoMove(int cell) {
        boolean ret = false;
        if (Objects.equals(board[cell], "n")) {
            board[cell] = "o";
            ret = true;
            round++;
            System.out.println("Player Two played 'O' in cell " + cell + " Round " + round);
        }
        return ret;
    }

    public boolean setPlay(int cell) {
        boolean ret;
        if (isP1Turn) {
            ret = playerOneMove(cell);
        } else {
            ret = playerTwoMove(cell);
        }
        isP1Turn = !isP1Turn;
        return ret;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String gameState() {
        String line = "n";
        for (int a = 0; a < 8; a++) {
            line = "n";
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("xxx")) {
                line = playerOne;
                //System.out.println("Player 1 Wins!");
                break;
            } else if (line.equals("ooo")) {
                line = playerTwo;
                //System.out.println("Player 2 wins!");
                break;
            } else if (round == 9 && a==7) {
                line = "No One";
                break;
            } else {
                line = "n";
            }
        }

        return line;
    }

}
