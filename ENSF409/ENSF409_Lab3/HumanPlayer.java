import java.util.Scanner;
public class HumanPlayer extends Player{
        public HumanPlayer(String n,char c){
        super(n,c);       
    }
    protected void makeMove(){
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
    protected void play(){
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