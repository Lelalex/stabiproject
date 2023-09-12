package authentication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.stabi.authentication.behaviour.AuthenticationService;
import de.stabi.authentication.structure.NaturalUser;
import de.stabi.database.DataBase;
import de.stabi.person.structure.Address;
import de.stabi.person.structure.LegalPerson;
import de.stabi.person.structure.NaturalPerson;

public class AuthenticationTest {

    private AuthenticationService authenticationService;
    private DataBase dataBase;

    @BeforeEach
    public void setUp() {
        authenticationService = new AuthenticationService();
        dataBase = DataBase.getInstance();
        
        // Hinzufügen von Testdaten für NaturalPerson
        Address address = new Address("Test Street", 123, 12345, "Test City");
        NaturalPerson naturalPerson = new NaturalPerson("Test Name", "user1", "user2", "1", address, "01.01.2000");
        dataBase.addTestData(naturalPerson);
        
        // Hinzufügen von Testdaten für LegalPerson (angenommen, dass Sie eine ähnliche Konstruktor für LegalPerson haben)
        LegalPerson legalPerson = new LegalPerson("compuser", "campname", "comppass", "1", address, "gmbh", "mail");

        dataBase.addTestData(legalPerson);
    
        dataBase.printPersonDetails("1");
        
    }

    @Test
    public void testAuthenticationWithValidCredentials() {
        // Erstellen eines NaturalUser-Objekts
        NaturalUser naturalUser = new NaturalUser();
        
        // Rufen Sie die authenticate Methode auf dem NaturalUser-Objekt auf, um den Authentifizierungsprozess zu starten
        boolean isAuthenticated = naturalUser.authenticate();

        // Überprüfen Sie, ob die Authentifizierung erfolgreich war
        assertTrue(isAuthenticated, "The authentication should be successful with valid credentials");
    }

}
