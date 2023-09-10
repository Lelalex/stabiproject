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
//    private DataBase DataBase = DataBase.getEntry();
//    
//    private boolean authenticationPossible;
//    private AuthenticationService authenticationservice;
//
//    private PasswordStrategy password = new PasswordStrategy();
//    private FingerPrintStrategy fingerprint = new FingerPrintStrategy();
//    private EyeScanStrategy eyescan = new EyeScanStrategy();
//
//    public boolean isAuthenticationPossible() {
//   	 return authenticationPossible;
//    }
//
//    public void setAuthenticationPossible(boolean authenticationPossible) {
//   	 this.authenticationPossible = authenticationPossible;
//    }
//
//    @Override
//    // insert concrete implementation to auth. natuser and save to DB
//    public void authenticateSubject() {
//   	 int id = this.getId();
//   	 checkID(id);
//   	 if (authenticationPossible == true) {
//   		 authenticationservice.setPerson(DataBase.getPerson(id));
//   		 chooseCredentialType(authenticationservice.getPerson());
//   		 DataBase.saveAuthentication(authenticationservice);
//   	 }
//    }
package Authentication;

import Database.DataBase;
import Person.Person;

public class NaturalUser extends Subject {

    private DataBase DataBase; // Felddeklaration
    private boolean authenticationPossible;
    private AuthenticationService authenticationService;
    private PasswordStrategy password = new PasswordStrategy();
    private FingerPrintStrategy fingerprint = new FingerPrintStrategy();
    private EyeScanStrategy eyescan = new EyeScanStrategy();
    

    public NaturalUser() {
   	 DataBase = DataBase.getInstance(); // Initialisierung im Konstruktor
    	authenticationService = new AuthenticationService(); // Hinzufügen dieser Zeile
    }
    
    

    public boolean isAuthenticationPossible() {
   	 return authenticationPossible;
    }

    public void setAuthenticationPossible(boolean authenticationPossible) {
   	 this.authenticationPossible = authenticationPossible;
    }

    @Override
    public boolean authenticateSubject() {
   	 int id = this.getId();
   	 checkID(id);
   	 if (authenticationPossible) {
   		 Person person = DataBase.getPerson(id);
   		 authenticationService.setPerson(person);
   		 authenticationService.authenticateSubject();

   		 if (authenticationService.isAuthenticated()) {
   			 DataBase.saveAuthentication(authenticationService);
   			 System.out.println("Authentication successful.");
   			 return true;
   		 } else {
   			 System.out.println("Authentication failed for this Natural User.");
   			 return false;
   		 }
   	 } else {
   		 System.out.println("Authentication is not possible for this ID.");
   		 return false;
   	 }
    }


    public void checkID(int id) {
    	Person person = DataBase.getPerson(id);
    	if (person != null) {
        	authenticationPossible = true;
    	} else {
        	System.out.println("Authentication failed for this Natural User.");
        	if (this.retry()) {
            	this.authenticateSubject();
            	return;  
        	} else {
            	authenticationPossible = false;
        	}
    	}
    }

}



