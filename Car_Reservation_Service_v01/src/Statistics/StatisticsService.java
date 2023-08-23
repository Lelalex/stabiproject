package Statistics;

import java.util.List;

import Booking.Booking;
import Payment.PaymentType;

public class StatisticsService {

	public StatisticsService() {
		// TODO Auto-generated constructor stub
	}

	private StatisticsVisitor visitor = new StatisticsVisitor();

//	public void collectStatistics(List<Booking> bookings, List<PaymentType> paymentTypes) {

//        StatisticsVisitor visitor = new StatisticsVisitor();
//        for (int i = 0; i < bookings.size(); i++) {
//            Booking booking = bookings.get(i);
//            PaymentType paymentType = paymentTypes.get(i); 
//            booking.accept(visitor, paymentType);
//        }
//        visitor.displayStatistics();
//	}

	public void collectStatistics(List<Booking> bookings, List<PaymentType> paymentTypes,
			List<Integer> bookingLanguages) {
		for (int i = 0; i < bookings.size(); i++) {
			Booking booking = bookings.get(i);
			PaymentType paymentType = paymentTypes.get(i);
			int bookingLanguage = bookingLanguages.get(i);
			visitor.visit(booking, paymentType, bookingLanguage);
		}
	}

	public void displayStatistics() {
		visitor.displayStatistics();
	}
}
