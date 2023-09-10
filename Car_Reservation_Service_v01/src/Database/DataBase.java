package Database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Authentication.AuthenticationService;
import Person.Person;
public class DataBase {
  
   private static DataBase dbEntry;
  
   public Map<String, Person> Persons = new HashMap<>();
   public ArrayList<AuthenticationService> Authentications = new ArrayList<>();
  
   static int PersonID = 1;
  
   private DataBase() {       
   }
  
   public void savePerson(Person person) {
       String personID = String.valueOf(PersonID);
       person.setID(personID);
       this.Persons.put(personID, person);
       PersonID++;
   }
  
   public Person getPerson(String id) {
       return Persons.get(id);
   }
   public void saveAuthentication(AuthenticationService authenticationservice) {
       this.Authentications.add(authenticationservice);
   }
  
   public AuthenticationService getAuthentication() {
       return Authentications.get(Authentications.size()-1);
   }
  
   public static DataBase getInstance() {
       if(dbEntry == null) {
           dbEntry = new DataBase();
       }
       return dbEntry;
   }
}




