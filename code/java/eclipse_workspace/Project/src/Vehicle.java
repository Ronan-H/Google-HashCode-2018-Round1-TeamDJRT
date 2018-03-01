
public class Vehicle {
	public int row, col;
	public int destRow, destCol;
	public boolean occupied;
	boolean reachedRideStart;
	private Ride currentRide;
	
	public Vehicle()
	{
		this.row=0;
		this.col=0;
	}
	
	public void Vehicle(int row, int col)
	{
		this.row=row;
		this.col=col;
	}
	
	public void tick() {
		if (currentRide != null && currentRide.index == 1) {
			//System.out.printf("(row, col): (%d, %d)%n", row, col);
		}
		
		if (occupied) {
			if (row == destRow && col == destCol) {
				if (reachedRideStart) {
					occupied = false;
				}
				else {
					reachedRideStart = true;
					
					destRow = currentRide.destRow;
					destCol = currentRide.destCol;
				}
			}
			else {
				// make way towards destination
				if (row != destRow) {
					if (row < destRow)
						++row;
					else
						--row;
				}
				else {
					// col != destCol
					if (col < destCol)
						++col;
					else
						--col;
				}
			}
		}
	}
	
	public void doRide(Ride ride) {
		destRow = ride.startRow;
		destCol = ride.startCol;
		occupied = true;
		reachedRideStart = false;
		currentRide = ride;
	}
	
}
