
package services;

public class Charging {
    private final int price; // cents per hour
    private final int chargeTime; // in minutes
    private int currentChargeTime = 0;
    private boolean charging = false;

    public ChargingFee(int price, int chargeTime) {
        this.price = price;
        this.chargeTime = chargeTime;
    }

    public int getPrice() { return price; }
    public int getChargeTime() { return chargeTime; }

    public int calculate() {
        return (chargeTime * price) / 60; // price per minute
    }

    public void charge(int hours, int minutes, int ticketID) {
        currentChargeTime = hours * 60 + minutes;
    }

    public void fullCharge(int ticketID) {
        currentChargeTime = chargeTime;
    }

    public void startCharging(int ticketID) {
        charging = true;
    }

    public void stopCharging() {
        charging = false;
    }

    public boolean isFinished() {
        return currentChargeTime >= chargeTime;
    }
}
