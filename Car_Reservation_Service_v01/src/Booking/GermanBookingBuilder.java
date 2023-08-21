package Booking;

import Person.Person;

public class GermanBookingBuilder extends BookingBuilder {

	public GermanBookingBuilder(Person person, CarConfiguration car, int duration, String startDay) {
		super(person, car, duration, startDay);
	}

	private double price;
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
		price = duration * car.getPricePerDay();
		footer.setFooter(price, "DE123456789");
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
