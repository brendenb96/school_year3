import java.net.*;
import java.io.*;

public class Client {

	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	
	public Client(String serverName, int portNumber){
		try{
			aSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		} catch(IOException e){
			System.err.println(e.getStackTrace());
		}
	}
	
	public void displayIsActive(){
		for(int i =0; i<15;i++){
			try {
				System.out.println(socketIn.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void communicate(){
		String temp = "";
		String response = " ";
		try{
			response = socketIn.readLine();
			System.out.println(response);		
			temp = stdIn.readLine();
			socketOut.println(temp);
			
			while(!temp.equals("QUIT")||(!response.equals("QUIT"))){
				for(int i =0; i<14;i++){
					System.out.println(socketIn.readLine());
				}
				
				response = socketIn.readLine();
				System.out.println(response);
				temp = stdIn.readLine();
				socketOut.println(temp);
				
				response = socketIn.readLine();
				System.out.println(response);
				temp = stdIn.readLine();
				socketOut.println(temp);

					
			}
		}catch(IOException e){
			System.out.println("QUIT");
		}
	}
	
	public static void main(String[] args) {
		Client aClient = new Client("localhost",9090);
		aClient.communicate();

	}

}
