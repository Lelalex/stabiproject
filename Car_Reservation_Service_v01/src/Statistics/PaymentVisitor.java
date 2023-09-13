package Statistics;

import Payment.GoogleWalletPayment;
import Payment.MobileMoneyWalletPayment;
import Payment.PayPalPayment;

public interface PaymentVisitor 
{
	
	public void visit(MobileMoneyWalletPayment moneyWalletPayment);
	public void visit(GoogleWalletPayment googleWalletPayment);
	public void visit(PayPalPayment payPalPayment);
	
}
