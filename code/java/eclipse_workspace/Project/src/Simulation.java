import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simulation {
	private int rows, cols;
	private int numVehicles;
	private int numRides;
	private int bonus;
	private int totalSteps;
	private List<Ride> rides;
	
	private Vehicle[] vehicles;
	private int currentStep;
	private List<Ride> availableRides;
	
	public Simulation(int rows, int cols, int numVehicles, int numRides, int bonus, int totalSteps, Ride[] rides) {
		this.rows = rows;
		this.cols = cols;
		this.numVehicles = numVehicles;
		this.numRides = numRides;
		this.bonus = bonus;
		this.totalSteps = totalSteps;
		
		// sort rides by their start time
		this.rides = new ArrayList<>(Arrays.asList(rides));
		this.rides.sort(new RideComparator());
		
		// init vehicles
		vehicles = new Vehicle[numVehicles];
		
		for (int i = 0; i < numVehicles; ++i) {
			vehicles[i] = new Vehicle();
		}
		availableRides = new ArrayList<Ride>();
		
		currentStep = 0;
	}
	
	public void startSimulation() {
		int i, j, k;
		for (currentStep = 0; currentStep <= totalSteps; ++currentStep) {
			// assign all free vehicles to any rides they can complete right now
			
			// update availableRides
			for (i = 0; i < availableRides.size(); ++i) {
				if (currentStep > availableRides.get(i).mustFinish) {
					availableRides.remove(i);
					--i;
				}
			}
			
			for (i = 0; i < rides.size(); ++i) {
				Ride ride = rides.get(i);
				if (currentStep >= ride.mustStart && currentStep < ride.mustFinish) {
					availableRides.add(rides.remove(i));
					--i;
				}
			}
		}
	}
	
}
