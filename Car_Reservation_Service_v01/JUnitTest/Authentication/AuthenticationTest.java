package Authentication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Database.DataBase;
import Person.LegalPerson;
import Person.NaturalPerson;

class AuthenticationTest {

	private AuthenticationService authenticationService; 
	private NaturalPerson person = new NaturalPerson(); 
	private LegalPerson legalPerson = new LegalPerson();
	private DataBase db = DataBase.getEntry();
	
	@BeforeEach
	void setUp() throws Exception {
		authenticationService = new AuthenticationService();
		person.setUserName("TestPerson");
		person.setPassword("Test");
		legalPerson.setUserName("TestCompany");
		legalPerson.setPassword("Test");
		db.savePerson(person); //id=1
		db.savePerson(legalPerson); //id=2
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		person = null; 
		legalPerson = null; 
		db = null; 
		authenticationService = null; 
	}

	@Test
	void canUserBeAuthenticated() 
	{
		authenticationService.authenticateSubject();
	}

}
