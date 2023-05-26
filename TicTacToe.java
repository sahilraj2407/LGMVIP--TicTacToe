import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    private static boolean gameEnded;

    public static void main(String[] args) {
        initializeBoard();
        currentPlayer = 'X';
        gameEnded = false;

        while (!gameEnded) {
            printBoard();
            getPlayerMove();
            checkGameStatus();
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
        int row = scanner.nextInt() - 1;
        int col = scanner.nextInt() - 1;

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
        } else {
            System.out.println("Invalid move! Try again.");
            getPlayerMove();
        }
    }

    private static void checkGameStatus() {
        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
            gameEnded = true;
        } else if (checkDraw()) {
            System.out.println("It's a draw!");
            gameEnded = true;
        }
    }

    private static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}
}
