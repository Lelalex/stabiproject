package de.stabi.statistics.structure;

import de.stabi.booking.structure.Booking;
import de.stabi.payment.structure.PaymentType;

public interface Visitor {
	
	public void visit(Booking booking, PaymentType paymentType, int bookingLanguage);
	public void displayStatistics();

}
