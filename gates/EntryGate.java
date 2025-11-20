package gates;
import java.util.List;

import ParkingSystemManager;
import sensors.Camera;
import tickets.Ticket;

public class EntryGate extends Gate {

    public EntryGate(String id, Camera camera, List<Sensor> sensors) {
        super(id, camera, sensors);
    }

    public Ticket enter(String lotId) {

        String plate = readPlate();

        return ParkingSystemManager
                .getInstance()
                .handleEntry(plate, lotId, this);
    }
}