package de.stabi.booking.structure;

import java.util.Date;

import de.stabi.person.structure.Address;
import de.stabi.person.structure.Person;
import de.stabi.ressource.structure.Ressource;

public class EnglishBookingBuilder extends BookingBuilder {

	public EnglishBookingBuilder(Person person, Ressource car, int duration) {
		super(person, car, duration);
	}

	private double price;
	private Head head = new Head();
	private Body body = new Body();
	private Footer footer = new Footer();
	private EnglishBooking englishBooking = new EnglishBooking();
	private Date today = new Date();

	@Override
	protected void buildHead() {
		String name = person.getName();
		Address address = person.getAddress();
		String email = person.geteMail();

		head.setHead(person.getName(), person.getAddress(), person.geteMail());

		System.out.println("======================Your booking=======================");
		System.out.println("Your contact details: " + name);
		address.printAddress();
		System.out.println("\n");
//		System.out.println("Your mail: " + email + "\n");
		englishBooking.setHead(head);
	}

	@Override
	protected void buildBody() {
		int duration = car.getDuration();
		Date startDay = car.getStartDay();
		body.setBody(car);
		System.out.println(car.getDescription());
		System.out.println("The booking period will be " + duration + " day(s) starting from the " + startDay + "\n" );
		englishBooking.setBody(body);
	}

	@Override
	protected void buildFooter() {
		Double totalPrice = car.getTotalPrice();
		footer.setFooter(car);
		System.out.println("Total price: " + totalPrice + " EUR for the number of " + duration + " day(s).");
		System.out.println("We accept the following payment options: Paypal, Google Wallet or Money Wallet.");
		System.out.println("This booking was carried out on " + today + ". Please keep your booking receipt!");
		System.out.println("Thank you very much for choosing Stabi GmbH!");
		System.out.println("======================End of booking receipt=======================");
	}

	@Override
	public Booking buildBooking() {
		buildHead();
		buildBody();
		buildFooter();
		return englishBooking;
	}

}
