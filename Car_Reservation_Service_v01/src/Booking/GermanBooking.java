package Booking;

public class GermanBooking extends Booking {
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

//    @Override
//    public double getPrice() {
//        return 0;
//    }

//	@Override
//	public void accept(Visitor visitor, PaymentType paymentType, int bookingLanguage) {
//		visitor.visit(this, paymentType, bookingLanguage);
//	}
}
