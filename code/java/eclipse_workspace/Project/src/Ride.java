
public class Ride {
	int startRow, startCol;
	int destRow, destCol;
	// Times at which the ride must start/finish by
	int mustStart, mustFinish;
	public int index;
	
	//Distance between
	public int getDistanceTo(Vehicle vehicle)
	{
		return Math.abs(vehicle.row-startRow)+Math.abs(vehicle.col-startCol);
	}
	
	public int getRouteDist(Vehicle vehicle)
	{
		int totalDist;
		int distance;
		
		distance = getDistanceTo(vehicle);
		
		totalDist = distance + Math.abs(startRow - destRow) + Math.abs(startCol - destCol);
		
		return totalDist;
	}
	
	//Check Distance
	public boolean canCompleteRide(Vehicle vehicle, int currentStep)
	{
		return (currentStep + getRouteDist(vehicle)) <= mustFinish;
	}
	
	
}
