package customers;

import vehicles.Vehicle;

public abstract class Customer {
    protected final String phone;

    public Customer(String phone) {
        this.phone = phone;
    }

    public String getPhone() { return phone; }

    public abstract void subscribe(java.util.List<CreditCard> cards, java.util.List<Vehicle> vehicles);
}
