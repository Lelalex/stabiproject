package Person;


public class PersonService {
    public Person createPerson(String name, String id, String type, Address address, String additionalInfo) {
        if ("Natural".equals(type)) {
            return createNaturalPerson(name, id, address, additionalInfo);
        } else if ("Legal".equals(type)) {
            return createLegalPerson(name, id, address, additionalInfo);
        } else {
            throw new IllegalArgumentException("Invalid person type");
        }
    }

    private NaturalPerson createNaturalPerson(String name, String id, Address address, String dateOfBirth) {
        return new NaturalPerson(name, id, address, dateOfBirth);
    }

    private LegalPerson createLegalPerson(String name, String id, Address address, String registrationNumber) {
        return new LegalPerson(name, id, address, registrationNumber);
    }
}