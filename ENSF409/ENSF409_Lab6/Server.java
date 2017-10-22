import java.net.*;
import java.io.*;

public class Server implements Constants{
	public PrintWriter out;
	public PrintWriter out2;
	public Socket aSocket;
	public Socket bSocket;
	public ServerSocket serverSocket;
	public BufferedReader in;
	public BufferedReader in2;
	public static Board board = new Board();
	Player p1, p2;
	
	public Server(){
		try{
			serverSocket = new ServerSocket(9090);
		}catch(IOException e){
			System.err.println(e.getStackTrace());
		}
		System.out.println("Server is running...");
	}
	
	public static void main(String[] args) {
		try{
			Server myserver = new Server();
			
			myserver.aSocket = myserver.serverSocket.accept();
			myserver.in = new BufferedReader(new InputStreamReader(myserver.aSocket.getInputStream()));
			myserver.out = new PrintWriter((myserver.aSocket.getOutputStream()), true);
			myserver.out.println("Please enter the name of the X player: ");
			String name = myserver.in.readLine();
			Player p1 = new Player(myserver.in, myserver.out, name,  LETTER_X, board );
			Thread t1 = new Thread(p1);
			
			
			myserver.bSocket = myserver.serverSocket.accept();
			myserver.in2 = new BufferedReader(new InputStreamReader(myserver.bSocket.getInputStream()));
			myserver.out2 = new PrintWriter((myserver.bSocket.getOutputStream()), true);
			myserver.out2.println("Please enter the name of the O player: ");
			String name2 = myserver.in2.readLine();
			Player p2 = new Player(myserver.in2, myserver.out2, name2,  LETTER_O, board ); 
			p2.setOpponent(p1);
			p1.setOpponent(p2);
			Thread t2 = new Thread(p2);
			t1.start();
			try{
				t1.join();
				t2.join();
			}catch(InterruptedException ee){
				System.out.println("Error");
			}
			t2.start();
			
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

	}

}
