package Statistics;

import Payment.PaymentType;

public interface Visitable {
	
	void accept(Visitor visitor, PaymentType paymentType, int bookingLanguage);

}
