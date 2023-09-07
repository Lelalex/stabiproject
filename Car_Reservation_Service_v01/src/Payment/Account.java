package Payment;

import Person.Person;

public class Account {
	private String accountNumber;
	private String accountName;
	private double accountBalance;

	private static Account receiverAccount;
	private Account senderAccount;

	public Account(String accountNumber, String accountName, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public static Account getReceiverAccount() {
		if (receiverAccount == null) {
			receiverAccount = new Account("Stabi", "stabi@mail.de", 123456.98);
			return receiverAccount;
		} else
			return receiverAccount;
	}

	private static Account getSenderAccount (Person person) {
    		if(person.getBankAccount() == null)
    		{person.setBankAccount(new Account(person.getName(), person.getMail(), 100000));} 
    		return person.getBankAccount(); 
    }

}

    

    // Weitere Getter und Setter, falls erforderlich

