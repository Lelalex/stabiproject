package Authentication;

import Person.Person;

public class SoftwareSystem {
    
    private AuthenticationService authenticationservice;  // assuming that Authentication is a class you have defined elsewhere

    public SoftwareSystem() {
        this.authenticationservice = new AuthenticationService();  // you might need to pass some arguments depending on the constructor of Authentication class
    }

    public void executeCredentialType(Person person) {
        PasswordStrategy passwordStrategy = new PasswordStrategy();  // create an object of PasswordStrategy

        if(passwordStrategy.runStrategy(person)) {
            authenticationservice.setAuthenticated(true);
        }
        else {
            System.out.println("Username or password is wrong!");
            executeCredentialType(person);
        }
    }
}
