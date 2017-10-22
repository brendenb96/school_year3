

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientPlayer implements Constants {
	private static int PORT = 9090;
	private PrintWriter socketOut;
	private Socket socket;
	private BufferedReader stdin;
	private BufferedReader socketIn;
	public Player player;

	public ClientPlayer(String serverName) {
		try {
			socket = new Socket(serverName, PORT);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			socketOut = new PrintWriter((socket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	public void communicate()  {

		String line = "";
		String response = "";
		try{
			while (true) {
				
			
			response = socketIn.readLine();
			if(response.startsWith("Your")){

			}
		}
	}
	finally{
		socket.close();
	}
			
	}

	public static void main(String[] args) throws IOException  {
		ClientPlayer aClient = new ClientPlayer("localhost");
		aClient.communicate();
	}
}