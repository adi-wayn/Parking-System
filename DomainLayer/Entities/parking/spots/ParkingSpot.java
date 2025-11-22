package parking.spots;
import vehicles.Vehicle;

public abstract class ParkingSpot {
    protected final int spotNumber;
    protected ParkingStatus parkingStatus = ParkingStatus.FREE;
    protected Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getSpotNumber() { return spotNumber; }

    public ParkingStatus getParkingStatus() { return parkingStatus; }

    public void setParkingStatus(ParkingStatus s) { this.parkingStatus = s; }

    public Vehicle getVehicle() { return vehicle; }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.parkingStatus = ParkingStatus.TAKEN;
    }

    public void freeSpot() {
        this.vehicle = null;
        this.parkingStatus = ParkingStatus.FREE;
    }

    public abstract boolean canFit(Vehicle v);
    public boolean isOk() { return parkingStatus != ParkingStatus.MALFUNCTION; }
}
