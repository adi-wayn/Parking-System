package sensors;
import vehicles.Vehicle;

public class Camera {
    public String scan(Vehicle v) {
        return v.getPlate();
    }
}
