package Authentication;

import java.util.Scanner;
import Person.Person;

public class AuthenticationService {
	private LoginStrategy strategy;
	private boolean isAuthenticated;
	private boolean authenticated = false;
	private Person person;

	public void setStrategy(LoginStrategy strategy) {
		this.strategy = strategy;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void authenticateSubject() {
		if (strategy != null && person != null) {
			authenticated = strategy.runStrategy(person);
		} else {
		}
	}

	// Check if Auth was successfull
	public boolean isAuthenticated() {
		return authenticated;
	}

	public boolean authenticate(Person person) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Are you a natural or legal person? (n/l): ");
		String type = scanner.nextLine();

		if ("n".equalsIgnoreCase(type)) {
			System.out.println("1. Username with Password");
			System.out.println("2. Fingerprint");
			System.out.println("3. Eye scanner");
			System.out.println("4. Go back to main menu");
		} else if ("l".equalsIgnoreCase(type)) {
			System.out.println("1. Username with Password");
			System.out.println("2. Go back to main menu");
		} else {
			System.out.println("Invalid choice");
			return false;
		}
		int choice = scanner.nextInt();
		scanner.nextLine(); 
		switch (choice) {
		case 1:
			strategy = new PasswordStrategy(new PasswordStrategy.ScannerInputProvider());
			break;
		case 2:
			if ("n".equalsIgnoreCase(type)) {
				strategy = new FingerPrintStrategy();
			} else {
				// Go back to the main menu
				return false;
			}
			break;
		case 3:
			if ("n".equalsIgnoreCase(type)) {
				strategy = new EyeScanStrategy();
			} else {
				System.out.println("Invalid choice");
				return false;
			}
			break;
		case 4:
			if ("n".equalsIgnoreCase(type)) {
				// Go back to the main menu
				return false;
			}
			break;
		default:
			System.out.println("Invalid choice");
			return false;
		}
		if (strategy != null) {
			return strategy.runStrategy(person);
		}
		return false;
	}
}
