/**
//STUDENTS SHOULD ADD CLASS COMMENT, METHOD COMMENTS, FIELD COMMENTS 
	* Implements a text based two player game of Tic-Tac-Toe
	* @author Brenden Bickner
	* @version 1.0
	* @since 2017-01-28
*/


public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	public Board() {
		/**
		 * Constructor creates the board, filling it with SPACE_CHAR
		 */
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	/**
	 * Gets what mark is in which space of the board
	 * @param row is the row of the board
	 * @param col is the collumn of the board
	 * @return is the mark at that position (X,O,or space)
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	public boolean checkSpot(int row, int col) {
		return theBoard[row][col] == SPACE_CHAR;
	}
	/** Checks if the entire board is full
	 * @return true if the board is full
	 */
	public boolean isFull() {
		return markCount == 9;
	}
	/**
	 * Checks if the X player has one
	 * @return true if X has won the game
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Checks if the O player has one
	 * @return true if O has won the game
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Displays the board in the command window
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
	/**
	 * Adds an X or O on the board at a designated spot
	 * @param row is the desired row on the board
	 * @param col is the desired collumn on the board
	 * @param mark is the mark to be put at that point
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	public void ChangeMark(int row, int col, char mark) {		
		theBoard[row][col] = mark;
	}
	/** Clears the entire board
	 */	
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	/** Checks whether or not there are three marks in row
	 * @param mark is the mark to be checked for a win
	 * @return 1 if there is a winner
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
	 * Displays the Headers for user ease
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	/**
	 * Displays the Hyphens for user ease
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	/**
	 * Displays the Spaces for user ease
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
