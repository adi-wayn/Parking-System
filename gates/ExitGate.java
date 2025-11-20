package gates;
import ParkingSystemManager;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }

    public boolean exit(Ticket t) {
        return ParkingSystemManager.getInstance().handleExit(t, this);
    }
}