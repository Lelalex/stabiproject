package Payment;

import org.junit.Test;

public class PaymentTest {

	private Account senderAccount ;
	private Account receiverAccount;
	private CurrencyAmount amount;
	private String paymentMethod;
	private String email;
	private String password;

	@Test
	public void testNaturalPersonInput() {
		System.out.print("Creating a payment...\n");
		PaymentService paymentService = new PaymentService();
		email = "werner@gmx.de";
		password = "password123";
		amount = new CurrencyAmount(12.34, "EUR");
		senderAccount = new Account("Julian Werner", "werner@gmx.de", 100000);
		receiverAccount = receiverAccount.getReceiverAccount();
		paymentService.payAmount(senderAccount, receiverAccount, amount, paymentMethod, email, password);
	}

}
