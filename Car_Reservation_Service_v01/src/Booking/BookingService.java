package Booking;

import java.util.Scanner;

import Database.DataBase;
import Person.Person;
import Ressource.Ressource;

public class BookingService {

	private int bookingLanguage;
	private Booking chosenBooking;

	private DataBase db = DataBase.getInstance();

	public void createBooking() {        
        
		Scanner personScan = new Scanner(System.in);
		System.out.println("Please provide your person ID");
		String id = personScan.next();
		System.out.println("Are you a natural or legal person? (n/l)");
		String personType = personScan.next();
		personScan.close();
		
		//get selected person and car(ressource) with desired addons from database
		Person person = db.getPersonById(id, personType);
        Ressource car = db.getSelectedRessource();
        
        //choose langugage of booking German or English
        int bookingLanguage = chooseBookingLanguage();
        
		int duration = car.getDuration();
		double totalPrice = car.getTotalPrice();
		
		Booking Booking;
		switch (bookingLanguage) {
		case 1:
			GermanBookingBuilder germanBuilder = new GermanBookingBuilder(person, car, duration, totalPrice);
			Booking germanBooking = germanBuilder.buildBooking();
			chosenBooking = germanBooking;
			db.saveBooking(germanBooking);
			db.saveTotalPrice(totalPrice);
			person.setBooking(germanBooking);
//			return germanBooking;
			break;
		case 2:
			EnglishBookingBuilder englishBuilder = new EnglishBookingBuilder(person, car, duration, totalPrice);
			Booking englishBooking = englishBuilder.buildBooking();
			db.saveBooking(englishBooking);
			db.saveTotalPrice(totalPrice);
			person.setBooking(englishBooking);
//			return englishBooking;
			break;
		default:
			System.out.println("Invalid Entry. Wählen Sie zur Buchung 1 für Deutsch / Choose 2 to book in English.");
			break;
		}
	}

	public int chooseBookingLanguage() {
		Scanner bookingScan = new Scanner(System.in);
		System.out.println("Wählen Sie ihre Buchungssprache / Choose language of booking:");
		System.out.println("Wählen Sie 1 für Deutsch / Choose 2 for English.");
		int bookingLanguage = bookingScan.nextInt();

		return bookingLanguage;
	}

	public int getBookingLanguage() {
		return bookingLanguage;
	}

	public Booking getChosenBooking() {
		return chosenBooking;
	}
}
