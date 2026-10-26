package ttt;

import java.util.Scanner;

public class GameController {
    //initialize
    Board board = new Board(Config.BOARD_SIZE);
    Player player1 = new Player(1, SYMBOL.X);
    Player player2 = new Player(2, SYMBOL.O);

    Scanner scan = new Scanner(System.in);


    //start game
    private boolean turn = true;

    private int checkWinner(){
        SYMBOL[][] cells = board.getCells();
        int n = board.getSize();
        Player currentPlayer = turn ? player1 : player2;

        for(int i=0; i<n; i++){
            boolean rowWin = true;
            boolean colWin = true;

            for(int j=0; j<n; j++){
                if(cells[i][j] != currentPlayer.getSymbol()) rowWin = false;
                if(cells[j][i] != currentPlayer.getSymbol()) colWin = false;
            }
            if(rowWin || colWin) return currentPlayer.getId();
        }

        boolean diag1 = true;
        boolean diag2 = true;

        for(int i=0; i<n; i++){
            if(cells[i][i]!=currentPlayer.getSymbol()) diag1=false;
            if(cells[i][n-i-1]!=currentPlayer.getSymbol()) diag2=false;
        }

        if(diag1||diag2) return currentPlayer.getId();

        return -1;
    }

    public void start(){
        System.out.println("Starting the game");
        while(true) {
            //if board is filled -> no winner
            boolean isFilled = true;
            for(int i=0; i< board.getSize(); i++){
                for(int j=0; j< board.getSize(); j++){
                    if(board.getCells()[i][j]==SYMBOL.E){
                        isFilled = false;
                    }
                }
            }
            if(isFilled){
                System.out.println("No Winner");
                break;
            }

            Player currentPlayer;
            if(turn){
                //player-1 acts
                currentPlayer = player1;
            }else{
                //player-2 acts
                currentPlayer = player2;
            }

            int row, col;
            System.out.println("Enter row and col for "+ (turn ? "player1" : "player2") + ":");
            row = scan.nextInt();
            col = scan.nextInt();

            //validate
            if (row < 0 || row >= board.getSize() ||
                    col < 0 || col >= board.getSize()) {
                System.out.println("Invalid position!");
                continue;
            }

            if (board.getCells()[row][col] != SYMBOL.E) {
                System.out.println("Cell already occupied!");
                continue;
            }

            board.setCell(row, col, currentPlayer.getSymbol());



            //check winner -> return winner or continue
            int winnerId = checkWinner();
            if(winnerId==-1){
                turn = !turn;
            }else if(winnerId == player1.getId()){
                System.out.println("Player 1 is winner");
                return;
            }else{
                System.out.println("Player 2 is winner");
                return;
            }
        }
    }
}
