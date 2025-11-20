package services;

import gates.Security;
import services.payment.PaymentProcessor;

public class Services {
    private final PaymentProcessor payment;
    private final Allocation allocation;
    private final Charging charging;
    private final Towing towing;
    private final Violation violation;
    private final Security security;

    public Services(PaymentProcessor payment,
                    Allocation allocation,
                    Charging charging,
                    Towing towing,
                    Violation violation,
                    Security security) {
        this.payment = payment;
        this.allocation = allocation;
        this.charging = charging;
        this.towing = towing;
        this.violation = violation;
        this.security = security;
    }

    public PaymentProcessor getPayment() {
        return payment;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public Charging getChargingFee() {
        return charging;
    }

    public Towing getTowing() {
        return towing;
    }

    public Violation getViolation() {
        return violation;
    }

    public Security getSecurity() {
        return security;
    }
}