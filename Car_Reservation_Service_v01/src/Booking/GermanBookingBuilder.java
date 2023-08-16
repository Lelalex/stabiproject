package Booking;

import Person.Person;
import resource.model.CarConfiguration;

public class GermanBookingBuilder extends Builder {

	public GermanBookingBuilder(Person person, CarConfiguration car, int duration, String startDay) {
		super(person, car, duration, startDay);
	}

	private double price = duration * car.getPricePerDay();
	private Head head = new Head();
	private Body body = new Body();
	private Footer footer = new Footer();
	private GermanBooking germanBooking = new GermanBooking();

	// GermanHead
	@Override
	protected void buildHead() {
		head.setHead(person.getName(), person.getAddress(), person.getMail());
		germanBooking.setHead(head);
	}

	// GermanBody 
	@Override
	protected void buildBody() {
		body.setBody(car, duration, startDay, car.getPricePerDay());
		germanBooking.setBody(body);

	}

	// GermanFooter
	@Override
	protected void buildFooter() {
		footer.setFooter(price, "DE123456789");
		germanBooking.setFooter(footer);

	}

	@Override
	protected Booking buildBooking() {
		return this.germanBooking;
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
