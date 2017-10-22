/**
 * Extension of BlockingPlayer that will check for win first, then block, then a random play
 * @author Brenden Bickner
 * @author Guarav Modha
 * @version 1.0
 * @since 2017-02-08
 */
public class SmartPlayer extends BlockingPlayer{
   /**
     * Constructor for RandomPlayer
     * uses the super() constror
     * @param n the name of the Player
     * @param c the mark for the Player
     */
        public SmartPlayer(String n,char c){
        super(n,c);        
    }
    /**
     * Makes move for SmartPlayer
     * Checks for a win first
     * then checks for a block
     * then plays random
     */
    protected void makeMove() {
        boolean block_found = false;                                    // Loops to find a blocking position
        int row_block = 0; int col_block = 0; int i = 0; int j = 0;
        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                if(board.checkSpot(i,j)){
                if(this.testForBlocking(i,j)){
                    row_block = i; col_block = j; block_found = true;
                }}
            }
        }                                                               // Loops to find a winning position
        boolean win_found = false;                                      // Use practically same algorithm as what was 
        int row_win = 0; int col_win = 0;                               // used to find a block position but instead
        for(i = 0; i < 3; i++){                                         // calls testForWin
            for(j = 0; j < 3; j++){
                if(board.checkSpot(i,j)){
                if(this.testForWin(i,j)){
                    row_win = i; col_win = j; win_found = true;
                }}
            }
        }
        if(win_found)board.addMark(row_win,col_win,this.mark);              // If win is found, plays that position
        else if(block_found)board.addMark(row_block,col_block,this.mark);   // If no win found but block is, play there
        else{                                                               // If neither, play a random position
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
     public boolean testForBlocking(int row, int col){                      // Uses super class's test for blocking method
        return super.testForBlocking(row, col);
    }
    /**
     * Returns true if the spot is a winning Position
     * @param row the row to be examined
     * @param col the collumn to be examined
     */
    public boolean testForWin(int row, int col){                        // Uses same algorithm as test for blocking
        char temp = board.getMark(row, col);                            // but instead checks for their win not opponent's
        board.ChangeMark(row, col, this.mark);
        if(board.checkWinner(this.mark) == 1){
            board.ChangeMark(row, col, temp);
            return true;
        }
        else{
           board.ChangeMark(row, col, temp);
             return false; }
    }
}