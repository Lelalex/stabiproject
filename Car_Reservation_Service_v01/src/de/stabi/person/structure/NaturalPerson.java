package de.stabi.person.structure;

import de.stabi.booking.structure.Booking;
import de.stabi.payment.structure.Account;

public class NaturalPerson extends Person {
	private String dateOfBirth;

	private String name;
	private String eMail;
	private String username;
	private String password;
	private double balance;
	private Address address;
	private String ID;
	private Account bankAccount;

	public NaturalPerson(String name, String username, String password, String id, Address address, String dateOfBirth) {
		super(name, username, password, id, address);
		this.name = name;
		this.username = username;
		this.password = password;
		this.ID = id;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
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
		return this.id;
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
	    System.out.println("\n=================");
	    System.out.println("  Natural Person Details");
	    System.out.println("=================");
	    System.out.println("Name: " + name);
	    System.out.println("Username: " + username);
	    System.out.println("Email: " + eMail);
	    System.out.println("ID: " + ID);
	    System.out.println("Date of Birth: " + dateOfBirth);

	    System.out.println("\nAddress:");
	    address.printAddress();
	    System.out.println("=================\n");
	}

}
