package parking.spots;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class StandardSpot extends ParkingSpot {
    public StandardSpot(int spotNumber) { super(spotNumber); }

    @Override
    public boolean canFit(Vehicle v) {
        return v.getType() == VehicleType.CAR || v.getType() == VehicleType.ELECTRIC;
    }
}