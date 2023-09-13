package Booking;

import org.junit.Assert;
import org.junit.Test;

import Person.Person;
import Person.PersonService;
import Ressource.Ressource;

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
        PersonService personServ = new PersonService();
        Person person = personServ.createPerson();
//		Person person = new NaturalPerson("Leander", "Lele", "lele", "01", null, "15.06.97");
//		car = new Car("VW Bus", "LG XX 45", "white", 70.0);
        
     	double totalPrice = 900.00;
        Booking booking = bookServ.createBooking(person);
        Assert.assertNotNull(booking);
    }
}
