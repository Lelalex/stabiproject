package Person;

import java.util.Scanner;

import Booking.Booking;
import Payment.Account;

public class LegalPerson extends Person {
//    private String registrationNumber;
	private String companyName;
    private String companyMail;
    private String userName;
    private String password;
    private String iban;
    private double balance;
    private Address companyAddress;
    private int ID;
    private Booking booking;
    private Account bankAccount;

    
    public LegalPerson(String name, String id, Address address, String companyName, String companyMail) {
    	super(name, id, address);
    	this.companyName = companyName;
    	this.companyMail = companyMail;
    }




	private static String collectName() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Please enter the Username: ");
    	return scanner.nextLine();
	}

//	public void setID(String personID) {
//    	this.id = personID;
//	}

//	private static Address collectAddress() {
//    	Scanner scanner = new Scanner(System.in);
//    	System.out.println("-- Enter Adress details -- ");
//    	System.out.print("Please enter the street: ");
//    	String street = scanner.nextLine();
//    	System.out.print("Please enter the house number: ");
//    	int number = scanner.nextInt();
//    	System.out.print("Please enter the postcode: ");
//    	int postcode = scanner.nextInt();
//    	scanner.nextLine(); // consume the remaining newline
//    	System.out.print("Please enter the city: ");
//    	String city = scanner.nextLine();
//    	return new Address(street, number, postcode, city);
//	}
//
//	private void setSpecificDetails() {
//    	Scanner scanner = new Scanner(System.in);
//    	System.out.print("Please enter the company name: ");
//    	this.companyName = scanner.nextLine();
//    	// System.out.print("Please enter the registration number: ");
//    	// this.registrationNumber = scanner.nextLine();
//    	System.out.print("Please enter the company mail: ");
//    	this.companyMail = scanner.nextLine();
//	}
    
    
    public String getName() {
   	 return companyName;
    }

    public void setName(String name) {
   	 this.companyName = name;
    }

    public String getUserName() {
   	 return userName;
    }

    public void setUserName(String userName) {
   	 this.userName = userName;
    }

    public String getPassword() {
   	 return password;
    }

    public void setPassword(String password) {
   	 this.password = password;
    }

    public Address getAddress() {
   	 return companyAddress;
    }

    public void setAddress(Address address) {
   	 this.companyAddress = address;
    }

    public String getMail() {
   	 return companyMail;
    }

    public void setMail(String mail) {
   	 this.companyMail = mail;
    }

//    public int getID() {
//   	 return ID;
//    }

    public void setID(int id) {
   	 this.ID = id;
    }

    public String getIban() {
   	 return iban;
    }

    public void setIban(String iban) {
   	 this.iban = iban;
    }

    public double getBalance() {
   	 return balance;
    }

    public void setBalance(double balance) {
   	 this.balance = balance;
    }

    public Booking getBooking() {
   	 return booking;
    }

    public void setBooking(Booking booking) {
   	 this.booking = booking;
    }

    public Account getBankAccount() {
   	 return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
   	 this.bankAccount = bankAccount;
    }
    @Override
  public void displayInfo() {
   	 System.out.println("Legal Person: " + name +  ", Address: " + address);
   	 
//   	 System.out.println("Legal Person: " + name + ", ID: " + id + ", Address: " + address + ", Reg. No.: " + registrationNumber);
 }
}


