package de.stabi.person.behaviour;

import java.util.Scanner;

import de.stabi.database.DataBase;
import de.stabi.person.structure.Address;
import de.stabi.person.structure.LegalPerson;
import de.stabi.person.structure.NaturalPerson;
import de.stabi.person.structure.Person;

public class PersonService {
	public Person createPerson(String name, String username, String password, String type, Address address,
			String dateOfBirth, String companyName, String companyMail) {
		Person person;
		if ("Natural".equalsIgnoreCase(type)) {
			person = new NaturalPerson(name, username, password, null, address, dateOfBirth); // ID is set in the next
																								// line
			DataBase.getInstance().savePerson((NaturalPerson) person);
		} else if ("Legal".equalsIgnoreCase(type)) {
			person = new LegalPerson(name, username, password, null, address, companyName, companyMail);
			DataBase.getInstance().savePerson((LegalPerson) person);
		} else {
			throw new IllegalArgumentException("Invalid person type");
		}

		return person;
	}

	public static Person createPerson() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n=================");
			System.out.println("   Registration");
			System.out.println("=================");
			System.out.print("Are you a natural or legal person? (n/l): ");

			String type = scanner.nextLine();

			if ("n".equalsIgnoreCase(type) || "l".equalsIgnoreCase(type)) {
				System.out.print("Please enter your name: ");
				String name = scanner.nextLine();

				System.out.print("Please enter your username: ");
				String username = scanner.nextLine();

				System.out.print("Please enter your password: ");
				String password = scanner.nextLine();

				System.out.print("Please enter your street: ");
				String street = scanner.nextLine();

				System.out.print("Please enter your house number: ");
				int number = scanner.nextInt();

				System.out.print("Please enter your postcode: ");
				int postcode = scanner.nextInt();

				scanner.nextLine(); // consume the remaining newline
				System.out.print("Please enter your city: ");
				String city = scanner.nextLine();

				Address address = new Address(street, number, postcode, city);

				if ("n".equalsIgnoreCase(type)) {
					System.out.print("Please enter your date of birth: ");
					String dateOfBirth = scanner.nextLine();

					NaturalPerson person = new NaturalPerson(name, username, password, null, address, dateOfBirth);

					DataBase.getInstance().savePerson(person);

					System.out.println("\nRegistration successful!");
					System.out.println("Username: " + username);
					System.out.println("ID: " + person.getId().substring(1));
					System.out.println("=================\n");

					return person;
				} else if ("l".equalsIgnoreCase(type)) {
					System.out.print("Please enter the company name: ");
					String companyName = scanner.nextLine();

					System.out.print("Please enter the company mail: ");
					String companyMail = scanner.nextLine();

					LegalPerson person = new LegalPerson(name, username, password, null, address, companyName,
							companyMail);

					DataBase.getInstance().savePerson(person);

					System.out.println("\nRegistration successful!");
					System.out.println("Username: " + username);
					System.out.println("ID: " + person.getId().substring(1));
					System.out.println("=================\n");

					return person;
				} else {
					System.out.println("Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
				}
			} else {
				System.out.println("Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
			}
		}
	}
}
