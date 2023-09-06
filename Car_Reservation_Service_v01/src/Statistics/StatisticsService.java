package Statistics;

import java.util.List;

import Booking.Booking;
import Booking.ConcreteBooking;
import Payment.PaymentType;

//public class StatisticsService {
//
//	public StatisticsService() {
//		// TODO Auto-generated constructor stub
//	}
//
//	private StatisticsVisitor visitor = new StatisticsVisitor();
//
////	public void collectStatistics(List<Booking> bookings, List<PaymentType> paymentTypes) {
//
////        StatisticsVisitor visitor = new StatisticsVisitor();
////        for (int i = 0; i < bookings.size(); i++) {
////            Booking booking = bookings.get(i);
////            PaymentType paymentType = paymentTypes.get(i); 
////            booking.accept(visitor, paymentType);
////        }
////        visitor.displayStatistics();
////	}
//
//	public void collectStatistics(List<Booking> bookings, List<PaymentType> paymentTypes,
//			List<Integer> bookingLanguages) {
//		for (int i = 0; i < bookings.size(); i++) {
//			Booking booking = bookings.get(i);
//			PaymentType paymentType = paymentTypes.get(i);
//			int bookingLanguage = bookingLanguages.get(i);
//			visitor.visit(booking, paymentType, bookingLanguage);
//		}
//	}
//
//	public void displayStatistics() {
//		visitor.displayStatistics();
//	}
//
//	
//	
//	public int getGermanBookingsPaidBy(PaymentType paymentType) {
//	    if (paymentType == PaymentType.PAYPAL) {
//	        return visitor.getGermanBookingsPaidByPaypal();
//	    } else if (paymentType == PaymentType.GOOGLE_WALLET) {
//	        return visitor.getGermanBookingsPaidByGoogleWallet();
//	    } else if (paymentType == PaymentType.MOBILE_MONEY_WALLET) {
//	        return visitor.getGermanBookingsPaidByMobileMoneyWallet();
//	    } else {
//	        return 0; // Falls der Zahlungstyp unbekannt ist.
//	    }
//	}
//
//	public int getEnglishBookingsPaidBy(PaymentType paymentType) {
//	    if (paymentType == PaymentType.PAYPAL) {
//	        return visitor.getEnglishBookingsPaidByPaypal();
//	    } else if (paymentType == PaymentType.GOOGLE_WALLET) {
//	        return visitor.getEnglishBookingsPaidByGoogleWallet();
//	    } else if (paymentType == PaymentType.MOBILE_MONEY_WALLET) {
//	        return visitor.getEnglishBookingsPaidByMobileMoneyWallet();
//	    } else {
//	        return 0; 
//	    }
//	}
//
//		StatisticsService statisticsService = new StatisticsService();
//		int germanPayPalBookings = statisticsService.getGermanBookingsPaidBy(PaymentType.PAYPAL);
//		int englishGoogleWalletBookings = statisticsService.getEnglishBookingsPaidBy(PaymentType.GOOGLE_WALLET);
//
//		System.out.println ("German PayPal Bookings: " + germanPayPalBookings);
//		System.out.println("English Google Wallet Bookings: " + englishGoogleWalletBookings);
//
//}










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
            return 0; d
        }
    }
 

   
    }


