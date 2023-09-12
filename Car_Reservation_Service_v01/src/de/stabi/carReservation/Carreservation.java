package de.stabi.carReservation;

import java.util.List;

import de.stabi.booking.structure.Booking;
import de.stabi.booking.structure.ConcreteBooking;
import de.stabi.payment.structure.PaymentType;
import de.stabi.statistics.behaviour.StatisticsService;

public class Carreservation {

	 public static void main(String[] args) {
	        // eine Instanz der StatisticsService-Klasse erstellen
	        StatisticsService statisticsService = new StatisticsService();

	        // einige Beispieldaten für Buchungen und Zahlungstypen erstellen
	        Booking booking1 = new ConcreteBooking(1, "Buchung 1 Details");
	        Booking booking2 = new ConcreteBooking(2, "Buchung 2 Details");
	        PaymentType paymentType1 = de.stabi.payment;
	        PaymentType paymentType2 = de.stabi.payment;

	        
	        statisticsService.collectStatistics(
	            List.of(booking1, booking2),
	            List.of(paymentType1, paymentType2),
	            List.of(1, 2) // Beispiel für die Buchungssprachen (1 für Deutsch, 2 für Englisch)
	        );

	        
	        int germanPayPalBookings = statisticsService.getGermanBookingsPaidBy(de.stabi.payment);
	        int englishGoogleWalletBookings = statisticsService.getEnglishBookingsPaidBy(de.stabi.payment);

	        System.out.println("German PayPal Bookings: " + germanPayPalBookings);
	        System.out.println("English Google Wallet Bookings: " + englishGoogleWalletBookings);
	    }
}
