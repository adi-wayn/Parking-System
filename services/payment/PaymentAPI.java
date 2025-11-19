package services.payment;
public class PaymentAPI {
	// Simulated external payment API
	public boolean charge(int amount) {
		// very simple simulation: fail for zero or negative
		return amount > 0;
	}
}
