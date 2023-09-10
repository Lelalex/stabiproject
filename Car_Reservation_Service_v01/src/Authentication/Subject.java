package Authentication;
import java.util.Scanner;
import Database.DataBase;
import Person.Person;
public abstract class Subject {
   protected DataBase dataBase = DataBase.getInstance(); // Angenommen, Sie haben eine Singleton-Instanz Ihrer Datenbank
   protected Person person;
  
   public abstract boolean authenticateSubject();
   public boolean authenticate() {
       String id = getId();
       person = dataBase.getPerson(id);
       if (person == null) {
           System.out.println("No person found with this ID.");
           return retry();
       }
       return authenticateSubject();
   }
   public boolean retry() {
       Scanner scanner = new Scanner(System.in);
       while (true) {
           System.out.println("Invalid ID. Retry (r) or Exit (e)");
           String retryOrExit = scanner.nextLine();
           if ("r".equalsIgnoreCase(retryOrExit)) {
               return authenticate();  // Rekursiver Aufruf von authenticate, um den Prozess neu zu starten
           } else if ("e".equalsIgnoreCase(retryOrExit)) {
               return false;
           } else {
               System.out.println("Invalid choice. Retry (r) or Exit (e)");
           }
       }
   }
   public String getId() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter ID: ");
       return scanner.nextLine();
   }
   public int getCredentialType() {
       int credentialType = 0;
       return credentialType;
   }
}




