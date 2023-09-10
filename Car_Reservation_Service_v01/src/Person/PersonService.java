package Person;

import java.util.Scanner;
import Database.DataBase;

class PersonService {
	public Person createPerson(String name, String type, Address address, String dateOfBirth, String companyName, String companyMail) {
    	Person person;
    	if ("Natural".equalsIgnoreCase(type)) {
        	person = new NaturalPerson(name, null, address, dateOfBirth); // ID wird später gesetzt
    	} else if ("Legal".equalsIgnoreCase(type)) {
        	person = new LegalPerson(name, null, address, companyName, companyMail); // ID wird später gesetzt
    	} else {
        	throw new IllegalArgumentException("Invalid person type");
    	}

    	DataBase.getInstance().savePerson(person); // Hier wird die ID gesetzt

    	// Ausgabe der ID und des Benutzernamens nach der Registrierung
    	System.out.println("Registration successful!");
    	System.out.println("Username: " + name);
    	System.out.println("ID: " + person.getID());

    	return person;
	}


	public static Person createPerson() {
    	Scanner scanner = new Scanner(System.in);
    	while (true) {
        	System.out.print("Are you a natural or legal person? (n/l): ");
        	String type = scanner.nextLine();
        	if ("n".equalsIgnoreCase(type)) {
            	System.out.print("Please enter your name: ");
            	String name = scanner.nextLine();
            	// ... (die restlichen Eingabeaufforderungen und die Erstellung der Adresse)
            	System.out.print("Please enter your street: ");
            	String street = scanner.nextLine();
            	System.out.print("Please enter your house number: ");
            	int number = scanner.nextInt();
            	System.out.print("Please enter your postcode: ");
            	int postcode = scanner.nextInt();
            	scanner.nextLine(); // consume the remaining newline
            	System.out.print("Please enter your city: ");
            	String city = scanner.nextLine();
            	System.out.print("Please enter your date of birth: ");
            	String dateOfBirth = scanner.nextLine();
           	 
            	// Erstellen Sie die NaturalPerson Instanz mit einer temporären ID
            	NaturalPerson person = new NaturalPerson(name, "TEMP_ID", new Address(street, number, postcode, city), dateOfBirth);
           	 
            	// Speichern Sie die Person in der Datenbank, wo die echte ID gesetzt wird
            	DataBase.getInstance().savePerson(person);
           	 
            	// Geben Sie die Details der neuen Person aus
            	System.out.println("Registration successful!");
            	System.out.println("Username: " + name);
            	System.out.println("ID: " + person.getID());
           	 
            	return person;
        	}
        	else if ("l".equalsIgnoreCase(type)) {
            	System.out.print("Please enter the company name: ");
            	String companyName = scanner.nextLine();
            	System.out.print("Please enter the street: ");
            	String street = scanner.nextLine();
            	System.out.print("Please enter your house number: ");
            	int number = scanner.nextInt();
            	System.out.print("Please enter the postcode: ");
            	int postcode = scanner.nextInt();
            	scanner.nextLine(); // consume the remaining newline
            	System.out.print("Please enter the city: ");
            	String city = scanner.nextLine();
            	System.out.print("Please enter the company mail: ");
            	String companyMail = scanner.nextLine();
           	 
            	// Erstellen Sie die LegalPerson Instanz mit einer temporären ID
            	LegalPerson person = new LegalPerson(companyName, "TEMP_ID", new Address(street, number, postcode, city), companyName, companyMail);
           	 
            	// Speichern Sie die Person in der Datenbank, wo die echte ID gesetzt wird
            	DataBase.getInstance().savePerson(person);
           	 
            	// Geben Sie die Details der neuen Person aus
            	System.out.println("Registration successful!");
            	System.out.println("Username: " + companyName);
            	System.out.println("ID: " + person.getID());
           	 
            	return person;
        	}
        	else {
            	System.out.println("Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
        	}
    	}
	}
}


