package Authentication;
import java.util.Scanner;
import Authentication.PasswordStrategy.ScannerInputProvider;
import Person.Person;
public class SoftwareSystem {
   private boolean isAuthenticated;
   private AuthenticationService authenticationService;
   public SoftwareSystem() {
       this.authenticationService = new AuthenticationService();
   }
   public void executeCredentialType(Person person) {
       Scanner scanner = new Scanner(System.in);
       while (true) {
           System.out.println("Choose an option:");
           System.out.println("1. Username with Password");
           System.out.println("2. Go back to main menu");
           int choice = scanner.nextInt();
           scanner.nextLine(); // Consume the newline character
           switch (choice) {
               case 1:
               	authenticationService.setStrategy(new PasswordStrategy(new ScannerInputProvider()));
                   authenticationService.setPerson(person);
                   authenticationService.authenticateSubject();
                   break;
               case 2:
                   return; // Back to main menu
               default:
                   System.out.println("Invalid choice. Please try again.");
                   continue;
           }
           if (authenticationService.isAuthenticated()) {
               System.out.println("Authentication successful.");
               isAuthenticated = true;
               return;
           } else {
               System.out.println("Authentication failed. Please try again.");
           }
       }
   }
   public boolean isAuthenticated() {
       return isAuthenticated;
   }
}




