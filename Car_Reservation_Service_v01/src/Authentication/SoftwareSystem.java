package Authentication;

import Person.Person;

public class SoftwareSystem {
    
    private AuthenticationService authenticationservice;  

    public SoftwareSystem() {
        this.authenticationservice = new AuthenticationService();  
    }

    public void executeCredentialType(Person person) {
        PasswordStrategy passwordStrategy = new PasswordStrategy();  

        if(passwordStrategy.runStrategy(person)) {
            authenticationservice.setAuthenticated(true);
        }
        else {
            System.out.println("Username or password is wrong!");
            executeCredentialType(person);
        }
    }
}
