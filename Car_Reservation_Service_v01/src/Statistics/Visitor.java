package Statistics;

import Booking.EnglishBooking;
import Booking.GermanBooking;
import Payment.GoogleWalletPayment;
import Payment.MobileMoneyWalletPayment;
import Payment.PayPalPayment;
import payment.model.PaymentList;


public class Visitor implements PaymentVisitor
{
	private static int payPalGerman = 0; 
	private static int payPalEng = 0; 
	private static int moneyGerman = 0; 
	private static int moneyEng = 0; 
	private static int googleGerman = 0; 
	private static int googleEng = 0; 
	
	
	public void visit(PayPalPayment payPal)
	{
		if(payPal.getBooking() instanceof GermanBooking)
		payPalGerman ++; <>
		if(payPal.getBooking() instanceof EnglishBooking)
		payPalEng ++; 
	}
	
	public void visit(MobileMoneyWalletPayment moneyPay)
	{
		if(moneyPay.getBooking() instanceof GermanBooking)
		moneyGerman ++; 
		if(moneyPay.getBooking() instanceof EnglishBooking)
		moneyEng ++; 	
	}
	
	public void visit(GoogleWalletPayment googlePay)
	{
		if(googlePay.getBooking() instanceof GermanBooking)
		googleGerman ++; 
		if(googlePay.getBooking() instanceof EnglishBooking)
		googleEng ++; 	
	}

	public void visit(PaymentList payments) 
	{
		
	}
	
	public static void resetStatistics()
	{
		payPalEng = 0; 
		payPalGerman = 0; 
		moneyEng = 0; 
		moneyGerman = 0;
		googleEng = 0; 
		googleGerman = 0; 
	}
	
	public static int getPayPalEng() 
	{
		return payPalEng;
	}

	public static int getMoneyEng() 
	{
		return moneyEng;
	}

	public static int getGoogleEng() 
	{
		return googleEng;
	}

	public static int getPayPalGerman() 
	{
		return payPalGerman;
	}

	public static int getMoneyGerman() {
		return moneyGerman;
	}

	public static int getGoogleGerman() 
	{
		return googleGerman;
	}	
	

		
}