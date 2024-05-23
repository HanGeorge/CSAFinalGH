import java.util.Scanner;

/**
 * Game class to manage the gameplay.
 */
public class Game {
    private Board board;
    private boolean isGameOver;

    /**
     * Constructor for Game.
     * @param board the game board to use
     */
    public Game(Board board) {
        this.board = board;
        isGameOver = false;
    }

    /**
     * Main game loop to handle user input and game logic.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver) {
            board.displayBoard();
            System.out.print("Enter row and column to reveal (e.g., 0 0): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.isMine(row, col)) {
                isGameOver = true;
                System.out.println("Game Over! You hit a mine.");
            } else {
                board.revealCell(row, col);
            }
        }
        board.displayBoard();
        scanner.close();
    }
}