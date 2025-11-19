package gates;
import services.payment.PaymentService;
import tickets.Ticket;
import vehicles.VehicleType;

public class Entry {
    private final WaitingList waitingList;
    private final PaymentService paymentService;

    public Entry(WaitingList waitingList, PaymentService paymentService) {
        this.waitingList = waitingList;
        this.paymentService = paymentService;
    }

    public WaitingList getWaitingList() { return waitingList; }

    public Ticket createTicket(String plate, VehicleType type) {
        return new Ticket(plate, type);
    }
}
