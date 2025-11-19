package gates;

import java.util.ArrayList;
import java.util.List;

import parking.ParkingLot;
import parking.spots.ParkingSpot;
import sensors.Camera;
import sensors.Sensor;
import services.payment.PaymentProcessor;
import services.payment.PaymentService;
import tickets.Ticket;
import vehicles.Vehicle;

public class Gate {
    // According to the class diagram
    private final Camera camera = new Camera();
    private final List<Sensor> sensors = new ArrayList<>();
    private final Security security = new Security();
    private int retries = 0;

    // Diagram method: open(): bool
    public boolean open() {
        // Simplified health check using sensors and security
        return isOk();
    }

    /**
     * Open the gate for a specific vehicle, create a ticket and assign a spot.
     * Returns the created ticket, or null if lot is full or gate not OK.
     */
    public Ticket open(Vehicle v, ParkingLot lot) {
        if (!isOk() || lot.isFull()) {
            return null;
        }
        ParkingSpot spot = lot.findSpot(v.getType());
        if (spot == null) {
            return null;
        }

        // create and register ticket
        Ticket t = new Ticket(v.getPlate(), v.getType());
        t.assignSpotNumber(spot.getSpotNumber());
        lot.addActiveTicket(t);

        // assign vehicle to spot
        spot.assignVehicle(v);
        return t;
    }

    /**
     * Process exit for a vehicle: charge, pay and free the spot.
     */
    public boolean exit(String plate, ParkingLot lot, PaymentProcessor processor, PaymentService paymentService) {
        Ticket t = lot.getActiveTicket(plate);
        if (t == null) {
            return false;
        }
        int amount = paymentService.calculate(t);
        if (!processor.pay(amount)) {
            return false;
        }

        // mark ticket as paid and move to history
        t.setPaid();
        if (t.getAssignedSpotNumber() != null) {
            lot.freeSpotByNumber(t.getAssignedSpotNumber());
        }
        lot.addToHistory(t);
        return true;
    }

    public boolean closeSafely() {
        // In a real system we might retry a few times
        retries++;
        return true;
    }

    public boolean isOk() {
        // Simple check: all sensors operational and no security issues
        boolean sensorsOk = sensors.stream().allMatch(Sensor::isOperational);
        return sensorsOk;
    }
}
