package tictactoeclient;

import java.util.Random;

public class EasyAIHandler {

    private final String[] board;

    private boolean isEndOfGame = false;
    private int rounds;


    public EasyAIHandler() {
        rounds = 0;
        board = new String[]{"N", "N", "N", "N", "N", "N", "N", "N", "N"};

    }


    public String getBoard(int loc) {
        return board[loc];
    }

    public String getTurn() {
        return "X";
    }

    public boolean isEndOfGame() {
        return !isEndOfGame;
    }



    public void setBoard(String turn, int loc) {

        if (board[loc].equals("N")) {
            board[loc] = turn;
            rounds++;
        }

    }

    public int setPCMove(){
        int cpuMove = -1;
        if (!isEndOfGame)
        {   Random rand = new Random();
            int loc;

            do {
                loc = rand.nextInt(9);
                System.out.println("the random number = " + loc);
            }while (isPlayable(board) &&!board[loc].equals("N"));

            cpuMove = loc;
        }
        return cpuMove;
    }

    public String winnerName() {
        String winnerName = checkWinner();
        switch (winnerName) {
            case "X":
                winnerName = "You Win! :D";

                break;

            case "O":
                winnerName = "You Lose :(";

                break;

            case "D":
                winnerName = "DRAW!";

                break;
        }
        return winnerName;
    }

    public String checkWinner() {
        String line = "N";

        for (int a = 0; a < 8; a++) {
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
            //For X winner
            if (line.equals("XXX")) {
                line = "X";
                //System.out.println("Winner is " + line);
                isEndOfGame = true;
                break;
            }

            // For O winner
            else if (line.equals("OOO")) {
                line = "O";
                //System.out.println("Winner is " + line);
                isEndOfGame = true;
                break;

            } else if (rounds == 9 && a ==7){
                line = "D";
                //System.out.println("no Winner " + line);
                isEndOfGame = true;
                break;
            } else {
                line = "N";

            }

        }

        return line;
    }
    public boolean isPlayable(String[] arr){
        boolean playable = true;
        for (String s : arr) {
            if (s.equals("N")) {
                playable = true;
                break;
            } else {
                playable = false;
            }
        }
        return playable;
    }

}
