/**
 * Main class to run the Minesweeper game.
 */
public class Minesweeper {
    /**
     * Main method to start the Minesweeper game.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        MinesweeperBoard gameBoard = new MinesweeperBoard(10, 10, 10);
        Game game = new Game(gameBoard);
        game.play();
    }
}