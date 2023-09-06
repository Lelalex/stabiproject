package Carreservation;

import java.util.List;

import Booking.Booking;
import Booking.ConcreteBooking;
import Payment.PaymentType;
import Statistics.StatisticsService;

public class Carreservation {

	 public static void main(String[] args) {
	        // eine Instanz der StatisticsService-Klasse erstellen
	        StatisticsService statisticsService = new StatisticsService();

	        // einige Beispieldaten für Buchungen und Zahlungstypen erstellen
	        Booking booking1 = new ConcreteBooking(1, "Buchung 1 Details");
	        Booking booking2 = new ConcreteBooking(2, "Buchung 2 Details");
	        PaymentType paymentType1 = PaymentType.PAYPAL;
	        PaymentType paymentType2 = PaymentType.GOOGLE_WALLET;

	        
	        statisticsService.collectStatistics(
	            List.of(booking1, booking2),
	            List.of(paymentType1, paymentType2),
	            List.of(1, 2) // Beispiel für die Buchungssprachen (1 für Deutsch, 2 für Englisch)
	        );

	        
	        int germanPayPalBookings = statisticsService.getGermanBookingsPaidBy(PaymentType.PAYPAL);
	        int englishGoogleWalletBookings = statisticsService.getEnglishBookingsPaidBy(PaymentType.GOOGLE_WALLET);

	        System.out.println("German PayPal Bookings: " + germanPayPalBookings);
	        System.out.println("English Google Wallet Bookings: " + englishGoogleWalletBookings);
	    }
}
