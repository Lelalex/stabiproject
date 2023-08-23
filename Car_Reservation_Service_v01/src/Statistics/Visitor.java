package Statistics;

import Booking.Booking;
import Payment.PaymentType;

public interface Visitor {
	
	public void visit(Booking booking, PaymentType paymentType, int bookingLanguage);
	public void displayStatistics();

}
