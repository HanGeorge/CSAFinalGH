public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    /**
     * Constructor for Cell.
     */
    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void incrementAdjacentMines(int count) {
        this.adjacentMines = count;
    }
}