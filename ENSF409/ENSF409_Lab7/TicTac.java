/**
 * TicTac Gui two player game
 * @author BrendenBickner
 * @author GauravModha
 * @version 1.0
 * @since 2017-03-21
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
/**
 * TicTac GUI
 */
public class TicTac extends JFrame{

    public JButton[][] buttons;                             // Variables needed to be used
    public JButton reset;
    public JTextField mark;
    public JTextField name;
    public JTextArea mess;
    public JPanel main;
 
    
    public volatile boolean xturn = false;                  // Volatile variables used for events
    public volatile boolean oturn = false;
    public volatile boolean gameover = false;
    public volatile boolean hasInput = false;

    public Player oPlayer;                                  // Game Variables
    public Player xPlayer;
    public int markCount;

    /**
     * Default Constructor for the game
     */
    public TicTac(){
        super("Two Player Tic-Tac-Toe Game");                                  // Super constructor
        main = new JPanel();
        main.setLayout(new GridLayout(2,2,20,20));
        main.setBorder(new EmptyBorder(10, 10, 20, 20));    
        setLayout(new BorderLayout());                                         // Set a border layour for the JFrame
        JPanel botleft = new JPanel();                                         // Create the 4 panels for the frame
        botleft.setLayout(new GridLayout(4,1));
        JPanel botright = new JPanel();
        botright.setLayout(new BorderLayout()); 
        reset = new JButton("Close Game");                                     // Create a close game button and event
        reset.addActionListener(new ActionListener() {                          
            @Override
            public void actionPerformed(ActionEvent i) {
                System.exit(1);
            }
        });
        botright.add(reset,BorderLayout.PAGE_END);
        JPanel topleft = new JPanel();
        topleft.setLayout(new BorderLayout());
        JPanel thebuttons = new JPanel();
        thebuttons.setLayout(new GridLayout(3, 3,5,5));                      // Create the array of buttons for game
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Ariel", Font.BOLD, 40));
                buttons[i][j].addActionListener(new myActionListener());       // Add custom listener to the class
				thebuttons.add(buttons[i][j]);                                 // Add buttons to the panel
            }
		}
        topleft.add(thebuttons);                                               // Format the layout of top left panel                                                      // Add top left to JFrame

        JPanel prompt = new JPanel();                                          // Format the prompt panel
        prompt.setLayout(new BorderLayout());
        JPanel title = new JPanel();
        title.setLayout(new FlowLayout(FlowLayout.CENTER));
        title.add(new JLabel("-- Messages --"));
        mess = new JTextArea(10,10);
        mess.setEditable(false);
        prompt.add(mess,BorderLayout.CENTER);
        prompt.add(title,BorderLayout.NORTH);

        JPanel nameinput = new JPanel();                                        // Format the input panel, bottom left
        nameinput.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameinput.add(new JLabel("Name: "));
        name = new JTextField(10);
        name.setEditable(false);
        name.addActionListener(new ActionListener(){                            // Create text field and event for name input
            @Override
            public void actionPerformed(ActionEvent i) {
                hasInput = true;
            }
        });
        nameinput.add(name);           

        JPanel charinput = new JPanel();
        charinput.setLayout(new FlowLayout(FlowLayout.CENTER));
        charinput.add(new JLabel("Player: "));
        mark = new JTextField(1);
        mark.setEditable(false);
        charinput.add(mark);

        botleft.add(new JLabel(" "));                                           // Add bottom left components
        botleft.add(charinput);
        botleft.add(nameinput);

        main.add(topleft);                                                      // Add panels to main panel
        main.add(prompt);
        main.add(botleft);                                                              
        main.add(botright);

        add(main);                                                              // Add panel to JFrame

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);                   // Create a confirm close option
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //JFrame frame = (JFrame) e.getSource();
                int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(),
                        "Are you sure you want to exit the application?", "Exit Application",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        setSize(600,600);                                                       // Set size and make visible
        setVisible(true);

    }
    /**
     * Gets the name from the text Field of the GUI
     * @return users input
     */
    public String getName(){
        name.setEditable(true);
        while(!hasInput){}
        name.setEditable(false);
        hasInput = false;
        String val = name.getText();
        name.setText("");
        return val;
    }
    /**
     * Checks the board for any three in a row
     * @param mark the mark to check for win    
     * @return 1 if there is a win, 0 otherwise
     */
    public int checkWinner(String mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (!buttons[row][col].getText().equals(mark))
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (!buttons[row][col].getText().equals(mark))
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (!buttons[row][row].getText().equals(mark))
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (!buttons[row][3 - 1 - row].getText().equals(mark))
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
    /**
     * Checks if the game is a tie
     * @return true if game is tie
     */
    public boolean gameTie(){
        if((markCount == 9)&&(!oIsWinner())&&(!xIsWinner())){gameover=true;return true;}
        else return false;
    }
    /**
     * Check is O won the game
     * @return true if O has won
     */
    public boolean oIsWinner(){
        if(checkWinner("O")==1){gameover = true; return true;}
        else return false;
    }
    /**
     * Check is X won the game
     * @return true if X has won
     */
    public boolean xIsWinner(){
        if(checkWinner("X")==1){gameover = true; return true;}
        else return false;
    }
    /**
     * Starts game
     * prompts for the names, creates players
     * Prints a win
     */
    public void start(){
        String xname = null;
        String oname = null;
        mess.append("X Player please enter your name\n");
        while(xname == null){
            xname = getName();
        }
        mess.append("O Player please enter your name\n");
        while(oname == null){
            oname = getName();
        }
        mess.setText("Game Started!");
        xPlayer = new Player(xname,"X");
        oPlayer = new Player(oname,"O");
        xturn = true;
        xplay();
        if(oIsWinner()) mess.append("\n" + oPlayer.name + " is the winner");
        else if(xIsWinner()) mess.append("\n" + xPlayer.name + " is the winner");
        else mess.append("\n The game is a tie!");
    }
    /**
     * Starts X players turn
     */
    public void xplay(){
        if(!(oIsWinner()||xIsWinner()||gameTie())){
            mess.append("\n" + xPlayer.name + ", it is your turn");
            mark.setText(xPlayer.mark);
            name.setText(xPlayer.name);
        while(xturn){}
        oplay();
        }
    }
    /**
     * Starts O players turn
     */
    public void oplay(){
        if(!(oIsWinner()||xIsWinner()||gameTie())){
            mess.append("\n" + oPlayer.name + ", it is your turn");
            mark.setText(oPlayer.mark);
            name.setText(oPlayer.name);
        while(oturn){}
        xplay();
        }
    }
    /**
     * ActionListener that finds which button has been pressed
     * Puts the proper mark there and disables the button
     */
private class myActionListener implements ActionListener{
 public void actionPerformed(ActionEvent a) 
  {
   if(xturn && (!gameover))                                 // X players block
   { 
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(a.getSource() == buttons[i][j]){
                buttons[i][j].setText("X");
                buttons[i][j].setEnabled(false);
		        markCount++;}
            }
        }
       xturn = false;
       oturn = true; }
   else if(oturn && (!gameover))                           // O players block
   {
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(a.getSource() == buttons[i][j]){
                buttons[i][j].setText("O");
                buttons[i][j].setEnabled(false);
		        markCount++;}
            }
        }
       oturn = false;
       xturn = true; }
   }
  }
  public static void main(String[] args){                   // Main Function
      TicTac game = new TicTac();
      game.start();
  }

 }
