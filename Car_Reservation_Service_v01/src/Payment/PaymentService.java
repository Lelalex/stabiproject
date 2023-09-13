package Payment;

import java.util.Scanner;

import Booking.Booking;
import Booking.BookingService;
import Database.DataBase;
import Person.Person;
import Statistics.StatisticsVisitor;

public class PaymentService {

	private boolean paymentResult;
	private PaymentType chosenPaymentType;
	private BookingService bookingService;
	private Booking chosenBooking;
	private int bookingLanguage;
	private DataBase db = DataBase.getInstance();

	public void payAmount() {
		
		Person person = db.getPerson(null);
		Booking booking = db.getBooking();
		double totalPrice = db.getTotalPrice();
		
		Account senderAccount = new Account("1", person.getName(), 100000);
		Account receiverAccount = Account.getReceiverAccount();
		CurrencyAmount amount = new CurrencyAmount(totalPrice, "EUR");
		String email = person.geteMail();
		String password = person.getPassword();
		
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

		PaymentType paymentType = type;
		PaymentTemplate payment;
		switch (type) {
		case PAYPAL:
			payment = new PayPalPayment();
			System.out.println("Choosing PayPal as payment method...");
			db.savePayment(paymentType, payment);
			break;
		case GOOGLE_WALLET:
			payment = new GoogleWalletPayment();
			System.out.println("Choosing Google Wallet as payment method...");
			db.savePayment(paymentType, payment);
			break;
		case MOBILE_MONEY_WALLET:
			payment = new MobileMoneyWalletPayment();
			System.out.println("Choosing Mobile Money Wallet as payment method...");
			db.savePayment(paymentType, payment);
			break;
		default:
			throw new IllegalArgumentException("Unsupported payment type");
		}

		System.out.println("Please enter your email:");
		String confirmationMail = paymentTypescanner.next();
		System.out.println("Please enter your password:");
		String confirmationPassword = paymentTypescanner.next();


		if (verifyCredentials(confirmationMail, confirmationPassword)) {
			payment.payAmount(senderAccount, receiverAccount, amount);
			paymentResult = true;

			updateStatistics(chosenBooking, paymentType, bookingLanguage);
			System.out.println("Authentication and Payment was successful!");
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

	private void updateStatistics(Booking booking, PaymentType paymentType, int bookingLanguage) {
        StatisticsVisitor statisticsVisitor = new StatisticsVisitor();
        
		//call visitor and pass paymentTest & bookingLanguage
        statisticsVisitor.visit(chosenBooking, paymentType, bookingLanguage);
	}
	public boolean getPaymentResult() {
		return paymentResult;
	}
}
