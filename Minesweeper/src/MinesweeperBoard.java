import java.util.Random;

/**
 * MinesweeperBoard class extending the generic Board class to add Minesweeper-specific functionality.
 */
public class MinesweeperBoard extends Board {
    private int totalMines;

    /**
     * Constructor for MinesweeperBoard.
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param totalMines number of mines to place on the board
     */
    public MinesweeperBoard(int rows, int cols, int totalMines) {
        super(rows, cols);
        this.totalMines = totalMines;
        initializeBoard();
    }

    @Override
    public void initializeBoard() {
        placeMines();
        calculateAdjacentMines();
    }

    /**
     * Places mines randomly on the board.
     */
    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < totalMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                placedMines++;
            }
        }
    }

    /**
     * Calculates the number of adjacent mines for each cell.
     */
    private void calculateAdjacentMines() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!cells[row][col].isMine()) {
                    int mineCount = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int newRow = row + i;
                            int newCol = col + j;
                            if (isInBounds(newRow, newCol) && cells[newRow][newCol].isMine()) {
                                mineCount++;
                            }
                        }
                    }
                    cells[row][col].incrementAdjacentMines(mineCount);
                }
            }
        }
    }
}