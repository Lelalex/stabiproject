package Authentication;

import org.junit.Test;

import Database.DataBase;
import Person.Address;
import Person.NaturalPerson;
import Person.Person;

public class AuthenticationTest {
    

	public void initializeDatabase() {
    	DataBase db = DataBase.getInstance();
   	 
    	Address address = new Address("Test Street", 1, 12345, "Test City");
    	Person person = new NaturalPerson("Test Name", "123", address, "01-01-2000");
    	//id test "2"
    	db.addPerson(2, person);
	}

	@Test
	public void testNaturalUserAuthentication() {
    	System.out.print("Starting authentication for a natural user...\n");
   	 
    	initializeDatabase();  // Datenbank vor dem Start des Tests Initialisieren
   	 
    	NaturalUser naturalUser = new NaturalUser();
    	naturalUser.authenticateSubject();
	}
}


