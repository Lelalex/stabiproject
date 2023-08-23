package Booking;

import Payment.PaymentType;
import Statistics.StatisticsVisitor;

public class EnglishBooking extends Booking {
	private Head head = new Head();
	private Body body = new Body();
	private Footer footer = new Footer();

	@Override
	public void setHead(Head head) {
		this.head = head;

	}

	@Override
	public void setBody(Body body) {
		this.body = body;
	}

	@Override
	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	@Override
	public Head getHead() {
		return this.head;
	}

	@Override
	public Body getBody() {
		return this.body;
	}

	@Override
	public Footer getFooter() {
		return this.footer;
	}

	@Override
	public double getPrice() {
		return footer.getPrice();
	}
	
	@Override
	public void accept(StatisticsVisitor visitor, PaymentType paymentType, int bookingLanguage) {
	    visitor.visit(this, paymentType, bookingLanguage);
	}
}
