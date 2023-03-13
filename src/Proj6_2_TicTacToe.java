import java.util.Scanner;

public class Proj6_2_TicTacToe {
    public static void main(String[] args) {
        String[][] gameBoard = new String[3][3]; // 3 x 3 2d array
        populateGameBoard(gameBoard);
        int turnCount = 0;
        int[] winState = new int[1];
        if(turnCount > 9) { // why do a method when you can do a relationship?
            System.out.println("Board is full");
        }
        else {
            gameLoop(gameBoard, turnCount, winState);
        }
    }

    public static void gameLoop(String[][] gameBoard, int turnCount, int[] winState) {
        /*
        * winState is what determines the loop.
        * turnCount, gameBoard, and winState are called from the nested methods
        * Had some struggle getting this thing to shut down. Fixed it by using an array?
        * Still don't know why that works honestly.
        */
        while (winState[0] == 0) {
            printGameBoard(gameBoard);
            getUserInput(gameBoard, turnCount, winState);
        }


    }

    private static String checkWinConditions(String[][] gameBoard) {
        /*
        * this is based off some other file online, modified for the 2d array.
        */
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                // Horizontal
                case 0 -> gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2];
                case 1 -> gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2];
                case 2 -> gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2];
                // Vertical
                case 3 -> gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
                case 4 -> gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
                case 5 -> gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
                // Diagonal
                case 6 -> gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2];
                case 7 -> gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0];
                default -> null;
            };
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "0";

            }

        }
        return "-"; // still don't get how this doesn't override the other returns. Are returns FCFS?
    }

    public static void populateGameBoard(String[][] twoDArr) {
        /*
        * Runs through every element in the 2d array
        * Starts at first row, moves through columns, moves to next row, repeat.
        */

        for (int i = 0; i < twoDArr.length; i++) {
            for (int j = 0; j < twoDArr[i].length; j++) {
                twoDArr[i][j] = "-";
            }
        }
    }

    public static void printGameBoard(String[][] twoDArr) {
        for (String[] arr : twoDArr) {
            for (String string : arr) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void getUserInput(String[][] gameBoard, int turnCount, int[] winState) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter next move");
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        if (isSpaceOccupied(row, col, gameBoard)) { // isSpaceOccupied returns true
            System.out.println("Space occupied!");
            getUserInput(gameBoard, turnCount, winState);

        } else if (!isSpaceOccupied(row, col, gameBoard)) { // isSpaceOccupied returns false
            if (turnCount % 2 == 0) { // X
                gameBoard[row][col] = "X";
                if (checkWinConditions(gameBoard).equals("X")) {
                    System.out.println("X wins");
                    winState[0] = 1;
                } else if (checkWinConditions(gameBoard).equals("O")) {
                    System.out.println("O wins");
                    winState[0] = 1;

                } else {
                    turnCount++;
                    gameLoop(gameBoard, turnCount, winState);

                }
            } else { // O
                gameBoard[row][col] = "O";
                if (checkWinConditions(gameBoard).equals("X")) {
                    System.out.println("X wins");
                    winState[0] = 1;
                } else if (checkWinConditions(gameBoard).equals("O")) {
                    winState[0] = 1;
                    System.out.println("O wins");

                } else {
                    turnCount++;
                    gameLoop(gameBoard, turnCount, winState);

                }
            }

        }
    }

    public static boolean isSpaceOccupied(int row, int col, String[][] gameBoard) {
        return gameBoard[row][col].equals("X") || gameBoard[row][col].equals("O");
    }
}
