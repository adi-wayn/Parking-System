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
    final List<ParkingSpot> spots = new ArrayList<>();

    public Floor(int floorNum) {
        this.floorNum = floorNum;
    }

    public void addSpot(ParkingSpot s) { spots.add(s); }

    public boolean isFull() {
        return spots.stream().allMatch(s -> s.getParkingStatus() == ParkingStatus.TAKEN);
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public ParkingSpot findSpot(VehicleType type) {
        return spots.stream().filter(s -> s.getParkingStatus() == ParkingStatus.FREE && s.canFit(new SimpleVehicle(type))).findFirst().orElse(null);
    }

    public ParkingSpotIterator iterator() {
        return new ParkingSpotIteratorImpl(spots);
    }
}

// small helper vehicle used for matching only
class SimpleVehicle extends Vehicle {
    public SimpleVehicle(VehicleType t) { super("-", t); }
}
