
import java.io.*;

public class Sums {

    public static void sum(BufferedReader in){ 
        // takes a sequence of integeres in input, and outputs their sum

	int s = 0; 
	int nextInt = 0;
	boolean good_input = false;

	System.out.println("Please input the sequence of integers to sum, terminated by a 0");
     while(!good_input){   
		try {
			nextInt = Integer.parseInt(in.readLine());
            good_input = true;
		} catch (NumberFormatException | IOException ex) {
			System.out.println("Error in Input, please try again.");
			good_input = false;
		}
	 }
	
	while (nextInt!=0) {
	    if(good_input) s = s + nextInt;
		try {
			nextInt = Integer.parseInt(in.readLine());
			good_input = true;
		} catch (NumberFormatException | IOException ex) {
			System.out.println("Error in Input, please try again.");
			good_input = false;
		}
	}

        System.out.println("The sum is " + s);
    }

    public static void main(String[] arg) {         

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                         //"in" will receive data from the standard input stream
	String c = "x";
 
	System.out.println("Do you wish to calculate a sum? (y/n)");

	try {
			c = in.readLine();
		} catch (IOException e) {
			System.out.println("Error in Input, please try again.");
		}

	while (!c.equals("y") && !c.equals("n")) {
	    System.out.println("Please answer y or n");
	    try {
			c = in.readLine();
		} catch (IOException e) {
			System.out.println("Error in Input, please try again.");
		}
	}

	while (c.equals("y")) {
	    sum(in);
	    System.out.println("Do you wish to calculate another sum? (y/n)");
	    try {
			c = in.readLine();
		} catch (IOException e) {
			System.out.println("Error in Input, please try again.");
		}

	    while (!c.equals("y") && !c.equals("n")) {
		System.out.println("Please answer y or n");
		try {
			c = in.readLine();
		} catch (IOException e) {
			System.out.println("Error in Input, please try again.");
			}
	    }
	}
	System.out.println("Goodbye");
    }
}
