package de.stabi.payment.behaviour;

import java.util.Scanner;

import de.stabi.payment.structure.Account;
import de.stabi.payment.structure.CurrencyAmount;
import de.stabi.payment.structure.GoogleWalletPayment;
import de.stabi.payment.structure.MobileMoneyWalletPayment;
import de.stabi.payment.structure.PayPalPayment;
import de.stabi.payment.structure.PaymentTemplate;
import de.stabi.payment.structure.PaymentType;

public class PaymentService {

	private boolean paymentResult;

	public void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount, String paymentMethod,
			String email, String password) {
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
			System.out.println("Choosing PayPal as payment method...");
			break;
		case GOOGLE_WALLET:
			payment = new GoogleWalletPayment();
			System.out.println("Choosing Google Wallet as payment method...");
			break;
		case MOBILE_MONEY_WALLET:
			payment = new MobileMoneyWalletPayment();
			System.out.println("Choosing Mobile Money Wallet as payment method...");
			break;
		default:
			throw new IllegalArgumentException("Unsupported payment type");
		}

		System.out.println("Please enter your email:");
		String confirmationMail = paymentTypescanner.next();
		System.out.println("Please enter your password:");
		String confirmationPassword = paymentTypescanner.next();

//        boolean authenticationResult = verifyCredentials(email, password, false);

		if (verifyCredentials(confirmationMail, confirmationPassword)) {
			payment.payAmount(senderAccount, receiverAccount, amount);
			paymentResult = true;
		} else {
			System.out.println("Authentication failed. Payment not processed.");
			paymentResult = false;
		}
		paymentTypescanner.close();
	}

	private boolean verifyCredentials(String email, String password) {
		Scanner verifyCredentialScanner = new Scanner(System.in);
		System.out.println("Are these login credentials correct? " + email + " " + password);
		System.out.println("Please insert yes (y) or no (n).");
		String verfiyCredentialsScan = verifyCredentialScanner.next();
		if (verfiyCredentialsScan.toLowerCase().equals("y")) {
			return true;
		} else {
			return false;

		}
	}

	public boolean getPaymentResult() {
		return paymentResult;
	}
}
