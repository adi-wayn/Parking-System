package services.payment;

import tickets.TicketStatus;

public class PaymentAdapter implements PaymentProcessor {
	private final PaymentAPI api;

	public PaymentAdapter(PaymentAPI api) {
        this.api = api;
    }

    @Override
    public boolean pay(int amount) {
        String tx = api.makeCharge((double) amount);
        return tx != null;
    }

    @Override
    public boolean cancel(String transactionId) {
        return api.abortCharge(transactionId);
    }

    @Override
    public TicketStatus status(String transactionId) {
        int s = api.checkStatus(transactionId);
        switch (s) {
            case 1: return TicketStatus.PAID;
            case 0: return TicketStatus.PENDING;
            case -1: default: return TicketStatus.FAILED;
        }
    }
}
