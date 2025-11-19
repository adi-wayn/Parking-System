import gates.Gate;
import parking.Floor;
import parking.ParkingLot;
import parking.spots.BusSpot;
import parking.spots.ElectricSpot;
import parking.spots.HandicappedSpot;
import parking.spots.MotorcycleSpot;
import parking.spots.StandardSpot;
import services.Services;
import services.payment.PaymentAdapter;
import services.payment.PaymentProcessor;
import services.payment.PaymentService;
import tickets.ReportGenerator;
import tickets.Ticket;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        Floor floor0 = new Floor(0);
        floor0.addSpot(new StandardSpot(1));
        floor0.addSpot(new MotorcycleSpot(2));
        floor0.addSpot(new ElectricSpot(3));
        floor0.addSpot(new HandicappedSpot(4));
        floor0.addSpot(new BusSpot(5));
        lot.addFloor(floor0);

        Gate gate = new Gate();
        PaymentProcessor payProc = new PaymentAdapter();

        Vehicle v1 = new Car("ABC-123");
        Ticket t1 = gate.open(v1, lot);
        System.out.println("Vehicle entered: " + v1.getPlate() + " ticketId=" + (t1 != null ? t1.getId() : "-"));

        Vehicle v2 = new Motorcycle("MOTO-1");
        Ticket t2 = gate.open(v2, lot);
        System.out.println("Vehicle entered: " + v2.getPlate() + " ticketId=" + (t2 != null ? t2.getId() : "-"));

        // Simulate payment and exit for v1
        PaymentService paymentService = new PaymentService();
        boolean exited = gate.exit("ABC-123", lot, payProc, paymentService);
        System.out.println("Exit for ABC-123 successful=" + exited);

        System.out.println("Pending tickets for ABC-123: " + lot.getPendingTickets("ABC-123").size());
        System.out.println("History (should be 1): " + lot.getHistory().size());

        System.out.println("Report:\n" + ReportGenerator.summary(lot));
    }
}
