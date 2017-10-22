

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.color.*;
/**
	* Implements a text based two player game of Tic-Tac-Toe
*/
public class Game implements Constants {
	/**
	 * The playing board
	 */
	private Board theBoard;
	private Gui theGui;

	/**
	 * Constructs a new blank board class 
	 */
    public Game( ) {
        theBoard  = new Board();
		theGui = new Gui();

	}
	/**
	 * Assigns a referee and starts the game
	 * @param r is the referee to be used
	 * @throws IOException throws an Input/Output exception
	 */
	
	public static void main(String[] args) throws IOException {
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		//stdin = new BufferedReader(new InputStreamReader(System.in));
		String name = JOptionPane.showInputDialog("Please enter the name of the \'O\' player:");
		xPlayer = new Player(name, LETTER_X,theGui);
		xPlayer.setBoard(theGame.theBoard);
		
		name = JOptionPane.showInputDialog("Please enter the name of the \'X\' player:");
		oPlayer = new Player(name, LETTER_O,theGui);
		oPlayer.setBoard(theGame.theBoard);
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);
        theGame.theBoard.display();
        xPlayer.play();
	}
	

}
