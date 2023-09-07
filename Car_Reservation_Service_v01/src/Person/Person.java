package Person;
import java.util.Scanner;
public abstract class Person {
   // Gemeinsame Eigenschaften und Methoden für alle Person-Typen
   protected String name;
   protected String id;
   protected Address address;
   protected String eMail;
   public Person(String name, String id, Address address) {
       this.name = name;
       this.id = id;
       this.address = address;
   }
   // Konstruktor ohne Parameter, der Benutzereingaben sammelt
   protected Person() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Please enter your name: ");
       this.name = scanner.nextLine();
       System.out.print("Please enter your ID: ");
       this.id = scanner.nextLine();
       System.out.println("Please enter your address details: ");
       System.out.print("Street: ");
       String street = scanner.nextLine();
       System.out.print("Number: ");
       int number = scanner.nextInt();
       System.out.print("Postcode: ");
       int postcode = scanner.nextInt();
       scanner.nextLine();  // Consume the newline
       System.out.print("City: ");
       String city = scanner.nextLine();
       this.address = new Address(street, number, postcode, city);
   }
   // Gemeinsame Methoden für alle Person-Typen
   public void displayInfo() {
       System.out.println("Name: " + name);
       System.out.println("ID: " + id);
       address.printAddress();
   }
   public void setID(int personID) {
       this.id = String.valueOf(personID);
   }
   public abstract String getName();
   public abstract Address getAddress();
   public abstract String getMail();
}

