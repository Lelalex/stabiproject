package de.stabi.authentication.structure;

import de.stabi.person.structure.Person;

public interface LoginStrategy {
	
	// enterID() -> für alle Optionen wird ID abgefragt, damit wir die Person zuordnen können
	
	
	
	    abstract public boolean runStrategy(Person person);
	}