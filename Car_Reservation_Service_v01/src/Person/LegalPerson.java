package Person;

import java.util.Scanner;

import Booking.Booking;
import Payment.Account;

public class LegalPerson extends Person {
	private String companyName;
	private String companyMail;
    private String userName;
    private String password;
    private double balance;
    private String ID;
    private Account bankAccount;


    public LegalPerson(String name, String username, String password, String id, Address address, String companyName, String companyMail) {
    	super(name, username, password, id, address);
    	this.name = name;
    	this.username = username;
		this.password = password;
		this.ID = id;
    	this.companyName = companyName;
    	this.companyMail = companyMail;
    	this.address = address;
    }




	private static String collectName() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Please enter the Username: ");
    	return scanner.nextLine();
	}


    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Account getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	
    }
	
	@Override
	public Booking getBooking() {
		return booking;
	}
		
	@Override
	public void setBooking(Booking booking) {
		this.booking = booking;		
	}
	
	@Override
	public void displayInfo() {
	    System.out.println("\n=================");
	    System.out.println("  Legal Person Details");
	    System.out.println("=================");
	    System.out.println("Name: " + name);
	    System.out.println("Username: " + username);
	    System.out.println("Email: " + companyMail);
	    System.out.println("ID: " + ID);

	    System.out.println("\nAddress:");
	    address.printAddress();
	    System.out.println("=================\n");
	}




}
