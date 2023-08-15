package Database;

import Authentication.AuthenticationService;
import Person.Person;

public class DataBase {
	
	private static DataBase dbEntry;
	
	private DataBase() 
	{		
		
	}

	public Person getPerson(int id) {
		id = this.id;
	}

	public static void saveAuthentication(AuthenticationService authenticationservice) {
		// TODO Auto-generated method stub
		
	}

	public DataBase getEntry() {
		// create unique entry once method is called
		if(dbEntry==null) {
			dbEntry = new DataBase();
			return dbEntry;
		}
		return null;
	}


}