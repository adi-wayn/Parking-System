import java.util.ArrayList;
import java.util.List;

import customers.MonthlySub;
import parking.ParkingLot;
import parking.spots.ParkingSpot;
import services.Allocation;
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

    public ParkingSpot allocateSpot(String subId, String lotId) {

    MonthlySub sub = customers.get(subId);
    ParkingLot lot = getParkingLot(lotId);

    Allocation allocationService = services.getAllocationService();

    return allocationService.allocate(sub, lot);
}


    
}
