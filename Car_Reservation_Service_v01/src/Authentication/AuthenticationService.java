package Authentication;

import Person.Person;

//public class AuthenticationService {
//	
//	public String authenticationService(){
//		return null;
//		
//		
//		
//	}
//
//}

public class AuthenticationService {

	private boolean isAuthenticated;
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String authenticationService() {
		// Implement the method, that is needed here
		return null;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}
}
