package gates;

import java.util.List;

import sensors.Camera;
import sensors.Sensor;
import vehicles.Vehicle;

public abstract class Gate {
    protected final String gateId;
    protected final Camera camera;
    protected final List<Sensor> sensors;

    public Gate(String gateId, Camera camera, List<Sensor> sensors) {
        this.gateId = gateId;
        this.camera = camera;
        this.sensors = sensors;
    }

    public String getGateId() { return gateId; }

     public String readPlate(Vehicle v) {
        return camera.scan(v);
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    protected void openGate() {
        System.out.println("Gate " + gateId + " opened.");
    }
}