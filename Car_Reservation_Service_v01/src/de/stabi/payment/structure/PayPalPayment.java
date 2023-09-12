package de.stabi.payment.structure;

public class PayPalPayment extends PaymentTemplate {
    @Override
    protected void transferAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount) {
        System.out.println("Transferring " 
						    + amount.getAmount() + " " 
						    + amount.getCurrency() + " from " 
						    + senderAccount.getAccountName() + " to " 
						    + receiverAccount.getAccountName() + " using PayPal.");
    }
}

