package Statistics;

public class StatisticsService {

	public StatisticsService() {
		// TODO Auto-generated constructor stub
	}
	
	public void getGermanBookingsPaidByPaypal {};
	public void getGermanBookingsPaidByMoneyWallet {};
	public void getGermanBookingsPaidByGoogleWallet {};
	public void getEnglishBookingsPaidByPaypal {};
	public void getEnglishBookingsPaidByMoneyWallet {};
	public void getEnglishBookingsPaidByGoogleWallet {};
	
    public void displayStatistics() {
    	System.out.println("German Booking Paid by PayPal: " + germanPayPalBookings);
        System.out.println("German Booking Paid by Google Wallet: " + germanGoogleWalletBookings);
        System.out.println("German Booking Paid by Mobile Wallet: " + germanMobileWalletBookings);
        System.out.println("English Booking Paid by Google Wallet: " + englishGoogleWalletBookings);
        System.out.println("English Booking Paid by PayPal: " + englishPayPalBookings);
        System.out.println("English Booking Paid by Mobile Wallet: " + englishMobileWalletBookings);
        
    }
    
}
