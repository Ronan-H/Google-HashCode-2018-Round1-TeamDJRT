
public class Ride {
	int startRow, startCol;
	int destRow, destCol;
	// Times at which the ride must start/finish by
	int mustStart, mustFinish;
	public int index;
	//Distance between
	public int getDistance(Vehicle vehicle, int distance)
	{
		distance = Math.abs(vehicle.row-startRow)+Math.abs(vehicle.col-startCol);
		return distance;
	}
	
	//Check Distance
	public boolean checkDistance(Vehicle vehicle, int turn)
	{
		int totalDist;
		int distance = 0;
		
		distance = getDistance(vehicle, distance);
		
		totalDist = distance + Math.abs(startRow - destRow) + Math.abs(startCol - destCol);
		
		return turn + totalDist < mustFinish + 1;
	}
}
