package Statistics;

import payment.model.PaymentList;

public class Statistics 
{
	Visitor pv = new Visitor();
	PaymentList payments = new PaymentList(); 
	
	public void updateStatistics() 
	{
		pv.resetStatistics(); 
		payments.accept(pv); 
		
	}
}
	