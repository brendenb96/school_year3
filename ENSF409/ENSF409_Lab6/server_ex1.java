package inlab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class server_ex1 {
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	private ServerSocket serverSocket;
	private Socket aSocket;

	/**
	 * Construct a Server with Port 9090
	 */
	public server_ex1() {
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("Server is now running.");
			aSocket = serverSocket.accept();
			socketInput = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOutput = new PrintWriter(aSocket.getOutputStream(), true);
		} catch (IOException e) {
		}
	}

	/**
	 * Get input from Client.
	 * 
	 * @throws IOException
	 */
	public void getUserInput() throws IOException {
		StringBuffer line = null;
		while (true) {
			line = new StringBuffer(socketInput.readLine());
			if (line != null) {
				if (line.toString().toLowerCase().equals("quit")) {
					break;
				}
                if(isPalindrome(line))socketOutput.println(line+" is a palindrome!");
                else socketOutput.println(line+" is not a palindrome!");
			}
			
		}
		socketInput.close();
		socketOutput.close();
		serverSocket.close();
	}
    public boolean isPalindrome(String s){
        String s1 = s.toLowerCase();
        String s2 = s.reverse(s);
        if(s1.equals(s2)) return true;
        else return false;
    }
    public String reverse(String input){ // generic string reversal code
    char[] in = input.toCharArray();
    int begin=0;
    int end=in.length-1;
    char temp;
    while(end>begin){
        temp = in[begin];
        in[begin]=in[end];
        in[end] = temp;
        end--;
        begin++;
    }
    return new String(in);
}
	/**
	 * Run the Server.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		server_ex1 ds = new server_ex1();
		ds.getUserInput();
	}
}