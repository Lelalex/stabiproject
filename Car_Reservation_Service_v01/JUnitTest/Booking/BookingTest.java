package Booking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import Person.NaturalPerson;
import Person.Person;
import Ressource.Car;
import Ressource.Ressource;
import Ressource.RessourceService;

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
//        person.setName("John");
        
//        RessourceService ressourceServ = new RessourceService();
//        ressourceServ.getSelectedRessource();
        
//        bookServ.setPerson(person);
//        car = car.setRessource(); 
//        car.getCost(70.0);
        Booking booking = bookServ.createBooking();
        Assert.assertNotNull(booking);
    }
}
