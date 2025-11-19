package iterators;
import parking.spots.ParkingSpot;

public interface ParkingSpotIterator {
	boolean hasNext();
	ParkingSpot next();
}
