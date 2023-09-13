package Authentication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Database.DataBase;
import Person.Address;
import Person.LegalPerson;
import Person.NaturalPerson;

public class AuthenticationTest {

    private AuthenticationService authenticationService;
    private DataBase dataBase;

    @BeforeEach
    public void setUp() {
        authenticationService = new AuthenticationService();
        dataBase = DataBase.getInstance();
        
        // add Test Data NaturalPerson
        Address address = new Address("Test Street", 123, 12345, "Test City");
        NaturalPerson naturalPerson = new NaturalPerson("Test Name", "user1", "user2", "N1", address, "01.01.2000");
        dataBase.addTestData(naturalPerson);
        
        // add Test Data LegalPerson 
        LegalPerson legalPerson = new LegalPerson("compuser", "campname", "comppass", "L1", address, "gmbh", "mail");

        dataBase.addTestData(legalPerson);
    
        dataBase.printPersonDetails("1");
        
    }

    @Test
    public void testAuthenticationWithValidCredentials() {
        NaturalUser naturalUser = new NaturalUser();
        
        boolean isAuthenticated = naturalUser.authenticate();

        assertTrue(isAuthenticated, "The authentication should be successful with valid credentials");
    }

}
