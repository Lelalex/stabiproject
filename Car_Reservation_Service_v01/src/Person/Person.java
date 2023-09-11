package Person;

import java.util.Scanner;

import Payment.Account;

public abstract class Person {

	protected String name;
	protected String id;
	protected Address address;
	protected String eMail;

	public Person(String name, String id, Address address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}

	// constructor without parameters, scanning ID
	protected Person() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your ID: ");
		this.id = scanner.nextLine();
	}

	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		address.printAddress();
	}

	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
    public abstract String getUserName();

    public abstract void setUserName(String userName);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract Address getAddress();

	public abstract String getMail();

	public abstract Account getBankAccount();

	public abstract void setBankAccount(Account account);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract String getIban();

	public abstract void setIban(String Iban);
}
