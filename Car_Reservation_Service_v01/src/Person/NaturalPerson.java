package Person;

import java.util.Scanner;

import Booking.Booking;
import Payment.Account;


public class NaturalPerson extends Person {
    private String dateOfBirth;
	private String name;
    private String eMail;
    private String username;
    private String password;
    private String iban;
    private double balance;
    private Address address;
//    private int ID;
    private Booking booking;
    private Account bankAccount;
    

//   	public NaturalPerson() {
//        	super(collectName(), collectID(), collectAddress());
//        	setSpecificDetails();
//    	}
    
    public NaturalPerson(String name, String id, Address address, String dateOfBirth) {
    	super(name, id, address);
    	this.dateOfBirth = dateOfBirth;
    }



//    public void setID(String personID) {
//    	this.id = personID;
//    }

//    	private static String collectID() {
//        	Scanner scanner = new Scanner(System.in);
//        	System.out.print("Please enter your ID: ");
//        	return scanner.nextLine();
//    	}

//    	private static Address collectAddress() {
//        	Scanner scanner = new Scanner(System.in);
//        	System.out.println("-- Enter Adress details -- ");
//        	System.out.print("Please enter your street: ");
//        	String street = scanner.nextLine();
//        	System.out.print("Please enter your house number: ");
//        	int number = scanner.nextInt();
//        	System.out.print("Please enter your postcode: ");
//        	int postcode = scanner.nextInt();
//        	scanner.nextLine(); // consume the remaining newline
//        	System.out.print("Please enter your city: ");
//        	String city = scanner.nextLine();
//        	return new Address(street, number, postcode, city);
//    	}
//
//    	private void setSpecificDetails() {
//        	Scanner scanner = new Scanner(System.in);
//        	System.out.print("Please enter your date of birth: ");
//        	this.dateOfBirth = scanner.nextLine();
//        	System.out.print("Please enter your email: ");
//        	this.eMail = scanner.nextLine();
//    	}

    public String getName() {
   	 return name;
    }

    public void setName(String name) {
   	 this.name = name;
    }

    public Address getAddress() {
   	 return address;
    }

    public void setAddress(Address address) {
   	 this.address = address;
    }

    public String getMail() {
   	 return eMail;
    }

    public void setMail(String eMail) {
   	 this.eMail = eMail;
    }

    public String getUserName() {
   	 return username;
    }

    public void setUserName(String user) {
   	 this.username = user;
    }

    public String getPassword() {
   	 return password;
    }

    public void setPassword(String password) {
   	 this.password = password;
    }

//    public int getID() {
//   	 return ID;
//    }

//    public void setID(int iD) {
//   	 ID = iD;
//    }

    public String getIban() {
   	 return iban;
    }

    public void setIban(String iban) {
   	 this.iban = iban;
    }

    public double getBalance() {
   	 return balance;
    }

//    public void setBalance(double balance) {
//   	 this.balance = balance;
//    }

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
  	  System.out.println("Natural Person: " + name + ", Address: " + address + ", DOB: " + dateOfBirth);
    }
}


