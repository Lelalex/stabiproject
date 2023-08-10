package Person;


public abstract class Person {
    // Gemeinsame Eigenschaften und Methoden für alle Person-Typen
    protected String name;
    protected String id;
    protected Address address;
    
    public Person(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    // Gemeinsame Methoden für alle Person-Typen
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        address.printAddress();
    }
}
