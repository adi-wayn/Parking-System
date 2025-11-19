package customers;
public class MonthlySub {
    private final String plate;
    private final int monthlyFee; // cents
    private boolean active = true;

    public MonthlySub(String plate, int fee) {
        this.plate = plate;
        this.monthlyFee = fee;
    }

    public String getPlate() { return plate; }
    public int getMonthlyFee() { return monthlyFee; }
    public boolean isActive() { return active; }
    public void cancel() { active = false; }
}
