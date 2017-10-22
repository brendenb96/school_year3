/**
 * Extension of Player that plays on random spots
 * @author Brenden Bickner
 * @author Guarav Modha
 * @version 1.0
 * @since 2017-02-08
 */
public class RandomPlayer extends Player{
    /**
     * Constructor for RandomPlayer
     * uses the super() constror
     * @param n the name of the Player
     * @param c the mark for the Player
     */
        public RandomPlayer(String n,char c){
        super(n,c);      
    }
    /**
     * Selects the next random move
     */
    protected void makeMove(){
        RandomGenerator r = new RandomGenerator();      // New RandomGenerator
        while(true){                                    // Loops until empty spot
            int row = r.discrete(0, 2);
            int col = r.discrete(0, 2);
            if(board.checkSpot(row, col)){
                board.addMark(row, col, this.mark);     // Adds marks
                break;  }
    }
}
    /**
     * Allows the player to play
     * Checks for wins too
     */
    protected void play(){                      // Same as in player
        if(board.isFull() || board.xWins() || board.oWins()){}
        else{ 
        this.makeMove();
        board.display();
        }
        this.isWinner();
        opponent.isWinner();
        if(board.isFull()) System.out.println("GAME OVER! Game is a tie.");
        else opponent.play();
    }

}