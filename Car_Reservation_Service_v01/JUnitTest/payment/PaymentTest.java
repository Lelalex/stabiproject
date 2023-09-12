package payment;

import org.junit.Test;

import de.stabi.payment.behaviour.PaymentService;
import de.stabi.payment.structure.Account;
import de.stabi.payment.structure.CurrencyAmount;

public class PaymentTest {

	private Account senderAccount ;
	private Account receiverAccount;
	private CurrencyAmount amount;
	private String paymentMethod;
	private String email;
	private String password;

	@Test
	public void testPayment() {
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
