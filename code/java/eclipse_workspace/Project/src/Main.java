import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		// get input from file
		
		String inputFile = "a_example";
		
		int rows, cols;
		int numVehicles;
		int numRides;
		int bonus;
		int totalSteps;
		
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		
		int[] lineInts;
		int lineCounter = 0;
		
		lineInts = readInts();
		rows = lineInts[lineCounter++];
		cols = lineInts[lineCounter++];
		numVehicles = lineInts[lineCounter++];
		numRides = lineInts[lineCounter++];
		bonus = lineInts[lineCounter++];
		totalSteps = lineInts[lineCounter++];
	}
	
	public static int[] readInts() throws IOException {
		String[] parts = in.readLine().split(" ");
		int[] asInts = new int[parts.length];
		
		for (int i = 0; i < parts.length; ++i) {
			asInts[i] = Integer.parseInt(parts[i]);
		}
		
		return asInts;
	}
	
}
