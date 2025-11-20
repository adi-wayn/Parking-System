package parking.spots;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class ElectricSpot extends ParkingSpot {
    public ElectricSpot(int spotNumber) { super(spotNumber); }

    @Override
    public boolean canFit(Vehicle v) {
        return v.getType() == VehicleType.ELECTRIC;
    }
}
