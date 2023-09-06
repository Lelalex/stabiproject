package Authentication;

import java.util.Scanner;

import Person.LegalPerson;
import Person.NaturalPerson;
import Person.Person;

public class AuthenticationService {

	private boolean isAuthenticated;
	private Person person;
	private LoginStrategy fixedStrategy;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	//for Test Use
	public void setFixedStrategy(LoginStrategy fixedStrategy) {
        this.fixedStrategy = fixedStrategy;
    }

	public void authenticateSubject() {
		if (person == null) {
			setAuthenticated(false);
			return;
		}

		if (person instanceof NaturalPerson) {
			LoginStrategy loginStrategy = (fixedStrategy != null) ? fixedStrategy : chooseLoginStrategy();
			if (loginStrategy.runStrategy(person)) {
				setAuthenticated(true);
			} else {
				setAuthenticated(false);
				System.out.println("Authentication failed. Please try again!");
			}
		} else if (person instanceof LegalPerson) {
			SoftwareSystem softwareSystem = new SoftwareSystem();
			softwareSystem.executeCredentialType(person);
			if (softwareSystem.isAuthenticated()) {
				setAuthenticated(true);
			} else {
				setAuthenticated(false);
				System.out.println("Authentication failed. Please try again!");
			}
		} else {
			setAuthenticated(false);
			System.out.println("Authentication failed: This person is unknown.");
		}
	}

	private LoginStrategy chooseLoginStrategy() {
		Scanner CredentialTypeScan = new Scanner(System.in);
		System.out.println("Choose One of the listed Authentication Choices" + "\n" + "Username with Password: 1" + "\n"
				+ "Fingerprint: 2" + "\n" + "Eyescanner: 3" + "\n" + "Go back to MainMenu: 4");
		int credentialType = CredentialTypeScan.nextInt();
		switch (credentialType) {
		case 1:
			return new PasswordStrategy();
		case 2:
			return new EyeScanStrategy();
		case 3:
			return new FingerPrintStrategy();
		default:
			return new PasswordStrategy();
		}
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
}
