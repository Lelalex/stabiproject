//package Authentication;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Order;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import Booking.Booking;
//import Content.ContentDetails;
//import Payment.PaymentService;
//import Person.Address;
//import Person.LegalPerson;
//import Person.NaturalPerson;
//
//public class AuthenticationTest2 {
//
//	private AuthenticationService authService;
//	private NaturalPerson naturalPerson;
//	private LegalPerson legalPerson;
//
//	@BeforeEach
//	public void setUp() {
//		authService = new AuthenticationService();
//		
//		Address address = new Address("Hamburger Allee", 01, 12345);
//		naturalPerson = new NaturalPerson("Felix", "1", address, "23/04/1986");
//		legalPerson = new LegalPerson("Julia System", "2", address, "234569");
//		
//	}
//
//	@AfterEach
//	public void tearDown() {
//		authService = null;
//		naturalPerson = null;
//		legalPerson = null;
//	}
//
//	@Test
//	@Order(1)
//	public void testIsAuthenticated() {
//		authService.setAuthenticated(true);
//		assertTrue(authService.isAuthenticated());
//
//		authService.setAuthenticated(false);
//		assertFalse(authService.isAuthenticated());
//		System.out.println("AuthenticationService is usable");
//	}
//
//	@Test
//	@Order(2)
//	public void testAuthenticateSubjectWithNaturalPerson() {
//		authService.setPerson(naturalPerson);
//		System.out.println("===== Start NaturalPerson Test =====");
//
//		// use TestCase Method in AuthenticationService and set Fixed Strategy
//		authService.setFixedStrategy(new PasswordStrategy());
//
//		authService.authenticateSubject();
//
//		assertTrue(authService.isAuthenticated());
//		System.out.println("Authentication of Natural Person successful!");
//		System.out.println("===== End NaturalPerson Test =====");
//	}
//
//	@Test
//	@Order(3)
//	public void testAuthenticateSubjectWithLegalPerson() {
//		authService.setPerson(legalPerson);
//		
//
//	    System.out.println("===== Start LegalPerson Test =====");
//
//		// simulate implementation for LegalPerson = Softwaresystem to check
//		// authentication
//		SoftwareSystem softwareSystem = new SoftwareSystem();
//		PasswordStrategy passwordStrategy = new PasswordStrategy();
//		if (passwordStrategy.runStrategy(legalPerson)) {
//			softwareSystem.setAuthenticated(true);
//		} else {
//			softwareSystem.setAuthenticated(false);
//		}
//
//		// check if authentification sucessful
//		assertTrue(softwareSystem.isAuthenticated());
//
//		authService.authenticateSubject();
//
//		assertTrue(authService.isAuthenticated());
//		System.out.println("Authentication of Legal Person successful!");
//
//	    System.out.println("===== Ending LegalPerson Test =====");
//	}
//
//}
