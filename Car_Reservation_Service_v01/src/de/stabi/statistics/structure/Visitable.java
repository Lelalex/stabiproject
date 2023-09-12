package de.stabi.statistics.structure;

import de.stabi.payment.structure.PaymentType;

public interface Visitable {
	
	void accept(Visitor visitor, PaymentType paymentType, int bookingLanguage);

}
