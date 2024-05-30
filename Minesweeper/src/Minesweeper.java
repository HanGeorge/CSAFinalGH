import javax.swing.*;


 //Main class to run the Minesweeper game.

public class Minesweeper {
    /**
     * Main method to start the Minesweeper game.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinesweeperBoard gameBoard = new MinesweeperBoard(10, 10, 10);
            GameFrame gameFrame = new GameFrame(gameBoard);
            gameFrame.setVisible(true);
        });
    }
}