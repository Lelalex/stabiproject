package Person;
import org.junit.jupiter.api.Test;
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

