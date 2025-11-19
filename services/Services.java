package services;

import services.payment.PaymentService;

public class Services {
    private final PaymentService payment;
    private final Allocation allocation;
    private final Charging charging;
    private final Towing towing;
    private final Violation violation;

    public Services(PaymentService payment,
                    Allocation allocation,
                    Charging charging,
                    Towing towing,
                    Violation violation) {
        this.payment = payment;
        this.allocation = allocation;
        this.charging = charging;
        this.towing = towing;
        this.violation = violation;
    }

    public PaymentService getPayment() {
        return payment;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public Charging getCharging() {
        return charging;
    }

    public Towing getTowing() {
        return towing;
    }

    public Violation getViolation() {
        return violation;
    }
}