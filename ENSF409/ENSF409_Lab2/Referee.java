

/**
	* The Referee of the tic tac toe game that displays the board, sets the opponents, as well as starts the game.
	* @author Brenden Bickner
	* @version 1.0
	* @since 2017-01-28
*/

public class Referee implements Constants {
    /**
     * The x player in the game
     */
    private Player xPlayer;
    /**
     * The o player in the game
     */
    private Player oPlayer;
    /**
     * The game board
     */
    private Board board;
    /**
     * This contructor initializes to users with default names
     */
    public Referee(){
        Player xPlayer = new Player("BOB",LETTER_X);
        Player oPlayer = new Player("JULIE",LETTER_O);
        board = new Board();
    }
    /** 
     * Sets the opponents, displays the board, then starts the game
     */
    public void runTheGame(){
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        board.display();
        xPlayer.play();
    }
    /**
     * Sets the board for the referee
     */
    public void setBoard(Board b){
        this.board = b;
    }
    /**
     * Sets the o player 
     */
    public void setoPlayer(Player o){
        this.oPlayer = o;
    }
    /**
     * Sets the x player
     */
    public void setxPlayer(Player x){
        this.xPlayer = x;
    }

}