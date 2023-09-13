package Carreservation;

import java.util.Scanner;

import Authentication.AuthenticationService;
import Authentication.FingerPrintStrategy;
import Booking.Booking;
import Booking.BookingService;
import Content.ContentService;
import Payment.Account;
import Payment.CurrencyAmount;
import Payment.PaymentService;
import Payment.PaymentType;
import Person.Person;
import Person.PersonService;
import Ressource.Ressource;
import Ressource.RessourceService;
import Statistics.StatisticsService;
import Statistics.StatisticsVisitor;
import Statistics.Visitor;

public class Carreservation {

	private static double totalPrice;

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

//        double totalPrice = 0.0;
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
					System.out.println("Your account has been created, and the authentication was successful.");
				} else {
					System.out.println("Authentication failed. Cannot proceed with booking.");
				}
				break;
			case 2:
				Ressource selectedRessource = ressourceService.getSelectedRessource();
				totalPrice = selectedRessource.getTotalPrice();
				// Use the setter method to update the total price
				settotalPrice(totalPrice);
				break;
			case 3:
				Booking booking = bookingService.createBooking(person);
//                    System.out.println(booking.getHead());
				break;
			case 4:
				String accountName = person.getUsername();
				Account senderAccount = new Account("SenderAccount", accountName, totalPrice);
				Account receiverAccount = Account.getReceiverAccount();

				CurrencyAmount amount = new CurrencyAmount(totalPrice, "EUR");

				String email = person.geteMail();
				String password = person.getPassword();

				paymentService.payAmount(senderAccount, receiverAccount, amount, email, password);

//				// Check if the payment was successful
//				if (paymentService.getPaymentResult()) {
//					System.out.println("Payment was successful!");
//
//					chosenBooking = bookingService.getChosenBooking();
//					PaymentType paymentType = paymentService.getChosenPaymentType();
//					int bookingLanguage = bookingService.getBookingLanguage();
//
//					// Call visitor and pass paymentType & bookingLanguage
//					visitor.visit(chosenBooking, paymentType, bookingLanguage);
//				} else {
//					System.out.println("Payment failed.");
//				}
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

	public static void settotalPrice(double price) {
		totalPrice = price;
	}
}
