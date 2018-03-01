package python_interface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private BufferedReader in;
	private PrintWriter out;
	
	public Server() {
		init();
	}
	
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			Socket clientSocket = serverSocket.accept();
			serverSocket.close();
			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends a piece of data to the python program, and returns the
	 * output that the python server supplies.
	 * @param operationID
	 * @param inputData
	 * @return
	 */
	public String runOperation(int operationID, String...inputStrings) {
		// combine all the inputs into a single string
		StringBuilder inputString = new StringBuilder();
		
		for (int i = 0; i < inputStrings.length; ++i) {
			inputString.append(inputStrings[i]);
			
			if (i != inputStrings.length - 1) {
				inputString.append(',');
			}
		}
		
		out.printf("%d:%s%n", operationID, inputString.toString());
		
		// wait/listen for a response
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
}
