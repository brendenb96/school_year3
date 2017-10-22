/**
 * Extension of RandomPlayer that blocks any possible wins
 * @author Brenden Bickner
 * @author Guarav Modha
 * @version 1.0
 * @since 2017-02-08
 */
public class BlockingPlayer extends RandomPlayer{
        /**
     * Constructor for RandomPlayer
     * uses the super() constror
     * @param n the name of the Player
     * @param c the mark for the Player
     */
        public BlockingPlayer(String n,char c){
        super(n,c);    
    }
    /**
     * Makes move for BlockingPlayer
     * Checks for possible block first
     * If no block found, plays a random spot
     */
    protected void makeMove(){
        boolean found = false;                            // Cycles through all spots on board
        int row = 0; int col = 0; int i = 0; int j = 0;
        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                if(board.checkSpot(i,j)){                 // if the spot is free check for blocking
                if(this.testForBlocking(i,j)){            // if good blocking spot, store spot and enable the bool
                    row = i; col = j; found = true;       
                }}
            }
        }
        if(found)board.addMark(row,col,this.mark);        // If block found add a mark to the board
        else{                                             // If no block, play random spot on the board
            RandomGenerator r = new RandomGenerator();
        while(true){
            int row_random = r.discrete(0, 2);
            int col_random = r.discrete(0, 2);
            if(board.checkSpot(row_random, col_random)){
                board.addMark(row_random, col_random, this.mark);
                break;}
             }
        }
}
    /**
     * Returns true if the spot is a good blocking Position
     * @param row the row to be examined
     * @param col the collumn to be examined
     */
    protected boolean testForBlocking(int row, int col){   
        char temp = board.getMark(row, col);                // Store the mark at the spot
        board.ChangeMark(row, col, this.opponent.mark);     // Put opponents mark in the spot
        if(board.checkWinner(this.opponent.mark) == 1){     // Check for opponent win
            board.ChangeMark(row, col, temp);               // If opponent would win replace old mark
            return true;                                    // Return that this is a good blocking spot
        }
        else{
           board.ChangeMark(row, col, temp);                // Put board back to normal
             return false; }                                // Return false meaning no block at this spot
    }
}