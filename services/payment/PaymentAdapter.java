package services.payment;
public class PaymentAdapter implements PaymentProcessor {
	private final PaymentAPI api = new PaymentAPI();

	@Override
	public boolean pay(int amount) {
		return api.charge(amount);
	}
}
