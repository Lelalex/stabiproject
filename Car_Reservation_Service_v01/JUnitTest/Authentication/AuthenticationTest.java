package Authentication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Person.Address;
import Person.NaturalPerson;

public class AuthenticationTest {
	private AuthenticationService authenticationService;

	@BeforeEach
	public void setUp() {
		authenticationService = new AuthenticationService();
	}

	@Test
	public void testAuthenticationWithValidCredentials() {
		PasswordStrategy strategy = new PasswordStrategy(new PasswordStrategy.TestInputProvider("testUser"));

		Address address = new Address("Test Street", 123, 12345, "Test City");
		NaturalPerson person = new NaturalPerson("Test Name", "Test ID", address, "01.01.2000"); 
		person.setUserName("testUser");
		person.setPassword("testPassword");
		authenticationService.setStrategy(strategy);
		boolean isAuthenticated = authenticationService.authenticate(person);

		assertTrue(isAuthenticated, "The authentication should be successful with valid credentials");
	}
}
