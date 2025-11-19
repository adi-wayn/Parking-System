package vehicles;
public abstract class Vehicle {
	private final String plate;
	private final VehicleType type;

	public Vehicle(String plate, VehicleType type) {
		this.plate = plate;
		this.type = type;
	}

	public String getPlate() {
		return plate;
	}

	public VehicleType getType() {
		return type;
	}

	public boolean towable() {
		return true;
	}
}
