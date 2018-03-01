
public class Ride {
	int startRow, startCol;
	int destRow, destCol;
	// Times at which the ride must start/finish by
	int mustStart, mustFinish;
	
	//Distance between
	public int getDistance(int currA, int currB, int startA, int startB)
	{
		int distance;
		distance = (currA-startA)+(currB-startB) ;
		return distance;
	}
	
	//Check Distance
	public boolean checkDistance(int distance, int startA, int startB, int finA, int finB, int turn, int lateFin)
	{
		boolean doIt = false;
		int totalDist;
		
		totalDist =distance + (startA - finA) + (startB - finB);
		
		if(turn + totalDist > lateFin)
		{
			doIt = false;
		}
		else
			doIt = true;
		
		return doIt;
	}
}
