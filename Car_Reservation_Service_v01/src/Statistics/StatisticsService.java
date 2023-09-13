package Statistics;

import java.util.List;

import Booking.Booking;
import Payment.PaymentType;

public class StatisticsService {

	private StatisticsVisitor visitor = new StatisticsVisitor();

	public void collectStatistics(List<Booking> bookings, List<PaymentType> paymentTypes,
			List<Integer> bookingLanguages) {
		for (int i = 0; i < bookings.size(); i++) {
			Booking booking = bookings.get(i);
			PaymentType paymentType = paymentTypes.get(i);
			int bookingLanguage = bookingLanguages.get(i);
			visitor.visit(booking, paymentType, bookingLanguage);
		}
	}

	public int getGermanBookingsPaidBy(PaymentType paymentType) {
		if (paymentType == PaymentType.PAYPAL) {
			return visitor.getGermanBookingsPaidByPaypal();
		} else if (paymentType == PaymentType.GOOGLE_WALLET) {
			return visitor.getGermanBookingsPaidByGoogleWallet();
		} else if (paymentType == PaymentType.MOBILE_MONEY_WALLET) {
			return visitor.getGermanBookingsPaidByMobileMoneyWallet();
		} else {
			return 0;
		}
	}

	public int getEnglishBookingsPaidBy(PaymentType paymentType) {
		if (paymentType == PaymentType.PAYPAL) {
			return visitor.getEnglishBookingsPaidByPaypal();
		} else if (paymentType == PaymentType.GOOGLE_WALLET) {
			return visitor.getEnglishBookingsPaidByGoogleWallet();
		} else if (paymentType == PaymentType.MOBILE_MONEY_WALLET) {
			return visitor.getEnglishBookingsPaidByMobileMoneyWallet();
		} else {
			return 0;
		}
	}
	
	public void displayStatistics() {
		System.out.println("=======================Statistics ========================");
		System.out.println("German Booking Paid by PayPal: " + germanPayPalBookings);
		System.out.println("German Booking Paid by Google Wallet: " + germanGoogleWalletBookings);
		System.out.println("German Booking Paid by Mobile Wallet: " + germanMobileWalletBookings);
		System.out.println("English Booking Paid by Google Wallet: " + englishGoogleWalletBookings);
		System.out.println("English Booking Paid by PayPal: " + englishPayPalBookings);
		System.out.println("English Booking Paid by Mobile Wallet: " + englishMobileWalletBookings + "\n");
		System.out.println("=======================End of Statistics ========================");
	}

}
