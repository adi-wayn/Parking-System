import java.time.LocalDateTime;
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

    public Ticket processEntry(Vehicle v, String lotId, Gate gate) {

        Services svc = services;

        // 1) בדיקות אבטחה
        if (!svc.getSecurity().authorizeEntry(v)) {
            return null;
        }

        ParkingLot lot = getParkingLot(lotId);

        // 2) אין מקום → רשימת המתנה
        if (!lot.hasSpace()) {
            svc.getWaitingList().enqueue(v, lot);
            return null;
        }

        // 3) יצירת כרטיס
        Ticket t = new Ticket(v.getPlate(), v.getType());
        lot.addActiveTicket(t);

        // 4) הקצאה
        svc.getAllocation().allocate(v, lot, t);

        // 5) פתיחת שער
        gate.openGate();

        return t;
    }

    public boolean processExit(Ticket t, Gate gate) {

        Services svc = services;
        t.setExitTime(LocalDateTime.now());

        int amount = t.totalCharges();
        boolean paid = svc.getPayment().pay(amount);

        if (!paid) {
            svc.getSecurity().blacklist(t.getPlate());
            return false;
        }

        t.setPaid();
        gate.openGate();

        return true;
    }

    public int calculatePayment(Ticket ticket) {
        if (ticket == null || services == null || services.getPayment() == null) {
            return 0;
        }
        return services.getPayment().calculate(ticket);
    }
}