package ttt;

public class Board {
    private int size;
    private SYMBOL[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new SYMBOL[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                cells[i][j] = SYMBOL.E;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SYMBOL[][] getCells() {
        return cells;
    }

    public SYMBOL getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, SYMBOL symbol) {
        cells[row][col] = symbol;
    }

    public void setCells(SYMBOL[][] cells) {
        this.cells = cells;
    }
}
