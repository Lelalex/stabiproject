package statistics;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.stabi.booking.behaviour.BookingService;
import de.stabi.payment.behaviour.PaymentService;
import de.stabi.payment.structure.Account;
import de.stabi.payment.structure.CurrencyAmount;
import de.stabi.person.behaviour.PersonService;
import de.stabi.person.structure.Person;
import de.stabi.statistics.behaviour.StatisticsService;

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
		bookingService.createBooking(person, 900.00);
		
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
