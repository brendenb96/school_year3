import java.io.PrintWriter;

/**
 * Provides the necessary logic for the game to run
 * 
 * @author Arush Malhotra
 * @version 1.0
 *
 */


public class Board implements Constants {
	
	/**
	 * A 2D array where information about the board is saved
	 */
	private char theBoard[][];
	
	/**
	 * Counts how many marks are on the board
	 */
	private int markCount;
	
	/**
	 * Initializes the board
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	
	/**
	 * Finds the mark on the board at a given location
	 * @param row  The row location
	 * @param col  The column location
	 * @return The mark that is in the location
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	/**
	 * Checks if spot is Free
	 * @param row The row location
	 * @param col The column Location
	 * @return if spot is free
	 */
	public boolean checkSpot(int row, int col) {
		return theBoard[row][col] == SPACE_CHAR;
	}
	/**
	 * Checks if the board is full
	 * @return true if board is full, false otherwise
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if 'X' won the game
	 * @return true if player x won, false otherwise
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * CHecks if 'O' won the game
	 * @return true if player o won, false otherwise
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the board in the console
	 * 
	 */
	public void display(PrintWriter out) {
		displayColumnHeaders(out);
		addHyphens(out);
		for (int row = 0; row < 3; row++) {
			addSpaces(out);
			out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				out.print("|  " + getMark(row, col) + "  ");
			out.println("|");
			addSpaces(out);
			addHyphens(out);
		}
	}

	/**
	 * Adds the mark to given coordinates on the board.
	 * @param row integer value of the row where the user wants to place mark
	 * @param col integer value of the column where the user wants to place mark
	 * @param mark identify the player either 'X' or 'O'
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears and resets the board.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks if the given mark is the winner or not.
	 * @param mark identify the player either 'X' or 'O'
	 * @return the winner
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays the column numbers to make it easily identifiable by users
	 */
	void displayColumnHeaders(PrintWriter out) {
		out.print("          ");
		for (int j = 0; j < 3; j++)
			out.print("|col " + j);
		out.println();
	}

	/**
	 *  Formats the board displayed on the console
	 */
	void addHyphens(PrintWriter out) {
		out.print("          ");
		for (int j = 0; j < 3; j++)
			out.print("+-----");
		out.println("+");
	}
	
	/**
	 * Prints empty spaces 
	 */
	void addSpaces(PrintWriter out) {
		out.print("          ");
		for (int j = 0; j < 3; j++)
			out.print("|     ");
		out.println("|");
	}
}
