package iterators;
import java.util.List;
import java.util.NoSuchElementException;

import parking.spots.ParkingSpot;

public class ParkingSpotIteratorImpl implements ParkingSpotIterator {
    private final List<ParkingSpot> spots;
    private int idx = 0;

    public ParkingSpotIteratorImpl(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    @Override
    public boolean hasNext() {
        return idx < spots.size();
    }

    @Override
    public ParkingSpot next() {
        if (!hasNext()) throw new NoSuchElementException();
        return spots.get(idx++);
    }
}