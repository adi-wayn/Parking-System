import java.util.ArrayList;
import java.util.List;

import parking.ParkingLot;
import services.Services;

public class ParkingSystemManager {
    private static ParkingSystemManager instance = null;

    private List<ParkingLot> parkingLots = new ArrayList<>();
    private Services services;


    private ParkingSystemManager() {
        // Private constructor to prevent instantiation
    }

    synchronized public static ParkingSystemManager getInstance() {
        if (instance == null) {
            instance = new ParkingSystemManager();
        }
        return instance;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void addParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    
}
