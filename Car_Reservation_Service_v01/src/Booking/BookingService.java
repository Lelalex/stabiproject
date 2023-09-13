package Booking;

import java.util.Scanner;

import Person.Person;
import Person.PersonService;
import Ressource.Ressource;
import Ressource.RessourceService;
import Statistics.StatisticsVisitor;
import Statistics.Visitor;

public class BookingService {
	
	private int bookingLanguage;
	private Booking chosenBooking;

	public Booking createBooking(Person person) {
		
		PersonService personService = new PersonService();
        RessourceService ressourceService = new RessourceService();
        
        
		//get selected person and car(ressource) with desired addons
//        Person person = personService.createPerson();
        Ressource car = ressourceService.getSelectedRessource();
        
        int bookingLanguage = chooseBookingLanguage();
        
//		BookingBuilder bookingBuilder = new BookingBuilder(); 
//		Date startDay = null; 
		int duration = car.getDuration();
		double totalPrice = car.getTotalPrice();
		
		Visitor visitor = new StatisticsVisitor();

		switch (bookingLanguage) {
		case 1:
			GermanBookingBuilder germanBuilder = new GermanBookingBuilder(person, car, duration, visitor, totalPrice);
//			Booking germanBooking = germanBuilder.setPerson(person).setCar(car).buildBooking();
			Booking germanBooking = germanBuilder.buildBooking();
			chosenBooking = germanBooking;
//			System.out.println(germanBooking.getHead());
			return germanBooking;
		case 2:
			EnglishBookingBuilder englishBuilder = new EnglishBookingBuilder(person, car, duration, visitor, totalPrice);
//			englishBuilder.setPerson(person);
//			englishBuilder.setCar(car);
//			englishBuilder.setDuration(duration);
			Booking englishBooking = englishBuilder.buildBooking();
			chosenBooking = englishBooking;
//			System.out.println(englishBooking.getHead());
			return englishBooking;
		default:
			System.out.println("Invalid Entry. Wählen Sie zur Buchung 1 für Deutsch / Choose 2 to book in English.");
			return null;
		}

//        Booking booking = bookingBuilder
//        		.setPerson(person)
//        		.setCar(car)
//        		.setDuration(duration)
//        		.setStartDay(startDay)
//        		.buildBooking();        


//		if (booking != null) {
//			System.out.println(booking.getHead());
//		}
//
//		System.out.println(booking.getHead());
//		return booking;
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
