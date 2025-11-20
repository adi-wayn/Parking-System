package iterators;
import java.util.List;
import java.util.NoSuchElementException;

import parking.spots.HandicappedSpot;
import parking.spots.ParkingSpot;

public class HandicappedSpotIterator implements ParkingSpotIterator {

    private List<ParkingSpot> spots;
    private int index = 0;

    public HandicappedSpotIterator(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    @Override
    public boolean hasNext() {
        while (index < spots.size()) {
            if (spots.get(index) instanceof HandicappedSpot) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public ParkingSpot next() {
        if (!hasNext()) throw new NoSuchElementException();
        return spots.get(index++);
    }
}