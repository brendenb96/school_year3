import java.util.Scanner;

/**
	* The Player class of the tic tac toe game that makes its moves, and plays the game
    * This class is the users.
	* @author Brenden Bickner
	* @version 1.0
	* @since 2017-01-28
*/

public class Player implements Constants {
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
    public void play(){
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
        /**
         * Gets input from the user and adds move to the board
         */
    public void makeMove(){
        Scanner scan = new Scanner(System.in);
        int input_row, input_collumn;
        do {                                   // Keep taking input until correct
            System.out.print(name + ", what row for your next move? or (quit):");
            while(!scan.hasNextInt()){                  // Wait until integer
            String quit = scan.nextLine();
            if(quit.toUpperCase().equals("QUIT")){System.out.println("Quit the Game"); System.exit(1);}
            System.out.println("Error in input: Try again");
            scan.next();
        }
         input_row = scan.nextInt();                            // Get the row
         System.out.print(name + ", what column for your next move? or (quit):");
         while(!scan.hasNextInt()){                             // Wait until integer
            System.out.println("Error in input: Try again");
            scan.next();
          }
            input_collumn = scan.nextInt();                     // Get the column
        if(input_row < 0 || input_row > 2 || input_collumn < 0 || input_collumn > 2){
        System.out.println("Error in input: Try again");}
        else if(!board.checkSpot(input_row,input_collumn))System.out.println("Error in input: Try again");
        }while(input_row < 0 || input_row > 2 || input_collumn < 0 || input_collumn > 2 || 
                        !board.checkSpot(input_row,input_collumn)); // Checks for out of bounds or filled space
        System.out.println("");
        board.addMark(input_row, input_collumn, mark);       
    }
        /** 
         * Sets the opponent for the player
         */
    public void setOpponent(Player p){
        this.opponent = p;
    }
        /** 
         * Sets the board for the player
         */
    public void setBoard(Board b){
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