package de.stabi.carReservation;

import java.util.Scanner;

import de.stabi.authentication.behaviour.AuthenticationService;
import de.stabi.authentication.structure.FingerPrintStrategy;
import de.stabi.booking.behaviour.BookingService;
import de.stabi.booking.structure.Booking;
import de.stabi.content.behaviour.ContentService;
import de.stabi.payment.behaviour.PaymentService;
import de.stabi.payment.structure.Account;
import de.stabi.payment.structure.CurrencyAmount;
import de.stabi.payment.structure.PaymentType;
import de.stabi.person.behaviour.PersonService;
import de.stabi.person.structure.Person;
import de.stabi.ressource.behaviour.RessourceService;
import de.stabi.ressource.structure.Ressource;
import de.stabi.statistics.behaviour.StatisticsService;
import de.stabi.statistics.structure.StatisticsVisitor;
import de.stabi.statistics.structure.Visitor;

public class Carreservation {

	public static void main(String[] args) {

		Scanner serviceChoiceScan = new Scanner(System.in);

		PersonService personService = new PersonService();
		RessourceService ressourceService = new RessourceService();
		BookingService bookingService = new BookingService();
		PaymentService paymentService = new PaymentService();
		ContentService contentService = new ContentService();
		StatisticsService statisticsService = new StatisticsService();

		// create the visitor for statistics
		Visitor visitor = new StatisticsVisitor();

		Booking chosenBooking = null;

		double totalPrice = 0.0;
		Person person = null;

		int chosenService;
		do {
			System.out.println("===================Main Menu===================");
			System.out.println("Choose which service you want to use next:");
			System.out.println("Press 1 : Create your account and authenticate yourself (Person Service)");
			System.out.println("Press 2 : Choose your car and extras (Ressource Service)");
			System.out.println("Press 3 : Book the chosen car (Booking Service)");
			System.out.println("Press 4 : Pay the car (Payment Service)");
			System.out.println("Press 5 : See your contents (Content Service)");
			System.out.println("Press 6 : Check statistics (Statistics Service)");
			System.out.println("Press 0 to exit the program!");

			chosenService = serviceChoiceScan.nextInt();

			switch (chosenService) {
			case 1:
				person = personService.createPerson();

				AuthenticationService authenticationService = new AuthenticationService();
				FingerPrintStrategy strategy = new FingerPrintStrategy();
				authenticationService.setStrategy(strategy);
				authenticationService.setPerson(person);
				boolean isAuthenticated = authenticationService.authenticateSubject();

				if (isAuthenticated) {
					System.out.println("Your account has been created and the authentication was successful.");
				} else {
					System.out.println("Authentication failed. Cannot proceed with booking.");
				}
				break;
			case 2:
				if (person != null) {

					Ressource selectedRessource = ressourceService.getSelectedRessource();
					if (selectedRessource != null) {
						totalPrice = selectedRessource.getTotalPrice();
					}
				} else {
					System.out.println("Please create a person first.");
				}
				break;
			case 3:
				if (totalPrice > 0 && person != null) {
					Booking booking = bookingService.createBooking(person, totalPrice);
					if (booking != null) {
						System.out.println(booking.getHead());
					}
				} else {
					System.out.println("Please create a person and select a ressource first.");
				}
				break;
			case 4:
				if (totalPrice > 0 && person != null) {
					String accountName = person.getUsername();
					Account senderAccount = new Account("SenderAccount", accountName, totalPrice);
					Account receiverAccount = Account.getReceiverAccount();

					CurrencyAmount amount = new CurrencyAmount(totalPrice, "EUR");

					String email = person.geteMail();
					String password = person.getPassword();

					paymentService.payAmount(senderAccount, receiverAccount, amount, email, password);

					// Check if the payment was successful
					if (paymentService.getPaymentResult()) {
						System.out.println("Payment was successful!");

						chosenBooking = bookingService.getChosenBooking();
						PaymentType paymentType = paymentService.getChosenPaymentType();
						int bookingLanguage = bookingService.getBookingLanguage();

						// call visitor and pass paymentTest & bookingLanguage
						visitor.visit(chosenBooking, paymentType, bookingLanguage);
					} else {
						System.out.println("Payment failed.");
					}
				} else {
					System.out.println("Please create a person, select a ressource, and make a booking first.");
				}
				break;
			case 5:
				contentService.createFileSystemStructure();
				break;
			case 6:
				statisticsService.displayStatistics();
				break;
			case 0:
				System.out.println("Exiting the program!");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		} while (chosenService != 0);

		serviceChoiceScan.close();
	}
}
