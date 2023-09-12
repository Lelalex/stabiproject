package de.stabi.authentication.structure;

import java.util.Scanner;

import de.stabi.authentication.behaviour.AuthenticationService;
import de.stabi.database.DataBase;
import de.stabi.person.structure.Person;

public class NaturalUser extends Subject {

    private AuthenticationService authenticationService;

    public NaturalUser() {
        this.dataBase = DataBase.getInstance();
        this.authenticationService = new AuthenticationService();
    }

    @Override
    public boolean authenticateSubject() {
        if (person == null) {
            System.out.println("Authentication is not possible for this ID.");
            return false;
        }

        // Setzen Sie die Person für den AuthenticationService
        authenticationService.setPerson(person);

        // Führen Sie die Authentifizierungsstrategie aus
        executeCredentialType(person);
        
        return authenticationService.isAuthenticated();
    }

    public boolean executeCredentialType(Person person) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an authentication method:");
            System.out.println("1. Username with Password");
            System.out.println("2. Eye Scan");
            System.out.println("3. Finger Print");
            System.out.println("4. Go back to main menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    authenticationService.setStrategy(new PasswordStrategy());
                    break;
                case 2:
                    authenticationService.setStrategy(new EyeScanStrategy());
                    break;
                case 3:
                    authenticationService.setStrategy(new FingerPrintStrategy());
                    break;
                case 4:
                    return false; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            authenticationService.authenticateSubject();
            if (authenticationService.isAuthenticated()) {
                
                return true;
            } else {
                System.out.println("Authentication failed. Please try again.");
            }
        }
    }

}
