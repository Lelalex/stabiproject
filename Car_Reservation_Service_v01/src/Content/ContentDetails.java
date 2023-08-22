package Content;

import Booking.Booking;

public class ContentDetails {
	
	private Booking booking;
	private Payment payment;
	
	public ContentDetails(Booking booking, Payment payment) {
		this.booking = booking;
		this.payment = payment;
	}
	
	public Booking getBooking() {
		return booking;
	}
	
	public Payment getPayment() {
		return payment;
	}

}
