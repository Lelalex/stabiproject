package person;

import org.junit.jupiter.api.Test;

import de.stabi.person.behaviour.PersonService;
import de.stabi.person.structure.Person;

public class PersonTest {
	@Test
	public void testNaturalPersonInput() {
		System.out.print("Creating a natural person...\n");
		Person person = PersonService.createPerson();
	}

	@Test
	public void testLegalPersonInput() {
		System.out.print("Creating a legal person...\n");
		Person person = PersonService.createPerson();
	}
}
