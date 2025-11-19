
package services;

import java.util.ArrayList;
import java.util.List;

import parking.Floor;
import parking.ParkingLot;
import parking.spots.ElectricSpot;
import parking.spots.ParkingSpot;
import parking.spots.ParkingStatus;

public class Violation {
    private final ParkingLot parkingLot;

    public Violation(ParkingLot lot) {
        this.parkingLot = lot;
    }

    // According to the class diagram
    public List<Integer> checkTowSpots() {
        List<Integer> towSpots = new ArrayList<>();
        for (Floor f : parkingLot.getFloors()) {
            for (ParkingSpot s : f.getSpots()) {
                if (s.getParkingStatus() == ParkingStatus.TAKEN && s.getVehicle() != null) {
                    if (s.getVehicle().towable()) {
                        towSpots.add(s.getSpotNumber());
                    }
                }
            }
        }
        return towSpots;
    }

    public List<Integer> checkChargingSpots() {
        List<Integer> chargingSpots = new ArrayList<>();
        for (Floor f : parkingLot.getFloors()) {
            for (ParkingSpot s : f.getSpots()) {
                if (s instanceof ElectricSpot && s.getParkingStatus() == ParkingStatus.TAKEN) {
                    chargingSpots.add(s.getSpotNumber());
                }
            }
        }
        return chargingSpots;
    }

    public List<Integer> checkDoubleParkingSpots() {
        // simplified: check for spots with wrong vehicle type
        List<Integer> doubleParked = new ArrayList<>();
        for (Floor f : parkingLot.getFloors()) {
            for (ParkingSpot s : f.getSpots()) {
                if (s.getParkingStatus() == ParkingStatus.TAKEN && s.getVehicle() != null) {
                    if (!s.canFit(s.getVehicle())) {
                        doubleParked.add(s.getSpotNumber());
                    }
                }
            }
        }
        return doubleParked;
    }
}
