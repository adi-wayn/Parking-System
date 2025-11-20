package services.payment;

public class ChargeFee {
    private final ChargeFeeType type;
    private final int amount; // in cents or smallest currency unit

    public ChargeFee(ChargeFeeType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ChargeFeeType getType() { return type; }
    public int getAmount() { return amount; }
}