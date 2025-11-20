package sensors;
public class Sensor {
    private final int sensorId;
    private final String sensorType; // e.g., "motion", "occupancy"
    private boolean operational = true;

    public Sensor(int sensorId, String sensorType) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
    }

    public int getSensorId() { return sensorId; }
    public String getSensorType() { return sensorType; }
    public boolean isOperational() { return operational; }
    public void setOperational(boolean op) { this.operational = op; }
}