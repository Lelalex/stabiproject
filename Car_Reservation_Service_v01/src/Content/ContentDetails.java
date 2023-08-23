package Content;

import Booking.Booking;
import Payment.PaymentService;

public class ContentDetails {
	
	private Booking booking;
	private PaymentService payment;
	
	public ContentDetails(Booking booking, PaymentService payment) {
		this.booking = booking;
		this.payment = payment;
	}
	
	public Booking getBooking() {
		return booking;
	}
	
	public PaymentService getPayment() {
		return payment;
	}

}
