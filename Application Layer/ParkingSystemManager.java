package ApplicationLayer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DomainLayer.Entities.Customer;
import DomainLayer.Entities.MonthlySub;
import DomainLayer.Entities.ParkingLot;
import DomainLayer.Entities.ParkingSpot;
import DomainLayer.Entities.Ticket;
import DomainLayer.Entities.Vehicle;
import DomainLayer.Entities.Gate;

import DomainLayer.Services.Services;

/**
 * Singleton – ParkingSystemManager
 */
public class ParkingSystemManager {

    private static ParkingSystemManager instance = null;

    private final List<ParkingLot> parkingLots = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    private Services services;

    private ParkingSystemManager() {}

    public static synchronized ParkingSystemManager getInstance() {
        if (instance == null) {
            instance = new ParkingSystemManager();
        }
        return instance;
    }

    // -------------------------------
    // Parking Lots
    // -------------------------------

    public void registerParkingLot(ParkingLot lot) {
        if (lot != null && !parkingLots.contains(lot)) {
            parkingLots.add(lot);
        }
    }

    public boolean removeParkingLot(ParkingLot lot) {
        return parkingLots.remove(lot);
    }

    public ParkingLot getParkingLot(String lotId) {
        for (ParkingLot lot : parkingLots) {
            if (lot.getId().equals(lotId)) {
                return lot;
            }
        }
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    // -------------------------------
    // Services (Domain Services Layer)
    // -------------------------------

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    // -------------------------------
    // Customers / Subscribers
    // -------------------------------

    public void registerSubscriber(MonthlySub sub) {
        if (sub != null && !customers.contains(sub)) {
            customers.add(sub);
        }
    }

    public MonthlySub getSubscriber(String plate) {
        for (Customer c : customers) {
            if (c instanceof MonthlySub sub) {
                if (sub.getPlateNumbers().contains(plate))
                    return sub;
            }
        }
        return null;
    }

    public boolean isSubscriberActive(String plate) {
        MonthlySub sub = getSubscriber(plate);
        return (sub != null && sub.isActive());
    }

    public void registerCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public Customer getCustomer(int id) {
        for (Customer c : customers) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public boolean isSubscriber(int id) {
        Customer c = getCustomer(id);
        return (c instanceof MonthlySub);
    }

    // -------------------------------
    // Allocation
    // -------------------------------

    public ParkingSpot allocateSpot(String subId, String lotId) {
        MonthlySub sub = getCustomerBySubId(subId);
        ParkingLot lot = getParkingLot(lotId);
        if (sub == null || lot == null) return null;

        return services.getAllocation().allocate(sub, lot);
    }

    private MonthlySub getCustomerBySubId(String subId) {
        for (Customer c : customers) {
            if (c instanceof MonthlySub sub) {
                if (sub.getSubscriptionId().equals(subId)) {
                    return sub;
                }
            }
        }
        return null;
    }

    // -------------------------------
    // Entry Processing
    // -------------------------------

    public Ticket processEntry(Vehicle v, String lotId, Gate gate) {

        Services svc = services;

        // 1. Security checks
        if (!svc.getSecurity().authorizeEntry(v)) {
            return null;
        }

        ParkingLot lot = getParkingLot(lotId);

        if (lot == null) return null;

        // 2. No space available → waiting list
        if (!lot.hasSpace()) {
            svc.getWaitingList().enqueue(v, lot);
            return null;
        }

        // 3. Create ticket
        Ticket t = new Ticket(v.getPlate(), v.getType());
        lot.addActiveTicket(t);

        // 4. Allocation
        svc.getAllocation().allocate(v, lot, t);

        // 5. Open gate
        gate.openGate();

        return t;
    }

    // -------------------------------
    // Exit Processing
    // -------------------------------

    public boolean processExit(Ticket t, Gate gate) {

        Services svc = services;

        t.setExitTime(LocalDateTime.now());

        int amount = t.totalCharges();
        boolean paid = svc.getPayment().pay(amount);

        if (!paid) {
            svc.getSecurity().insertBlacklist(t.getPlate());
            return false;
        }

        t.setPaid();
        gate.openGate();
        return true;
    }

    // -------------------------------
    // Payment
    // -------------------------------

    public int calculatePayment(Ticket ticket) {
        if (ticket == null || services == null || services.getPayment() == null) {
            return 0;
        }
        return services.getPayment().calculate(ticket);
    }

    // -------------------------------
    // Spot Scanning (Iterator Pattern)
    // -------------------------------

    public ParkingScanReport scanAllParkingSpots() {
        return services.getAllocation().scanAll();
    }
}