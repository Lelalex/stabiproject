package Person;

import java.util.Scanner;
import Database.DataBase;

public class PersonService {
	public Person createPerson(String name, String type, Address address, String dateOfBirth, String companyName,
			String companyMail) {
		Person person;
		if ("Natural".equalsIgnoreCase(type)) {
			person = new NaturalPerson(name, null, address, dateOfBirth);
		} else if ("Legal".equalsIgnoreCase(type)) {
			person = new LegalPerson(name, null, address, companyName, companyMail);
		} else {
			throw new IllegalArgumentException("Invalid person type");
		}

		DataBase.getInstance().savePerson(person);

		// Ausgabe der ID und des Benutzernamens nach der Registrierung
		System.out.println("Registration successful!");
		System.out.println("Username: " + name);
		System.out.println("ID: " + person.getID());
		return person;
	}

	public static Person createPerson() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Are you using our system as a natural user or legal user? \n");
			System.out.println("Please press (n) for natural user or (l) for legal user.");
			String type = scanner.nextLine();
			if ("n".equalsIgnoreCase(type)) {
				System.out.print("Please enter your name: ");
				String name = scanner.nextLine();
				System.out.print("Please enter your street: ");
				String street = scanner.nextLine();
				System.out.print("Please enter your house number: ");
				int number = scanner.nextInt();
				System.out.print("Please enter your postcode: ");
				int postcode = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Please enter your city: ");
				String city = scanner.nextLine();
				System.out.print("Please enter your date of birth: ");
				String dateOfBirth = scanner.nextLine();

				// create NaturalPerson with TempID
				NaturalPerson person = new NaturalPerson(name, "TEMP_ID", new Address(street, number, postcode, city),
						dateOfBirth);

				// save person to DB, where real ID is set
				DataBase.getInstance().savePerson(person);

				System.out.println("Registration successful!");
				System.out.println("Username: " + name);
				System.out.println("ID: " + person.getID());

				return person;
			} else if ("l".equalsIgnoreCase(type)) {
				System.out.print("Please enter the company name: ");
				String companyName = scanner.nextLine();
				System.out.print("Please enter the street: ");
				String street = scanner.nextLine();
				System.out.print("Please enter your house number: ");
				int number = scanner.nextInt();
				System.out.print("Please enter the postcode: ");
				int postcode = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Please enter the city: ");
				String city = scanner.nextLine();
				System.out.print("Please enter the company mail: ");
				String companyMail = scanner.nextLine();

				LegalPerson person = new LegalPerson(companyName, "TEMP_ID",
						new Address(street, number, postcode, city), companyName, companyMail);

				DataBase.getInstance().savePerson(person);

				System.out.println("Registration successful!");
				System.out.println("Username: " + companyName);
				System.out.println("ID: " + person.getID());

				return person;
			} else {
				System.out.println("Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
			}
		}
	}
}
