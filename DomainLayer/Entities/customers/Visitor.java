package customers;
import java.util.ArrayList;
import java.util.List;
import vehicles.Vehicle;

public class Visitor extends Customer {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public Visitor(String phone) {
        super(phone);
    }

    @Override
    public void subscribe(List<CreditCard> cards, List<Vehicle> vList) {
        vehicles.addAll(vList);
    }

    public List<Vehicle> getVehicles() { return vehicles; }
}
