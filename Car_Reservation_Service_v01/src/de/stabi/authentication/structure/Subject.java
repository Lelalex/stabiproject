package de.stabi.authentication.structure;

import java.util.Scanner;

import de.stabi.database.DataBase;
import de.stabi.person.structure.LegalPerson;
import de.stabi.person.structure.NaturalPerson;
import de.stabi.person.structure.Person;

public abstract class Subject {

    protected DataBase dataBase = DataBase.getInstance();
    protected Person person;

    public abstract boolean authenticateSubject();

    public Person getPerson() {
        return this.person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public boolean retry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Invalid input. Would you like to try again? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }



    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            // Benutzer zur Eingabe der Personentyp (natürlich oder legal) auffordern
            System.out.print("Please enter the type of person (n for natural, l for legal): ");
            String personType = scanner.nextLine();
            
            // Benutzer zur Eingabe der ID auffordern
            System.out.print("Please enter your ID: ");
            String id = scanner.nextLine();

            Person person = dataBase.getPersonById(id, personType);
            if (person != null) {
                System.out.println("No person found with this ID.");
            } else {
                System.out.println("No person found with this ID.");
            }

            // Überprüfen Sie den eingegebenen Personentyp und führen Sie die entsprechende Authentifizierung durch
            Subject subject;
            if ("n".equalsIgnoreCase(personType)) {
                subject = new NaturalUser();
            } else if ("l".equalsIgnoreCase(personType)) {
                subject = new SoftwareSystem();
            } else {
                System.out.println("Invalid person type. Please retry.");
                if(!retry()) {
                    return false;
                }
                continue;
            }

            subject.setPerson(person);
            boolean success = subject.authenticateSubject();
            if(success) {
                System.out.println("Authentication successful!");
                return true;
            } else {
                if(!retry()) {
                    return false;
                }
            }
        }
    }

}
