package parking.spots;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class BusSpot extends ParkingSpot {
    public BusSpot(int spotNumber) { super(spotNumber); }

    @Override
    public boolean canFit(Vehicle v) {
        return v.getType() == VehicleType.BUS;
    }
}
