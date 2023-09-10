package Person;
import Payment.Account;
public abstract class Person {
   // Gemeinsame Eigenschaften und Methoden für alle Person-Typen
   protected String name;
   private String id;
   protected Address address;
   protected String eMail;
   private String password;
   private String userName;
   public Person(String name, String id, Address address) {
       this.name = name;
       this.id = id;
       this.address = address;
   }
   // Gemeinsame Methoden für alle Person-Typen
   public void displayInfo() {
       System.out.println("Name: " + name);
       System.out.println("ID: " + id);
       address.printAddress();
   }
  
   public void setPassword(String password) {
       this.password = password;
   }
   public String getPassword() {
       return password;
   }
   public String getUserName() {
       return this.userName;
   }
   public void setUserName(String userName) {
       this.userName = userName;
   }
  
   public String getID() {
       return this.id;
   }
   public void setID(String id) {
       this.id = id;
   }
   public abstract String getName();
   public abstract Address getAddress();
   public abstract String getMail();
   public abstract Account getBankAccount();
   public abstract void setBankAccount(Account account);
  
   public abstract String getIban();
   public abstract void setIban(String Iban);
}




