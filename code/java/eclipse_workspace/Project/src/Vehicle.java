
public class Vehicle {
	public int row, col;
	public int destRow, destCol;
	public boolean occupied;
	
	
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
		if (occupied) {
			if (row == destRow && col == destCol) {
				occupied = false;
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
		destRow = ride.destRow;
		destCol = ride.destCol;
		occupied = true;
	}
	
}
