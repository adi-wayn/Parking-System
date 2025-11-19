package parking.spots;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(int spotNumber) { super(spotNumber); }

    @Override
    public boolean canFit(Vehicle v) {
        return v.getType() == VehicleType.HANDICAPPED;
    }
}