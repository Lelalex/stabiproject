package Authentication;
import java.util.Scanner;
import Person.Person;
public class PasswordStrategy implements LoginStrategy {
   private InputProvider inputProvider;
   public PasswordStrategy(InputProvider inputProvider) {
       this.inputProvider = inputProvider;
   }
   @Override
   public boolean runStrategy(Person person) {
       System.out.println("Enter username");
       String userName = inputProvider.getInput();
       System.out.println("Enter password");
       String password = inputProvider.getInput();
       return userName.equals(person.getUserName()) && password.equals(person.getPassword());
   }
   public interface InputProvider {
       String getInput();
   }
   public static class ScannerInputProvider implements InputProvider {
       @Override
       public String getInput() {
           Scanner scanner = new Scanner(System.in);
           return scanner.next();
       }
   }
   public static class TestInputProvider implements InputProvider {
       private String input;
       public TestInputProvider(String input) {
           this.input = input;
       }
       @Override
       public String getInput() {
           return input;
       }
   }
}




