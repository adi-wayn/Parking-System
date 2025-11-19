package tickets;
import parking.ParkingLot;

public class ReportGenerator {
    public static String summary(ParkingLot lot) {
        StringBuilder sb = new StringBuilder();
        sb.append("Total history tickets: ").append(lot.getHistory().size()).append('\n');
        int revenue = lot.getHistory().stream().mapToInt(t -> t.totalCharges()).sum();
        sb.append("Total revenue (charges sum): ").append(revenue).append('\n');
        long paid = lot.getHistory().stream().filter(t -> t.getStatus() == TicketStatus.PAID).count();
        sb.append("Paid tickets: ").append(paid).append('\n');
        return sb.toString();
    }
}
