
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer implements Constants{
	private BufferedReader socketInput;
	private PrintWriter socketOutput;
	private ServerSocket serverSocket;
	private Socket aSocket;
    private Socket bSocket;

	/**
	 * Construct an empty Server
	 */
	public GameServer() {
	}

	/**
	 * Get input from Client.
	 * 
	 * @throws IOException
	 */
	/*
	public void getUserInput() throws IOException {
		StringBuffer line = null;
		while (true) {
			line = new StringBuffer(socketInput.readLine());
			if (line != null) {
				if (line.toString().equals("QUIT")) {
					break;
				}
				if (line.toString().equals("DATE")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
					socketOutput.println( sdf.format(cal.getTime()));
				} else if (line.toString().equals("TIME")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					socketOutput.println( sdf.format(cal.getTime()));
				}else {
					socketOutput.println("Wrong input, please try again");
				}
			}
		}
		socketInput.close();
		socketOutput.close();
		serverSocket.close();
	}
	*/
	/**
	 * Run the Server.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	    serverSocket = new ServerSocket(9090);
		System.out.println("Game Server is now running.");
		try {
			while(true){
			Game game = new Game();
			Player playerx = new Player(serverSocket.accept(),LETTER_X);
			Player playero = new Player(serverSocket.accept(),LETTER_O);
			playerx.setBoard(game.theBoard);
			playero.setBoard(game.theBoard);
			game.theRef = new Referee();
			theRef.setBoard(game.theBoard);
			theRef.setxPlayer(playerx);
			theRef.setoPlayer(playero);
        	Thread x = new Thread(playerx);
			Thread o = new Thread(playero);
			x.start();
			o.start();
			
			}
		} finally{
			serverSocket.close();
		}
	}
}