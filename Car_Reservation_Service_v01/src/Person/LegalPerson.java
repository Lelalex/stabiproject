package Person;

import java.util.Scanner;

import Booking.Booking;
import Payment.Account;

public class LegalPerson extends Person {
	private String companyName;
    private String companyMail;
    private String userName;
    private String password;
    private String iban;
    private double balance;
    private int ID;
    private Booking booking;
    private Account bankAccount;


    public LegalPerson(String name, String username, String password, String id, Address address, String companyName, String companyMail) {
    	super(name, username, password, id, address);
    	this.name = name;
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

	public String getId() {
		return id;
	}

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
  public void displayInfo() {
   	 System.out.println("Legal Person: " + name +  ", Address: " + address);

//   	 System.out.println("Legal Person: " + name + ", ID: " + id + ", Address: " + address + ", Reg. No.: " + registrationNumber);
 }
}
