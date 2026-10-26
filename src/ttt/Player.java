package ttt;

public class Player {
    private int id;
    private SYMBOL symbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SYMBOL getSymbol() {
        return symbol;
    }

    public void setSymbol(SYMBOL symbol) {
        this.symbol = symbol;
    }

    public Player(int id, SYMBOL symbol) {
        this.id = id;
        this.symbol = symbol;
    }
}
