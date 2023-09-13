package Payment;

import Booking.Booking;
import Database.DataBase;
import Person.Person;

public abstract class PaymentTemplate {
	
	private DataBase db = DataBase.getInstance();
	private Person person = db.getPerson(null);
	private	Booking booking = person.getBooking(); 
    public final void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount) {
        authenticateSender(senderAccount);
        transferAmount(senderAccount, receiverAccount, amount);
        createConfirmation();
    }

    private void authenticateSender(Account senderAccount) {
        System.out.println("Authenticating sender: " + senderAccount.getAccountName());
    }

    protected abstract void transferAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount);

    private void createConfirmation() {
        System.out.println("Payment is confirmed.");
    }
    
    public Booking getBooking()
	{
		return booking; 
	}
}
