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
	private String ID;
	private Booking booking;
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
		System.out
				.println("Natural Person: " + name + ", ID: " + id + ", Address: " + address + ", DOB: " + dateOfBirth);
	}
}
