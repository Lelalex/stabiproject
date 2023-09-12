package de.stabi.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.stabi.authentication.behaviour.AuthenticationService;
import de.stabi.person.structure.LegalPerson;
import de.stabi.person.structure.NaturalPerson;
import de.stabi.person.structure.Person;

public class DataBase {

    private static DataBase dbEntry;

    public Map<String, NaturalPerson> naturalPersons = new HashMap<>();
    public Map<String, LegalPerson> legalPersons = new HashMap<>();
    public ArrayList<AuthenticationService> Authentications = new ArrayList<>(); 
    public Map<String, Person> Persons = new HashMap<>();

    static int naturalPersonID = 1;
    static int legalPersonID = 1;

    private DataBase() {
    }

    public void printAllPersons() {
        for (Map.Entry<String, Person> entry : Persons.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Username: " + entry.getValue().getUsername());
        }
    }


    public void savePerson(NaturalPerson person) { 
        String personID = "N" + naturalPersonID;  // Hinzufügen eines Präfixes
        person.setId(personID);
        this.naturalPersons.put(personID, person);
        naturalPersonID++; 
    }

    public void savePerson(LegalPerson person) { 
        String personID = "L" + legalPersonID;  // Hinzufügen eines Präfixes
        person.setId(personID);
        this.legalPersons.put(personID, person);
        legalPersonID++; 
    }



    public Person getPerson(String id) {
        Person person = naturalPersons.get(id);
        if(person == null) {
            person = legalPersons.get("L" + id);
        }
        return person;
    }
    

    public void addTestData(NaturalPerson person) {
        naturalPersons.put(person.getId(), person);
    }

    public void addTestData(LegalPerson person) {
        legalPersons.put(person.getId(), person);
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

    public Person getPersonById(String id, String personType) {
        if ("n".equalsIgnoreCase(personType)) {
            return naturalPersons.get(id);
        } else if ("l".equalsIgnoreCase(personType)) {
            return legalPersons.get(id);
        } else {
            throw new IllegalArgumentException("Ungültiger Personentyp");
        }
    }


    public void checkPersonTypeById(String id, String personType) {
        Person person = getPersonById(id, personType);

        if (person != null) {
            if (person instanceof LegalPerson) {
                System.out.println("Die ID gehört zu einer legalen Person.");
                // Führen Sie weitere Aktionen für legale Personen durch
            } else if (person instanceof NaturalPerson) {
                System.out.println("Die ID gehört zu einer natürlichen Person.");
                // Führen Sie weitere Aktionen für natürliche Personen durch
            }
        } else {
            System.out.println("Keine Person mit dieser ID gefunden.");
        }
    }

    
    
    
    
    public void printPersonDetails(String id) {
        Person person = getPerson(id);
        if (person != null) {
            System.out.println("ID: " + person.getId());
            System.out.println("Username: " + person.getUsername());
            System.out.println("Password: " + person.getPassword());
        } else {
            System.out.println("No person found with this ID.");
        }
    }
    
    

}
