package parking;

import java.util.ArrayList;
import java.util.List;

import iterators.ParkingSpotIterator;
import iterators.SpotIterator;
import parking.spots.ParkingSpot;

public class ParkingSpotCollection implements Iterable<ParkingSpot> {

    private List<ParkingSpot> spots = new ArrayList<>();

    public void addSpot(ParkingSpot spot) {
        if (spot != null) {
            spots.add(spot);
        }
    }

    @Override
    public ParkingSpotIterator iterator() {
        return new SpotIterator(spots);
    }
}