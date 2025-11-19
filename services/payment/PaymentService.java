package services.payment;
import tickets.Ticket;

public class PaymentService {
    public int calculate(Ticket t) {
        // simple flat rate + additional charges
        int base = 50; // cents
        return base + t.totalCharges();
    }
}
