package Payment;

public class PayWithPaypal {

	//PayPal Geldtransfer und berechnung der Gebühr
		@Override
		protected String transferMoney(Account sender, Account receiver, double amount) 
		{
			double fee = amount * 0.01;
			sender.subtractAmount(amount + fee); 
			receiver.addAmount(amount);
			
			return ("You transfered " + amount + " € plus a fee of " + (Math.round(fee*100)/100.0) + "€ to " + receiver.getAccountHolder() + " via PayPal!" + "\n");
		}
		
		public void accept(PaymentVisitor v)
		{
		v.visit(this); //Observer
		}
	
}
