package vehicles;
public class ElectricCar extends Vehicle implements Chargeable {
    public ElectricCar(String plate) { super(plate, VehicleType.ELECTRIC); }

    @Override
    public boolean isChargeable() {
        return true;
    }   
}
