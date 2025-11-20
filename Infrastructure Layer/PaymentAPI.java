package services.payment;
public class PaymentAPI {
	public String makeCharge(double value) {
		// returns transaction id
        //TODO implement method
		return null;
    }

    public boolean abortCharge(String id) {
		// cancels charge
        //TODO implement method
		return false;
    }

    public int checkStatus(String id) {
        // 0=pending, 1=paid, -1=failed
		//TODO implement method
		return 0;
    }
}
