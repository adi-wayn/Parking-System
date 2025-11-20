package gates;
import ParkingSystemManager;

import tickets.Ticket;

public class EntryGate extends Gate {

    public EntryGate(String id) {
        super(id);
    }

    public Ticket enter(Vehicle v, String lotId) {
        return ParkingSystemManager.getInstance().handleEntry(v, lotId, this);
    }
}