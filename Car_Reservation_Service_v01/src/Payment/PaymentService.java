package Payment;

public class PaymentService {
    public void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount, PaymentType type) {
        PaymentTemplate payment;

        switch (type) {
            case PAYPAL:
                payment = new PayPalPayment();
                break;
            case GOOGLE_WALLET:
                payment = new GoogleWalletPayment();
                break;
            case MOBILE_MONEY_WALLET:
                payment = new MobileMoneyWalletPayment();
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment type");
        }

        payment.payAmount(senderAccount, receiverAccount, amount);
    }
}
