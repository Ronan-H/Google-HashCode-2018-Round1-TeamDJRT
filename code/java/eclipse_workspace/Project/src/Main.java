import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		// get input from file
		
		String inputFile = "d_metropolis.in";
		
		int rows, cols;
		int numVehicles;
		int numRides;
		int bonus;
		int totalSteps;
		
		Ride[] rides;
		
		in = new BufferedReader(new FileReader("./input/" + inputFile));
		
		int[] lineInts;
		int lineCounter = 0;
		
		lineInts = readInts();
		rows = lineInts[lineCounter++];
		cols = lineInts[lineCounter++];
		numVehicles = lineInts[lineCounter++];
		numRides = lineInts[lineCounter++];
		bonus = lineInts[lineCounter++];
		totalSteps = lineInts[lineCounter++];
		
		rides = new Ride[numRides];
		
		for (int i = 0; i < rides.length; ++i) {
			lineInts = readInts();
			lineCounter = 0;
			rides[i] = new Ride();
			Ride ride = rides[i];
			ride.startRow = lineInts[lineCounter++];
			ride.startCol = lineInts[lineCounter++];
			ride.destRow = lineInts[lineCounter++];
			ride.destCol = lineInts[lineCounter++];
			ride.mustStart = lineInts[lineCounter++];
			ride.mustFinish = lineInts[lineCounter++];
			ride.index = i;
			
			//if (i == 0)System.out.printf("Ride (startRow, startCol), (endRow, endCol): (%d, %d), (%d, %d)%n",
				//ride.startRow, ride.startCol, ride.destRow, ride.destCol);
		}
		
		in.close();
		
		// start the simulation
		Simulation sim = new Simulation(rows, cols, numVehicles, numRides, bonus, totalSteps, rides);
		sim.startSimulation();
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
