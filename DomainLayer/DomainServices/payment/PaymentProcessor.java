package services.payment;
import tickets.TicketStatus;

public interface PaymentProcessor {
    boolean pay(int amount);
    boolean cancel(String transactionId);
    TicketStatus status(String transactionId);
}