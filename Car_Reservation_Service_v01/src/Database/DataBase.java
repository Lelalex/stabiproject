//package Database;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import Authentication.AuthenticationService;
//import Person.Person;
//
//public class DataBase {
//    
//    private static DataBase dbEntry;
//    
//    public Map<Integer, Person> Persons = new HashMap<Integer, Person>();
//    public ArrayList<AuthenticationService> Authentications = new ArrayList<AuthenticationService>();
//    
//    static int PersonID = 1 ;
//    static int BookingID = 1 ;
//    
//    
//    private DataBase()
//    {   	 
//   	 
//    }
//    
//    public void savePerson(Person person)
//    {
//   	 person.setID(PersonID);
//   	 this.Persons.put(PersonID, person);
//   	 PersonID ++;
//    }
//    
//    public Person getPerson(int id) {
////   	 id = this.id;
//   	 return Persons.get(id);
//    }
//
//    public void saveAuthentication(AuthenticationService authenticationservice) {
//   	 this.Authentications.add(authenticationservice);
//   	 
//    }
//    
//    public AuthenticationService getAuthentication()
//    {
//   	 return Authentications.get(Authentications.size()-1);
//    }
//    
//    public DataBase getEntry() {
//   	 // create unique entry once method is called
//   	 if(dbEntry==null) {
//   		 dbEntry = new DataBase();
//   		 return dbEntry;
//   	 }
//   	 return null;
//    }
//
//    public static DataBase getInstance() {
//   	 // TODO Auto-generated method stub
//   	 return null;
//    }
//
//
//}
package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Authentication.AuthenticationService;
import Person.Person;

public class DataBase {
    
	private static DataBase dbEntry;
    
	public Map<Integer, Person> Persons = new HashMap<Integer, Person>();
	public ArrayList<AuthenticationService> Authentications = new ArrayList<AuthenticationService>();
    
	static int PersonID = 1 ;
	static int BookingID = 1 ;
    
	private DataBase()
	{   	 
   	 
	}
    
	public void savePerson(Person person)
	{
    	person.setID(PersonID);
    	this.Persons.put(PersonID, person);
    	PersonID ++;
	}
    
	public Person getPerson(int id) {
    	return Persons.get(id);
	}

	public void saveAuthentication(AuthenticationService authenticationservice) {
    	this.Authentications.add(authenticationservice);
	}
    
	public AuthenticationService getAuthentication()
	{
    	return Authentications.get(Authentications.size()-1);
	}
    
	public static DataBase getInstance() {
    	// create unique entry once method is called
    	if(dbEntry == null) {
        	dbEntry = new DataBase();
    	}
    	return dbEntry;
	}
    
	public void addPerson(int id, Person person) {
    	this.Persons.put(id, person);
	}
}


