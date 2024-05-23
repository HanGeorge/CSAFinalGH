public abstract class Board {
    protected Cell[][] cells;
    protected int rows;
    protected int cols;

    /**
     * Constructor for Board.
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /**
     * Abstract method to initialize the board.
     */
    public abstract void initializeBoard();

    /**
     * Checks if a given cell is within the bounds of the board.
     * @param row row index
     * @param col column index
     * @return true if the cell is within bounds, false otherwise
     */
    protected boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /**
     * Reveals a cell at the given position.
     * @param row row index
     * @param col column index
     */
    public void revealCell(int row, int col) {
        if (isInBounds(row, col) && !cells[row][col].isRevealed()) {
            cells[row][col].reveal();
            // If the cell has no adjacent mines and is not a mine, reveal surrounding cells
            if (cells[row][col].getAdjacentMines() == 0 && !cells[row][col].isMine()) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        revealCell(row + i, col + j);
                    }
                }
            }
        }
    }

    public boolean isMine(int row, int col) {
        return cells[row][col].isMine();
    }

    public boolean isRevealed(int row, int col) {
        return cells[row][col].isRevealed();
    }

    public int getAdjacentMines(int row, int col) {
        return cells[row][col].getAdjacentMines();
    }
}