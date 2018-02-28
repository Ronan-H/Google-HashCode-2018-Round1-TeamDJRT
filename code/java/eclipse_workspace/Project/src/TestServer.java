
public class TestServer {
	
	public static void main(String[] args) {
		System.out.println("Starting server...");
		
		PythonInterfaceServer server = new PythonInterfaceServer();
		
		int sum = Integer.parseInt(server.runOperation(0, "3,6,13"));
		
		System.out.printf("Sum result: %d%n", sum);
	}
	
}
