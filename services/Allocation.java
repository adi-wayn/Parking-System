
package services;

import customers.MonthlySub;
import parking.spots.ParkingSpot;
import vehicles.Vehicle;

public class Allocation {
    private final MonthlySub sub;

    public Allocation(MonthlySub sub) {
        this.sub = sub;
    }

    public MonthlySub getSub() { return sub; }

    public java.util.List<ParkingSpot> allocate(java.util.List<Vehicle> vehicles) {
        java.util.List<ParkingSpot> allocated = new java.util.ArrayList<>();
        for (Vehicle v : vehicles) {
            // simplified allocation: just return empty for now
        }
        return allocated;
    }
}
