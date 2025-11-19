package tickets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import services.payment.Charge;
import vehicles.VehicleType;

public class Ticket {
    private static int counter = 1;
    private final int id;
    private final String plate;
    private final VehicleType type;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private final List<Charge> additionalCharges = new ArrayList<>();
    private Integer assignedSpotNumber = null;

    public Ticket(String plate, VehicleType type) {
        this.id = counter++;
        this.plate = plate;
        this.type = type;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.PENDING;
    }

    public int getId() { return id; }
    public String getPlate() { return plate; }
    public VehicleType getType() { return type; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public TicketStatus getStatus() { return status; }
    public List<Charge> getAdditionalCharges() { return additionalCharges; }
    public Integer getAssignedSpotNumber() { return assignedSpotNumber; }

    public void setExitTime(LocalDateTime t) { this.exitTime = t; }

    public void addCharge(Charge c) { additionalCharges.add(c); }

    public int totalCharges() {
        int sum = 0;
        for (Charge c : additionalCharges) sum += c.getAmount();
        return sum;
    }

    public boolean setPaid() {
        this.status = TicketStatus.PAID;
        return true;
    }

    public void assignSpotNumber(int n) { this.assignedSpotNumber = n; }
}
