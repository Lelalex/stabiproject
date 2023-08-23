package Payment;

import java.util.Scanner;

import Person.Person;

public class PaymentService {
    public void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount) {
        Scanner paymentTypescanner = new Scanner(System.in);
        System.out.println("Please select a payment method (1: PayPal, 2: Google Wallet, 3: Mobile Money Wallet):");
        int chosenPaymentType = paymentTypescanner.nextInt();

        PaymentType type;
        switch (chosenPaymentType) {
            case 1:
                type = PaymentType.PAYPAL;
                break;
            case 2:
                type = PaymentType.GOOGLE_WALLET;
                break;
            case 3:
                type = PaymentType.MOBILE_MONEY_WALLET;
                break;
            default:
                throw new IllegalArgumentException("Unsupported payment type");
        }

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

        System.out.println("Please enter your email:");
        String email = paymentTypescanner.next();
        System.out.println("Please enter your password:");
        String password = paymentTypescanner.next();

        if (verifyCredentials(email, password)) {
            payment.payAmount(senderAccount, receiverAccount, amount);
        } else {
            System.out.println("Authentication failed. Payment not processed.");
        }

        paymentTypescanner.close();
    }

    private boolean verifyCredentials(String email, String password) {
    	System.out.println("Are these login credentials correct? "+ email + " " + password);
    	System.out.println("Please insert yes (y) or no (n).");
    	Scanner verifyCredentialScanner = new Scanner(System.in);
    	String verfiyCredentials = verifyCredentialScanner.next();
    	if (verfiyCredentials == "y")
			return true;

		else if (verfiyCredentials == "n")
			return false;
		else {
			System.out.println("Invalid input. Please try again.");
			verifyCredentials(email, password);
			return false;
		}
    }
}





