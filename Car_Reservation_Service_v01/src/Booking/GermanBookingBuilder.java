package Booking;

import java.util.Date;

import Person.Address;
import Person.Person;
import Ressource.Ressource;

public class GermanBookingBuilder extends BookingBuilder {

	public GermanBookingBuilder(Person person, Ressource car, int duration) {
		super(person, car, duration);
	}

	private double price;
	private Head head = new Head();
	private Body body = new Body();
	private Footer footer = new Footer();
	private GermanBooking germanBooking = new GermanBooking();
	private Date today = new Date();

	// GermanHead
	@Override
	protected void buildHead() {
		String name = person.getName();
		Address address = person.getAddress();
		String email = person.geteMail();
		
		head.setHead(person.getName(), person.getAddress(), person.geteMail());
		System.out.println("======================Ihre Buchung =======================");
		System.out.println("Ihre Kontaktdaten: " + name);
		address.printAddress();
		System.out.println("\n");
//		System.out.println("Ihre Email: " + email + "\n");
		germanBooking.setHead(head);
	}

	// GermanBody 
	@Override
	protected void buildBody() {
//		body.setBody(car, duration, startDay, car.getCost());
		int duration = car.getDuration();
		Date startDay = car.getStartDay();
		body.setBody(car);
		System.out.println(car.getDescription());
		System.out.println("Ihre Buchung erfolgte über die Dauer von " + duration + " Tag(en) startend am " + startDay + "\n" );
		germanBooking.setBody(body);

	}

	// GermanFooter
	@Override
	protected void buildFooter() {
//		price = duration * car.getCost();
//		footer.setFooter(price, "DE123456789");
		Double totalPrice = car.getTotalPrice();
		footer.setFooter(car);
		System.out.println("Gesamtpreis: " + totalPrice + " EUR für die Dauer von " + duration + " Tag(en).");
		System.out.println("Wir akzeptieren die folgenden Zahlungs-Optionen: Paypal, Google Wallet or Money Wallet.");
		System.out.println("Diese Buchung wurde angelegt am " + today + ". Bitte bewahren Sie Ihre Buchungsbelege gut auf!");
		System.out.println("Vielen Dank für Ihre Buchung mit Stabi GmbH!");
		System.out.println("======================Ende des Buchungsbelegs=======================");
		germanBooking.setFooter(footer);

	}

	@Override
	protected Booking buildBooking() {
		buildHead();
        buildBody();
        buildFooter();
        return germanBooking;
	}

}

////	@Override
////	protected Booking buildBooking() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	
//	private GermanBooking germanBooking;
//	
//	public Booking getBooking() {
//		
//	}
//
//}
