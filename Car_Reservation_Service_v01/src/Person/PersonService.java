package Person;
import java.util.Scanner;
public class PersonService {
   public Person createPerson(String name, String id, String type, Address address) {
       if ("Natural".equalsIgnoreCase(type)) {
           return new NaturalPerson();
       } else if ("Legal".equalsIgnoreCase(type)) {
           return new LegalPerson();
       } else {
           throw new IllegalArgumentException("Invalid person type");
       }
   }
   public static Person createPerson() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Are you a natural or legal person? (n/l): ");
       String type = scanner.nextLine();
       if (type.equalsIgnoreCase("n")) {
           return new NaturalPerson();
       } else if (type.equalsIgnoreCase("l")) {
           return new LegalPerson();
       } else {
           System.out.println("Invalid input. Please enter 'n' for natural person or 'l' for legal person.");
           return createPerson();  // Recursive call to get a valid input
       }
   }
}

