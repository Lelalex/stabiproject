package Statistics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Booking.BookingService;
import Payment.Account;
import Payment.CurrencyAmount;
import Payment.PaymentService;
import Person.Person;
import Person.PersonService;

class StatisticsTest {
	
	private StatisticsService statisticsService;
	private BookingService bookingService;
	private PaymentService paymentService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStatisticsService() {
		Person person = PersonService.createPerson();
		BookingService bookingService = new BookingService();
		bookingService.createBooking(person);
		
		String accountName = person.getUsername();
        Account senderAccount = new Account("SenderAccount", accountName, 900.00);
		Account receiverAccount = Account.getReceiverAccount();
		
		CurrencyAmount amount = new CurrencyAmount(900.00, "EUR");
        
        String email = person.geteMail();
        String password = person.getPassword();
        
        PaymentService paymentService = new PaymentService();
		paymentService.payAmount(senderAccount, receiverAccount, amount, email, password);
			
		StatisticsService statisticsService = new StatisticsService();
		statisticsService.displayStatistics();
	}
	
//	@Test
//	void testDummyBookings() {
//		
//		for (int i = 0; i < 10; i++) {
//            // Create dummy bookings with different parameters
//            // bookingService.createBooking(...); // Create a booking
//            // paymentService.payAmount(...); // Make a payment
//        }
//		
//		statisticsService.displayStatistics();
//	}

}
