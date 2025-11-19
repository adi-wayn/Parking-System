package services.payment;

public class Charge {
    private final ChargeType type;
    private final int amount; // in cents or smallest currency unit

    public Charge(ChargeType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ChargeType getType() { return type; }
    public int getAmount() { return amount; }
}
