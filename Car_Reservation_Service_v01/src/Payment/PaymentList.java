package Payment;

import java.util.ArrayList;
import Statistics.PaymentVisitor;

public class PaymentList implements Element
{
	private static ArrayList<Element> payments = new ArrayList<Element>(); 
	@Override
	public void accept(PaymentVisitor pv) 
		{
		for (Element element: payments)
		{
			element.accept(pv);
		}
		
//		payments.get(payments.size()-1).accept(pv);
		pv.visit(this); 
		}
				
	public void addPayment(PaymentTemplate payment)
	{
		payments.add(payment);
	}				
	public static ArrayList<Element> getPayments()
	{
		return payments;
	}
	
}
