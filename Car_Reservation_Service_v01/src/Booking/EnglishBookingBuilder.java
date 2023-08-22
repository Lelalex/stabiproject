package Booking;

import Person.Person;
import Ressource.Car;

public class EnglishBookingBuilder extends BookingBuilder {

	public EnglishBookingBuilder(Person person, Car car, int duration, String startDay) {
		super(person, car, duration, startDay);
	}
	
	private double price;
	private Head head = new Head();
	private Body body = new Body();
	private Footer footer = new Footer();
	private EnglishBooking englishBooking = new EnglishBooking();
	
	// GermanHead
	@Override
	protected void buildHead() {
		head.setHead(person.getName(), person.getAddress(), person.getMail());
		englishBooking.setHead(head);
	}

	// GermanBody 
	@Override
	protected void buildBody() {
		body.setBody(car, duration, startDay, car.getCost());
		englishBooking.setBody(body);

	}

	// GermanFooter
	@Override
	protected void buildFooter() {
		price = duration * car.getCost();
		footer.setFooter(price, "DE123456789");
		englishBooking.setFooter(footer);

	}

	@Override
	protected Booking buildBooking() {
		buildHead();
        buildBody();
        buildFooter();
        return englishBooking;
	}

}