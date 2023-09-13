package Authentication;

import Database.DataBase;
import Person.Person;


//also mit der datenbank soll aufjedenfall was gemacht werden, 
//und der code ist noch lange vorm laufen laos meich bitte pur mit dem code weiter

public class AuthenticationService {
    private LoginStrategy strategy;
    private boolean authenticated = false;
    private Person person;
    private DataBase dataBase = DataBase.getInstance();
    
    public void setStrategy(LoginStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public boolean authenticateSubject() {
        if(strategy != null && person != null) {
            authenticated = strategy.runStrategy(person);
            return authenticated;
        } else {
            System.out.println("Strategy or person not set.");
            return false;
        }
    }


    // Hier überprüfen Sie, ob die Authentifizierung erfolgreich war
    public boolean isAuthenticated() {
        return authenticated;
    }

    public boolean authenticate() {
        if(strategy != null && person != null) {
            authenticated = strategy.runStrategy(person);
            return authenticated;
        } else {
            System.out.println("Strategy or person not set.");
            return false;
        }
    }

}
