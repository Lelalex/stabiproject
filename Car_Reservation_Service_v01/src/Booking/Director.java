package Booking;

public class Director {

	private BookingBuilder bookingBuilder;

	public void setBuilder(BookingBuilder bookingBuilder) {
		this.bookingBuilder = bookingBuilder;
	}

	public BookingBuilder getBuilder() {
		return this.bookingBuilder;
	}

	// director creates booking
	public Booking createBooking() 
	{
		this.bookingBuilder.buildHead();
		this.bookingBuilder.buildBody();
		this.bookingBuilder.buildFooter();
		Booking booking = bookingBuilder.buildBooking();
		return booking;
	}

}