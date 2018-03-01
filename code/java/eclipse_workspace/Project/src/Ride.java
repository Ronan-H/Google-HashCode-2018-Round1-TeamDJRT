
public class Ride {
	int startRow, startCol;
	int destRow, destCol;
	// Times at which the ride must start/finish by
	int mustStart, mustFinish;
	public int index;
	//Distance between
	public int getDistance(Vehicle vehicle, int distance)
	{
		distance = Math.abs(vehicle.row-startRow)+Math.abs(vehicle.col-startCol) ;
		return distance;
	}
	
	//Check Distance
	public boolean checkDistance(Vehicle vehicle, int turn)
	{
		boolean doIt = false;
		int totalDist;
		int distance = 0;
		
		getDistance(vehicle, distance);
		
		totalDist = distance + (startRow - destRow) + (startCol - destCol);
		
		if(turn + totalDist > mustFinish)
		{
			doIt = false;
		}
		else
			doIt = true;
		
		return doIt;
	}
}
