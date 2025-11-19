package services;

import customers.MonthlySub;
import parking.ParkingLot;
import parking.spots.ParkingSpot;
import parking.spots.ParkingStatus;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Allocation {

    /**
     * Allocate one parking spot per vehicle belonging to the subscriber.
     * ParkingLot handles only the physical spot status.
     * Services layer handles the business logic.
     */
    public List<ParkingSpot> allocate(MonthlySub sub, ParkingLot lot) {

        List<ParkingSpot> allocated = new ArrayList<>();

        for (Vehicle v : sub.getVehicles()) {

            // 1. Find a free spot in this lot for the vehicle's type
            ParkingSpot spot = lot.findSpot(v.getType());

            if (spot == null) {
                // Not enough spots: you decide if to rollback or partial-allocate
                continue;
            }

            // 2. Mark the spot as ALLOCATED at the lot level
            spot.setStatus(ParkingStatus.ALLOCATED);

            // 3. Link the vehicle to the spot if you want (optional)
            spot.assignVehicle(v);

            allocated.add(spot);
        }

        return allocated;
    }
}