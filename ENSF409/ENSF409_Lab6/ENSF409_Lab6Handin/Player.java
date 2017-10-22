import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Player that takes part in the game
 * 
 * @author Arush Malhotra
 * @version 1.0
 *
 */

public class Player implements Constants, Runnable {
	
	/**
	 * Name of the player
	 */
	public String name;
	
	/**
	 * The board on which the game is being played
	 */
	public Board board;
	
	/**
	 * The player can identify their opponent
	 */
	public Player opponent;
	
	/**
	 * The mark assigned to the player
	 */
	public char mark;
	
	public BufferedReader in;
	public PrintWriter out;
	
	/**
	 * Constructor to initialize the player
	 * @param name Name of the player
	 * @param letter The letter assigned to the player
	 */
	Player(String name, char letter){
		this.name = name;
		this.mark = letter;
	}
	
	Player(BufferedReader in, PrintWriter out, String name, char letter, Board board){
		this.in = in;
		this.out = out;
		this.name = name;
		this.mark = letter;
		this.board = board;
	}
	/**
	 * Calls a method makeMove() only if the game has not ended which would be a 
	 * result of a tie of one of the player winning 
	 * @throws IOException
	 */
	synchronized public void play() throws IOException{
		board.display(out);
		if(board.xWins()){
			if(this.mark == LETTER_X)
				out.println(this.name + " is the winner");
			else 
				out.println(opponent.name + " is the winner");
			out.println("QUIT");
			System.exit(1);
		}
		else if (board.oWins()){
			if(this.mark == LETTER_X)
				out.println(opponent.name + " is the winner");
			else 
				out.println(this.name + " is the winner");
			out.println("QUIT");
			System.exit(1);
		}
		else if (board.isFull()){
			out.println("The game is a tie");
			out.println("QUIT");
			System.exit(1);
		}
		else{
			makeMove();
			opponent.play();
		}
	}
	
	/**
	 * Prompts player for input and adds to board
	 * @throws IOException
	 */
	public void makeMove() throws IOException{
		int row,col = 0;
		do {
		out.println(this.name + ", what row should your next mark be placed in?");
		row = Integer.parseInt(in.readLine());
		while(row < 0 || row > 2){
			out.println("Sorry row must be 0,1,or 2, try again!");
			row = Integer.parseInt(in.readLine());
		}
		out.println(this.name + ", what column should your next mark be placed in?");
		col = Integer.parseInt(in.readLine());
		while(col < 0 || col > 2){
			out.println("Sorry column must be 0,1,or 2, try again!");
			col = Integer.parseInt(in.readLine());
		}
		if(!board.checkSpot(row, col)) out.println("Sorry that spot is taken, try again!");
		} while (!board.checkSpot(row, col));
		board.addMark(row, col, this.mark);
	}
	
	/**
	 * Connects the other player to this player
	 * @param a Sets player a as an opponent
	 */
	public void setOpponent(Player a){
		this.opponent = a;
	}
	
	/**
	 * Recieves the information about the board
	 * @param theBoard the board that is used in the game
	 */
	public void setBoard(Board theBoard){
		this.board = theBoard;
	}
	public void setName(String a){
		this.name = a;
	}

	@Override
	public void run() {
		try {
			play();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}


