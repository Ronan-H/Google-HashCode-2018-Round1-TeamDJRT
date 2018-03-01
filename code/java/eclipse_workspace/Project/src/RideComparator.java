import java.util.Comparator;

public class RideComparator implements Comparator<Ride> {
	
	@Override
	public int compare(Ride r1, Ride r2) {
		return r1.mustStart - r2.mustStart;
	}
	
}
