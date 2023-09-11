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
	private int ID;
	private Booking booking;
	private Account bankAccount;

	public NaturalPerson(String name, String id, Address address, String dateOfBirth) {
		super(name, id, address);
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

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

//	public String getID() {
//		return ID;
//	}
//
	public void setID(int iD) {
		ID = iD;
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

//	public void setBalance(double balance) {
//    	this.balance = balance;
//	}

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
		System.out
				.println("Natural Person: " + name + ", ID: " + id + ", Address: " + address + ", DOB: " + dateOfBirth);
	}
}
