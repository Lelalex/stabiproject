package Person;

import Booking.Booking;
import Payment.Account;

public abstract class Person {

	protected String name;
	protected String username;
	protected String password;
	protected String id;
	protected Address address;
	protected String eMail;
	protected Booking booking;
	private double balance;

	public Person(String name, String username, String password, String id, Address address) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.id = id;
		this.address = address;
	}

	// constructor without parameters, scanning ID
//	protected Person() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Please enter your ID: ");
//		this.id = scanner.nextLine();
//	}

	public void displayInfo() {
		System.out.println("Username: " + username);
		System.out.println("ID: " + id);
		address.printAddress();
	}

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getUsername();

	public abstract void setUsername(String username);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract String getId();

	public abstract void setId(String id);

	public abstract Address getAddress();

	public abstract void setAddress(Address address);

	public abstract String geteMail();

	public abstract void seteMail(String eMail);

	public abstract Account getBankAccount();

	public abstract void setBankAccount(Account bankAccount);

	public abstract double getBalance();

	public abstract void setBalance(double balance);
	
	public abstract Booking getBooking();

	public abstract void setBooking(Booking booking);

}
