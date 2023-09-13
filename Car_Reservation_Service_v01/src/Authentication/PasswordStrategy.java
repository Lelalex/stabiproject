package Authentication;
import java.util.Scanner;

import Person.Person;

public class PasswordStrategy implements LoginStrategy {

    @Override
    public boolean runStrategy(Person person) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Expected username: " + person.getUsername()); // Debug-Ausgabe
        System.out.println("Expected password: " + person.getPassword()); // Debug-Ausgabe

        return username.equals(person.getUsername()) && password.equals(person.getPassword());
    
    }

}

