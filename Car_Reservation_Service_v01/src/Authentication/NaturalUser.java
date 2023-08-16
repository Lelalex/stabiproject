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
    private AuthenticationService authenticationservice;
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
            authenticationservice.setPerson(DataBase.getPerson(id));
            chooseCredentialType(authenticationservice.getPerson());
            DataBase.saveAuthentication(authenticationservice);
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

	public int getCredentialType() {
		Scanner CredentialTypeScan = new Scanner(System.in);
		System.out.println("Choose One of the listed Authentication Choices" + "\n" + "Username with Password: 1" + "\n"
				+ "Fingerprint: 2" + "\n" + "Eyescanner: 3" + "\n" + "Go back to MainMenu: 4");
		int credentialType = CredentialTypeScan.nextInt();

		return credentialType;
	}

	public void chooseCredentialType(Person person)
	{
		int credentialType = getCredentialType();

		switch (credentialType) {

		case 1:

			if (password.runStrategy(person))
			{
				authenticationservice.setAuthenticated(true);
			} else {
				System.out.println("Username or password is wrong!");
				chooseCredentialType(person);
				return;
			}
			break;
		case 2: {
			if (fingerprint.runStrategy(person)) {
				authenticationservice.setAuthenticated(true);
			} else {
				System.out.println("Invalid Fingerprint.");
				chooseCredentialType(person);
				return;
			}
			break;

		}
		case 3: {
			if (eyescan.runStrategy(person)) {
				authenticationservice.setAuthenticated(true);
			} else {
				System.out.println("Invalid Eyescan.");
				chooseCredentialType(person);
				return;
			}
			break;
		}
		case 4:
			authenticationservice.setAuthenticated(false);
			break;
		default: {
			System.out.println("Invalid input. Please choose again.");
			this.authenticateSubject();
		}
		}

	}

}
