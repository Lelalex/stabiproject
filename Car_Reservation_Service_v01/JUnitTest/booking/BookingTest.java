package booking;

import org.junit.Assert;
import org.junit.Test;

import de.stabi.booking.behaviour.BookingService;
import de.stabi.booking.structure.Booking;
import de.stabi.person.structure.Person;
import de.stabi.ressource.structure.Ressource;

public class BookingTest {

//    private PersonService personServ;
//    private RessourceService ressourceServ;
	private BookingService bookServ;
	private Person person;
	private Ressource car;

//	@BeforeEach
//	void setUp() {
////        personServ = new PersonService();
//		bookServ = new BookingService();
//		person = new NaturalPerson();
//		car = new Car("VW Bus", "LG XX 45", "white", 70.0);
//	}
//
//	@AfterEach
//	void tearDown() {
////        personServ = null;
////        ressourceServ = null;
//        person = null;
//        car = null;
//		bookServ = null;
//	}

	@Test
    public void testCreateBooking() {
        System.out.println("Creating a booking request...");
        bookServ = new BookingService();
//		person = new NaturalPerson();
//		car = new Car("VW Bus", "LG XX 45", "white", 70.0);
        
     	double totalPrice = 900.00;
        Booking booking = bookServ.createBooking(person, totalPrice);
        Assert.assertNotNull(booking);
    }
}
