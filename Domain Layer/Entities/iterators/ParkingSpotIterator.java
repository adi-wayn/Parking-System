package iterators;
import java.util.Iterator;

import parking.spots.ParkingSpot;

public interface ParkingSpotIterator extends Iterator<ParkingSpot> {
	boolean hasNext();
	ParkingSpot next();
}
