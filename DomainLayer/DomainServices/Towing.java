package services;

import vehicles.Vehicle;

public class Towing {
    public boolean tow(Vehicle v) {
        // simulate towing
        System.out.println("Towing vehicle: " + v.getPlate());
        return true;
    }
}
