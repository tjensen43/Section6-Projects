import java.util.Scanner;

public class Proj6_2_TicTacToe {
    public static void main(String[] args) {
        String[][] gameBoard = new String[3][3];
        populateGameBoard(gameBoard);
        int turnCount = 0;
        int winState = 0;
        gameLoop(gameBoard, turnCount, winState);
    }

    public static int gameLoop(String[][] gameBoard, int turnCount, int winState) {
        while (winState == 0) {
            printGameBoard(gameBoard);
            getUserInput(gameBoard, turnCount, winState);
        }


    }

    private static String checkWinConditions(String[][] gameBoard) {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2];
                    break;
                case 1:
                    line = gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2];
                    break;
                case 2:
                    line = gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2];
                    break;
                case 3:
                    line = gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
                    break;
                case 4:
                    line = gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
                    break;
                case 5:
                    line = gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
                    break;
                case 6:
                    line = gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2];
                    break;
                case 7:
                    line = gameBoard[0][2] + gameBoard[1][1] + gameBoard[2][0];
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "0";

            }

        }
        return "-";
    }

    public static void populateGameBoard(String[][] twoDArr) {

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

    public static void getUserInput(String[][] gameBoard, int turnCount, int winState) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter next move");
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        if (isSpaceOccupied(row, col, gameBoard)) { // isSpaceOccupied returns true
            System.out.println("Space occupied!");
            getUserInput(gameBoard, turnCount, winState);

        } else if (!isSpaceOccupied(row, col, gameBoard)) { // isSpaceOccupied returns false
            switch (turnCount % 2) {
                case 0: // X
                    gameBoard[row][col] = "X";
                    if (checkWinConditions(gameBoard).equals("X")) {
                        System.out.println("X wins");
                        winState = 1;
                    } else if (checkWinConditions(gameBoard).equals("O")) {
                        System.out.println("O wins");
                        winState = 1;

                    } else {
                        turnCount++;
                        gameLoop(gameBoard, turnCount, winState);

                    }
                    break;
                default: // O
                    gameBoard[row][col] = "O";
                    if (checkWinConditions(gameBoard).equals("X")) {
                        System.out.println("X wins");
                        winState = 1;
                    } else if (checkWinConditions(gameBoard).equals("O")) {
                        winState = 1;
                        System.out.println("O wins");

                    } else {
                        turnCount++;
                        gameLoop(gameBoard, turnCount, winState);
                    }

            }

        }
    }

    public static boolean isSpaceOccupied(int row, int col, String[][] gameBoard) {
        boolean isOccupied = false;
        if (gameBoard[row][col].equals("X") || gameBoard[row][col].equals("O")) {
            isOccupied = true;
        }
        return isOccupied;
    }


    public static boolean isBoardFull(String[][] gameBoard) {

        return false;
    }
}
