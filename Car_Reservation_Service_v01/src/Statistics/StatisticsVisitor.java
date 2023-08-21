package Statistics;

public class StatisticsVisitor implements Visitor {
	private int germanPayPalBookings = 0;
    private int germanGoogleWalletBookings = 0;
    private int germanMobileWalletBookings = 0;
    private int englishGoogleWalletBookings = 0;
    private int englishPayPalBookings = 0;
    private int englishMobileWalletBookings = 0;

	@Override
	public void visit() {
		//take language from booking, 1 is for German, 2 is for English
		int bookingLanguage = BookingService.bookingLanguage;
		String paymentType = Payment.PaymentType;
		
		if(bookingLanguage == 1) {
			if(paymentType.equals("PayPal")) {
				germanPayPalBookings++;
			}
			else if (paymentType.equals("GoogleWallet")) {
				germanGoogleWalletBookings++;
			}
			else if (paymentType.equals("MoneyWallet")) {
				germanMoneyWalletBookings++;
			}
		} else if(bookingLanguage ==2)
			if(paymentType.equals("PayPal")) {
				englishPayPalBookings++;
			}
			else if (paymentType.equals("GoogleWallet")) {
				englishGoogleWalletBookings++;
			}
			else if (paymentType.equals("MoneyWallet")) {
				englishMoneyWalletBookings++;
			}
		}
	}

}
