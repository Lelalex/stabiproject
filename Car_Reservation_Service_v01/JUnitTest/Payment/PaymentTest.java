package Payment;

import org.junit.Test;

import Booking.BookingService;
import Person.PersonService;

public class PaymentTest {

	private Account senderAccount ;
	private Account receiverAccount;
	private CurrencyAmount amount;
	private String paymentMethod;
	private String email;
	private String password;

	@Test
	public void testPayment() {
		System.out.print("Creating a payment...\n");
		PaymentService paymentService = new PaymentService();
		BookingService bookingService = new BookingService();
		PersonService personService = new PersonService();
		
		
//		email = "werner@gmx.de";
//		password = "password123";
//		amount = new CurrencyAmount(12.34, "EUR");
//		senderAccount = new Account("Julian Werner", "werner@gmx.de", 100000);
//		receiverAccount = receiverAccount.getReceiverAccount();
		paymentService.payAmount();
	}

}
