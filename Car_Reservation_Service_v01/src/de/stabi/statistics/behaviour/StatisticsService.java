package de.stabi.statistics.behaviour;

import java.util.List;

import de.stabi.booking.structure.Booking;
import de.stabi.payment.structure.PaymentType;
import de.stabi.statistics.structure.StatisticsVisitor;

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

	public void displayStatistics() {
		visitor.displayStatistics();
	}

	public int getGermanBookingsPaidBy(PaymentType paymentType) {
		if (paymentType == de.stabi.payment.structure.PaymentType.PAYPAL) {
			return visitor.getGermanBookingsPaidByPaypal();
		} else if (paymentType == de.stabi.payment.structure.PaymentType.GOOGLE_WALLET) {
			return visitor.getGermanBookingsPaidByGoogleWallet();
		} else if (paymentType == de.stabi.payment.structure.PaymentType.MOBILE_MONEY_WALLET) {
			return visitor.getGermanBookingsPaidByMobileMoneyWallet();
		} else {
			return 0;
		}
	}

	public int getEnglishBookingsPaidBy(PaymentType paymentType) {
		if (paymentType == de.stabi.payment.structure.PaymentType.PAYPAL) {
			return visitor.getEnglishBookingsPaidByPaypal();
		} else if (paymentType == de.stabi.payment.structure.PaymentType.GOOGLE_WALLET) {
			return visitor.getEnglishBookingsPaidByGoogleWallet();
		} else if (paymentType == de.stabi.payment.structure.PaymentType.MOBILE_MONEY_WALLET) {
			return visitor.getEnglishBookingsPaidByMobileMoneyWallet();
		} else {
			return 0;
		}
	}

}
