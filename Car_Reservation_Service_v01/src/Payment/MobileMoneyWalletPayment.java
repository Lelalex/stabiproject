package Payment;

public class MobileMoneyWalletPayment extends PaymentTemplate {
    @Override
    protected void transferAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount) {
        System.out.println("Transferring " 
						    + amount.getAmount() + " " 
						    + amount.getCurrency() + " from " 
						    + senderAccount.getAccountName() + " to " 
						    + receiverAccount.getAccountName() + " using Mobile Money Wallet.");
    }
}
