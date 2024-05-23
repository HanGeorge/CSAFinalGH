import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GameFrame class to create the GUI for the Minesweeper game.
 */
public class GameFrame extends JFrame {
    private MinesweeperBoard board;
    private JButton[][] buttons;
    private boolean isGameOver;

    /**
     * Constructor for GameFrame.
     *
     * @param board the MinesweeperBoard to use
     */
    public GameFrame(MinesweeperBoard board) {
        this.board = board;
        this.isGameOver = false;
        initializeFrame();
    }

    /**
     * Initializes the game frame and adds components.
     */
    private void initializeFrame() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(board.rows, board.cols));
        buttons = new JButton[board.rows][board.cols];

        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].addActionListener(new CellClickListener(row, col));
                add(buttons[row][col]);
            }
        }
    }

    /**
     * Inner class to handle cell clicks.
     */
    private class CellClickListener implements ActionListener {
        private int row;
        private int col;

        /**
         * Constructor for CellClickListener.
         *
         * @param row row index
         * @param col column index
         */
        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isGameOver) {
                if (board.isMine(row, col)) {
                    isGameOver = true;
                    revealMines();
                    JOptionPane.showMessageDialog(GameFrame.this, "Game Over! You hit a mine.");
                } else {
                    board.revealCell(row, col);
                    updateButtons();
                }
            }
        }
    }

    /**
     * Updates the button text based on the board state.
     */
    private void updateButtons() {
        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if (board.isRevealed(row, col)) {
                    if (board.isMine(row, col)) {
                        // IMAGE OF MINE HERE
                        buttons[row][col].setText("M");
                    } else {
                        buttons[row][col].setText(String.valueOf(board.getAdjacentMines(row, col)));
                    }
                    buttons[row][col].setEnabled(false);
                }
            }
        }
    }

    /**
     * Reveals all mines when the game is over.
     */
    private void revealMines() {
        for (int row = 0; row < board.rows; row++) {
            for (int col = 0; col < board.cols; col++) {
                if (board.isMine(row, col)) {
                    // IMAGE OF MINE HERE
                    buttons[row][col].setText("M");
                }
                buttons[row][col].setEnabled(false);
            }
        }
    }
}