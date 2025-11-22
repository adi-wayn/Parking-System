package gates;
import java.util.List;

import ParkingSystemManager;
import sensors.Camera;

public class ExitGate extends Gate {

    public ExitGate(String id, Camera camera, List<Sensor> sensors) {
        super(id, camera, sensors);
    }

    public boolean exit() {
        String plate = readPlate();
        return ParkingSystemManager
                .getInstance()
                .handleExit(plate, this);
    }
}