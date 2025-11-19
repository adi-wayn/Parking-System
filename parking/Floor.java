package parking;
import java.util.ArrayList;
import java.util.List;

import iterators.ParkingSpotIterator;
import iterators.ParkingSpotIteratorImpl;
import parking.spots.ParkingSpot;
import parking.spots.ParkingStatus;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class Floor {
    private final int floorNum;
    private ParkingSpotCollection spotCollection = new ParkingSpotCollection();

    public Floor(int floorNum) {
        this.floorNum = floorNum;
    }

    public void addSpot(ParkingSpot s) { spotCollection.addSpot(s); }

    public boolean isFull() {
        return spotCollection.stream().allMatch(s -> s.getParkingStatus() == ParkingStatus.TAKEN);
    }

    public ParkingSpotCollection getSpots() {
        return spotCollection;
    }

    public ParkingSpot findSpot(VehicleType type) {
        return spotCollection.stream().filter(s -> s.getParkingStatus() == ParkingStatus.FREE && s.canFit(new SimpleVehicle(type))).findFirst().orElse(null);
    }
}
