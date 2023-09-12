package de.stabi.statistics.structure;

import de.stabi.booking.structure.Booking;
import de.stabi.payment.structure.PaymentType;

public class StatisticsVisitor implements Visitor {
	private int germanPayPalBookings = 0;
	private int germanGoogleWalletBookings = 0;
	private int germanMobileWalletBookings = 0;
	private int englishGoogleWalletBookings = 0;
	private int englishPayPalBookings = 0;
	private int englishMobileWalletBookings = 0;

	public int getGermanBookingsPaidByPaypal() {
		return germanPayPalBookings;
	}

	public int getGermanBookingsPaidByGoogleWallet() {
		return germanGoogleWalletBookings;
	}

	public int getGermanBookingsPaidByMobileMoneyWallet() {
		return germanMobileWalletBookings;
	}

	public int getEnglishBookingsPaidByPaypal() {
		return englishPayPalBookings;
	}

	public int getEnglishBookingsPaidByGoogleWallet() {
		return englishGoogleWalletBookings;
	}

	public int getEnglishBookingsPaidByMobileMoneyWallet() {
		return englishMobileWalletBookings;
	}

	@Override
	public void visit(Booking booking, PaymentType paymentType, int bookingLanguage) {
		if (bookingLanguage == 1) {
			if (paymentType.equals(de.stabi.payment.structure.PaymentType.PAYPAL)) {
				germanPayPalBookings++;
			} else if (paymentType.equals(de.stabi.payment.structure.PaymentType.GOOGLE_WALLET)) {
				germanGoogleWalletBookings++;
			} else if (paymentType.equals(de.stabi.payment.structure.PaymentType.MOBILE_MONEY_WALLET)) {
				germanMobileWalletBookings++;
			}
		} else if (bookingLanguage == 2) {
			if (paymentType.equals(de.stabi.payment.structure.PaymentType.PAYPAL)) {
				englishPayPalBookings++;
			} else if (paymentType.equals(de.stabi.payment.structure.PaymentType.GOOGLE_WALLET)) {
				englishGoogleWalletBookings++;
			} else if (paymentType.equals(de.stabi.payment.structure.PaymentType.MOBILE_MONEY_WALLET)) {
				englishMobileWalletBookings++;
			}
		}
	}

	@Override
	public void displayStatistics() {
		System.out.println("German Booking Paid by PayPal: " + germanPayPalBookings);
		System.out.println("German Booking Paid by Google Wallet: " + germanGoogleWalletBookings);
		System.out.println("German Booking Paid by Mobile Wallet: " + germanMobileWalletBookings);
		System.out.println("English Booking Paid by Google Wallet: " + englishGoogleWalletBookings);
		System.out.println("English Booking Paid by PayPal: " + englishPayPalBookings);
		System.out.println("English Booking Paid by Mobile Wallet: " + englishMobileWalletBookings);
	}
}
