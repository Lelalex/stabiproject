//package Authentication;
//
//import java.util.Scanner;
//
//import Person.Person;
//
//import Database.DataBase;
//
//public class NaturalUser extends Subject {
//
//	private DataBase DataBase = DataBase.getEntry();
//	
//	private boolean authenticationPossible;
//	private AuthenticationService authenticationservice;
//
//	private PasswordStrategy password = new PasswordStrategy();
//	private FingerPrintStrategy fingerprint = new FingerPrintStrategy();
//	private EyeScanStrategy eyescan = new EyeScanStrategy();
//
//	public boolean isAuthenticationPossible() {
//		return authenticationPossible;
//	}
//
//	public void setAuthenticationPossible(boolean authenticationPossible) {
//		this.authenticationPossible = authenticationPossible;
//	}
//
//	@Override
//	// insert concrete implementation to auth. natuser and save to DB
//	public void authenticateSubject() {
//		int id = this.getId();
//		checkID(id);
//		if (authenticationPossible == true) {
//			authenticationservice.setPerson(DataBase.getPerson(id));
//			chooseCredentialType(authenticationservice.getPerson());
//			DataBase.saveAuthentication(authenticationservice);
//		}
//	}
package Authentication;

import java.util.Scanner;
import Person.Person;
import Database.DataBase;

public class NaturalUser extends Subject {

	private DataBase DataBase; // Felddeklaration
	private boolean authenticationPossible;
	private AuthenticationService authenticationService;
	private PasswordStrategy password = new PasswordStrategy();
	private FingerPrintStrategy fingerprint = new FingerPrintStrategy();
	private EyeScanStrategy eyescan = new EyeScanStrategy();

	public NaturalUser() {
		DataBase = DataBase.getInstance(); // Initialisierung im Konstruktor
	}

	public boolean isAuthenticationPossible() {
		return authenticationPossible;
	}

	public void setAuthenticationPossible(boolean authenticationPossible) {
		this.authenticationPossible = authenticationPossible;
	}

	@Override
	public void authenticateSubject() {
		int id = this.getId();
		checkID(id);
		if (authenticationPossible) {
			Person person = DataBase.getPerson(id);
			authenticationService.setPerson(person);
			authenticationService.authenticateSubject();

			if (authenticationService.isAuthenticated()) {
				DataBase.saveAuthentication(authenticationService);
			} else {
				System.out.println("Authentication failed for this Natural User.");
			}
		} else {
			System.out.println("Authentication is not possible for this ID.");
		}
	}

	public void checkID(int id) {
		// check Input PersonID via COnsole and check for not null
		// set boolean true/false after check of Person ID

		Person person = DataBase.getPerson(id);
		if (person != null)
		// && person.getClass().equals(person.getClass()))
		{
			authenticationPossible = true;
			return;
		} else {
			if (this.retry()) {
				this.authenticateSubject();
				return;
			} else
				authenticationPossible = false;
			return;
		}
	}
}
