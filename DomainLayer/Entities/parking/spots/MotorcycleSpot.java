package parking.spots;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot(int spotNumber) { super(spotNumber); }

    @Override
    public boolean canFit(Vehicle v) {
        return v.getType() == VehicleType.MOTORCYCLE;
    }
}
