package gates;

import parking.ParkingLot;
import services.payment.PaymentService;
import tickets.Ticket;
import tickets.TicketStatus;

public class Exit {
    private final PaymentService paymentService;

    public Exit(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean canExit(String plate, ParkingLot lot) {
        Ticket t = lot.getActiveTicket(plate);
        return t != null && t.getStatus() == TicketStatus.PAID;
    }
}
