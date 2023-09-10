package Authentication;
import java.util.Scanner;
import Database.DataBase;
import Person.Person;
public class NaturalUser extends Subject {
   private DataBase dataBase;
   private boolean authenticationPossible;
   private AuthenticationService authenticationService;
   public NaturalUser() {
       this.dataBase = DataBase.getInstance();
       this.authenticationService = new AuthenticationService();
   }
   public boolean isAuthenticationPossible() {
       return authenticationPossible;
   }
   public void setAuthenticationPossible(boolean authenticationPossible) {
       this.authenticationPossible = authenticationPossible;
   }
   @Override
   public boolean authenticateSubject() {
       String id = getIdFromUser();  // Holen Sie die ID vom Benutzer
       if (checkID(id)) {
           Person person = dataBase.getPerson(id);  // Holen Sie das Person-Objekt aus der Datenbank
           authenticationService.setPerson(person);
           authenticationService.authenticateSubject();
           if (authenticationService.isAuthenticated()) {
               dataBase.saveAuthentication(authenticationService);
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
   private String getIdFromUser() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Please enter your ID: ");
       return scanner.nextLine();
   }
   public boolean checkID(String id) {
       Person personFromDB = dataBase.getPerson(id);  // Verwenden Sie einen anderen Variablennamen, um den Konflikt zu vermeiden
       if (personFromDB != null) {
           authenticationPossible = true;
       } else {
           System.out.println("Authentication failed for this Natural User.");
           if (this.retry()) {
               this.authenticate();
           } else {
               authenticationPossible = false;
           }
       }
       return authenticationPossible;  // Die Methode sollte einen Wert zurückgeben, der angibt, ob die ID gültig ist oder nicht
   }
}




