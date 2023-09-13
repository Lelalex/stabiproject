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
import Person.Person;
import Person.PersonService;
import Ressource.Ressource;
import Ressource.RessourceService;
import Statistics.StatisticsService;
import Statistics.StatisticsVisitor;
import Statistics.Visitor;

public class Carreservation2 {

	public static void main(String[] args) {

		login();
		selectService();
	}

	private static void login() {
		Scanner loginScan = new Scanner(System.in);

		PersonService personService = new PersonService();
		Person person = null;
		AuthenticationService authenticationService = new AuthenticationService();

		int chosenService;

		do {
			System.out.println("===================Login Menu===================");
			System.out.println("Choose which step of login you want to select:");
			System.out.println("Press 1 : Create your account");
			System.out.println("Press 2 : Authenticate yourself");
			System.out.println("Press 3 : Proceed to MainMenu");

			chosenService = loginScan.nextInt();

			switch (chosenService) {
			case 1:
				person = personService.createPerson();
				break;
			case 2:
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
			case 3:
//				System.exit(0);
				selectService();
				break;
			}
		} while (chosenService != 0);

		loginScan.close();
	}

	private static void selectService() {

		Scanner serviceChoiceScan = new Scanner(System.in);

		RessourceService ressourceService = new RessourceService();
		BookingService bookingService = new BookingService();
		PaymentService paymentService = new PaymentService();
		ContentService contentService = new ContentService();
		StatisticsService statisticsService = new StatisticsService();

		int chosenService;
		do {
			System.out.println("===================Main Menu===================");
			System.out.println("Choose which service you want to use next:");
			System.out.println("Press 1 : Choose your car and extras (Ressource Service)");
			System.out.println("Press 2 : Book the chosen car (Booking Service)");
			System.out.println("Press 3 : Pay the car (Payment Service)");
			System.out.println("Press 4 : See your contents (Content Service)");
			System.out.println("Press 5 : Check statistics (Statistics Service)");
			System.out.println("Press 0 to exit the program!");

			chosenService = serviceChoiceScan.nextInt();

			switch (chosenService) {
			case 1:
				Ressource selectedRessource = ressourceService.getSelectedRessource();
				break;
			case 2:
				bookingService.createBooking();
				break;
			case 3:
				paymentService.payAmount();
				break;
			case 4:
				contentService.createFileSystemStructure();
				break;
			case 5:
				statisticsService.displayStatistics();
				break;
			case 0:
				System.out.println("Exiting the program!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
		} while (chosenService != 0);

		serviceChoiceScan.close();
	}
}
