import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assign4 {

	static int mat[][];
	static int query[][];

	public static void main(String[] args) {

		// Check the input
		if (!CheckInput(args)) {
			System.err.println(
					"Invalid arguments. Arguments format is (input.txt) (query.txt) (depthoutput.txt) (breadthoutput)");
			System.exit(1);
		}

		// Assign arguments to variables
		String inputFile = args[0];
		String queryFile = args[1];
		String depthOutput = args[2];
		String breadthOutput = args[3];
	
		// Create sort structures
		BFS breadthfirst = new BFS();
		DFS depthfirst = new DFS();

		// Try catch block for reading and writing files
		try {
			// Find the sizes of the matrices
			int input_mat_size = inputSize(inputFile);
			int query_mat_size = inputSize(queryFile);

			// Read input from files into matrices
			mat = getInputMat(inputFile, input_mat_size);
			query = getQuerytMat(queryFile, query_mat_size);

			// Create writers for breadth first traversal
			FileWriter filewriter_breadth = new FileWriter(breadthOutput);
			BufferedWriter buffered_breadth = new BufferedWriter(filewriter_breadth);
			buffered_breadth.write("Breadth First Traversal\n");

			// Do the breadth first traversal for all queries
			for (int i = 0; i < query_mat_size; i++){
				buffered_breadth.write("From "+query[i][0]+" to "+query[i][1]+" -- ");
				breadthfirst.bfs(mat, query[i][0], query[i][1], buffered_breadth);
			}
			buffered_breadth.close();

			// Create writers for depth first traversal
			FileWriter filewriter_depth = new FileWriter(depthOutput);
			BufferedWriter buffered_depth = new BufferedWriter(filewriter_depth);
			buffered_depth.write("Depth First Traversal\n");

			// Do the depth first traversal for all queries
			for (int i = 0; i < query_mat_size; i++){
				buffered_depth.write("From "+query[i][0]+" to "+query[i][1]+" -- ");
				depthfirst.dfs(mat, query[i][0], query[i][1], buffered_depth);
			}
			buffered_depth.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method to find input size of an array
	public static int inputSize(String inputFile) {
		Scanner scan = null;
		int count = 0;
		try {
			scan = new Scanner(new File(inputFile));
			while (scan.hasNext()) {
				scan.nextLine();
				count++;
			}
		}

		catch (IOException e) {
			System.out.println("Couldn't find file");
		}
		return count;
	}

	// Method to read text from file and put into input matrix
	public static int[][] getInputMat(String inputfile, int size) {
		int[][] val = new int[size][size];
		Scanner scan = null;
		try {
			scan = new Scanner(new File(inputfile));
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					val[i][j] = Integer.parseInt(scan.next());
					//System.out.print(val[i][j]+" ");
				}
				//System.out.println("");
				scan.nextLine();
			}
		}

		catch (IOException e) {
			System.out.println("Couldn't find file");
		}
		return val;
	}

	// Method to read text from file and put into query matrix
	public static int[][] getQuerytMat(String inputfile, int size) {
		int[][] val = new int[size][2];
		Scanner scan = null;
		try {
			scan = new Scanner(new File(inputfile));
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < 2; j++) {
					val[i][j] = Integer.parseInt(scan.next());
					//System.out.print(val[i][j]+" ");
				}
				scan.nextLine();
				//System.out.println("");
			}
		} catch (IOException e) {
			System.out.println("Couldn't find file");
		}
		return val;
	}

	// Method to check input from command line
	protected static boolean CheckInput(String[] s) {
		if (s.length != 4)
			return false;
		else if (!(s[0].substring(s[0].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Input must be a text file");
			return false;
		} else if (!(s[1].substring(s[1].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Input must be a text file");
			return false;
		} else if (!(s[2].substring(s[2].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Output must be a text file");
			return false;
		} else if (!(s[3].substring(s[3].length() - 4).equals(".txt"))) {
			System.out.println("ERROR: Output must be a text file");
			return false;
		} else
			return true;
	}

}
