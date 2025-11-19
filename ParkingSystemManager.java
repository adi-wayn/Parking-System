import java.util.ArrayList;
import java.util.List;

import customers.Customer;
import customers.MonthlySub;
import gates.Gate;
import parking.ParkingLot;
import parking.spots.ParkingSpot;
import services.Services;
import services.payment.PaymentProcessor;
import tickets.Ticket;
import vehicles.Vehicle;

public class ParkingSystemManager {
    private static ParkingSystemManager instance = null;

    private final List<ParkingLot> parkingLots = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
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
        if (lot != null && !parkingLots.contains(lot)) {
            parkingLots.add(lot);
        }
    }

    public boolean removeParkingLot(ParkingLot lot) {
        return parkingLots.remove(lot);
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void registerSubscriber(MonthlySub sub) {
        
    }

    public MonthlySub getSubscriber(String plate) {
        //TODO implement
        return null;
    }

    public boolean isSubscriberActive(String plate) {
        //TODO implement
        return false;
    }

    public ParkingSpot allocateSpot(String subId, String lotId) {
        //TODO implement
        return null;
    }

    public Ticket processEntry(Gate gate, ParkingLot lot, Vehicle vehicle) {
        if (gate == null || lot == null || vehicle == null) {
            return null;
        }
        return gate.open(vehicle, lot);
    }

    public boolean processExit(Gate gate,
                               ParkingLot lot,
                               String plate,
                               PaymentProcessor processor) {
        if (gate == null || lot == null || plate == null || processor == null) {
            return false;
        }
        if (services == null || services.getPayment() == null) {
            return false;
        }
        return gate.exit(plate, lot, processor, services.getPayment());
    }

    public int calculatePayment(Ticket ticket) {
        if (ticket == null || services == null || services.getPayment() == null) {
            return 0;
        }
        return services.getPayment().calculate(ticket);
    }
}
