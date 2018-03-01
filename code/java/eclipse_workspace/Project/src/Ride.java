
public class Ride {
	int startRow, startCol;
	int destRow, destCol;
	int currRow, currCol;
	// Times at which the ride must start/finish by
	int mustStart, mustFinish;
	public int index;
	//Distance between
	public int getDistance(Vehicle vehicle)
	{
		//Start row + col are where it currently is 
		//dest row + col where the next ride will start
		int distance;
		distance = java.lang.Math.abs(currRow-startRow)+java.lang.Math.abs(currCol-startCol) ;
		return distance;
	}
	
	//Check Distance
	public boolean checkDistance(Vehicle vehicle, int distance, int turn, int lateFin)
	{
		boolean doIt = false;
		int totalDist;
		
		totalDist = distance + (startRow - destRow) + (startCol - destCol);
		
		if(turn + totalDist > lateFin)
		{
			doIt = false;
		}
		else
			doIt = true;
		
		return doIt;
	}
}
