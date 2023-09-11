package Person;


import Payment.Account;

public abstract class Person {

	protected String name;
	protected  String username;
	 protected  String password;
	protected String id;
	protected Address address;
	protected String eMail;
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

	public abstract String getName() ;

	public abstract void setName(String name) ;

	public abstract String getUsername();

	public abstract void setUsername(String username);

	public abstract String getPassword() ;

	public abstract void setPassword(String password) ;

	public abstract String getId() ;

	public abstract void setId(String id);

	public abstract Address getAddress() ;
	
	public abstract void setAddress(Address address) ;

	public abstract String geteMail() ;

	public abstract void seteMail(String eMail) ;

	public abstract Account getBankAccount();

	public abstract void setBankAccount(Account bankAccount) ;

	public abstract double getBalance() ;

	public abstract void setBalance(double balance);
	
	

//	public String getID() {
//		return this.id;
//	}
//
//	public void setID(String id) {
//		this.id = id;
//	}
//	
//    public abstract String getUserName();
//
//    public abstract void setUserName(String userName);
//
//	public abstract String getName();
//
//	public abstract void setName(String name);
//
//	public abstract Address getAddress();
//
//	public abstract String getMail();
//
//	public abstract Account getBankAccount();
//
//	public abstract void setBankAccount(Account account);
//
//	public abstract String getPassword();
//
//	public abstract void setPassword(String password);
//
//	public abstract String getIban();
//
//	public abstract void setIban(String Iban);
}

//package Person;
//
//import Payment.Account;
//
//public abstract class Person {
//
//	protected String name;
//	 protected  String username;
//	 protected  String password;
//	 protected  String id;
//	 protected  Address address;
//	    private String eMail;
//	    private String iban;
//	    private double balance;
//    public Person(String name, String username, String password, String id, Address address) {
//        this.name = name;
//        this.username = username;
//        this.password = password;
//        this.id = id;
//        this.address = address;
//    }
//
//
//    // Gemeinsame Methoden für alle Person-Typen
//    public void displayInfo() {
//        System.out.println("Username: " + username);
//        System.out.println("ID: " + id);
//        address.printAddress();
//    }
//    
//
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return this.name; // Geben Sie einfach das 'name' Feld zurück
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//    
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    
//    public String getEMail() {
//        return eMail;
//    }
//
//    public void setEMail(String eMail) {
//        this.eMail = eMail;
//    }
//
//
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//    
//    
//    public String getUserName() {
//        return username;
//    }
//    
//    public void setUserName(String username) {
//        this.username = username;
//    }
//
//
//    public String getID() {
//        return this.id;
//    }
//
//    public void setID(String id) {
//        this.id = id;
//    }
//
//
//
//    public abstract Address getAddress();
//
//    public abstract String getMail();
//
//    public abstract Account getBankAccount();
//
//    public abstract void setBankAccount(Account account);
//
//    
//
//    public abstract String getIban();
//
//    public abstract void setIban(String Iban);
//}

