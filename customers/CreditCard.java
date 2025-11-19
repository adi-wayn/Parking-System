package customers;
public class CreditCard {
    private final String cardNumber;
    private final String expiration;
    private final String cvc;

    public CreditCard(String cardNumber, String expiration, String cvc) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
    }

    public String getCardNumber() { return cardNumber; }
    public String getExpiration() { return expiration; }
    public String getCvc() { return cvc; }

    public boolean isValid() {
        return cardNumber != null && !cardNumber.isEmpty() && 
               expiration != null && !expiration.isEmpty() && 
               cvc != null && !cvc.isEmpty();
    }
}
