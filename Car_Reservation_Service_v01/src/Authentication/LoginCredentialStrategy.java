package Authentication;

import Person.Person;

public interface LoginCredentialStrategy {
	
	// enterID() -> für alle Optionen wird ID abgefragt, damit wir die Person zuordnen können
	
	
	abstract public boolean runStrategy(Person person);

	}


