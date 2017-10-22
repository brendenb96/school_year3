

/**
	* The Player class of the tic tac toe game that makes its moves, and plays the game
    * This class is the users.
	* @author Brenden Bickner
	* @version 1.0
	* @since 2017-01-28
*/

public abstract class Player implements Constants {
    /**
     * Name of the player
     */
    public String name;
    /**
     * The playing board
     */
    public Board board;
    /**
     * The Player's opponent
     */
    public Player opponent;
    /**
     * The Player's mark(X or O)
     */
    public char mark;
    /**
     * Constructor inputs name and mark
     * @param n is the name
     * @param c is the mark
     */
    public Player(String n,char c){
        this.mark = c;
        this.name = n;    
    }
    /**
     * Allows the player to do their move as well as check for a winner
     */
    protected abstract void play();
        /**
         * Gets input from the user and adds move to the board
         */
    protected abstract void makeMove();
        /** 
         * Sets the opponent for the player
         */
    protected void setOpponent(Player p){
        this.opponent = p;
    }
        /** 
         * Sets the board for the player
         */
    protected void setBoard(Board b){
        this.board = b;
    }
        /**
         * Checks whether this player is the winner and prints to screen
         */
    public void isWinner(){
        if((mark == LETTER_X && board.xWins())||(mark == LETTER_O && board.oWins())){
            System.out.println("GAME OVER! " + name +" is the winner.");
            System.exit(1);}
    }
}

