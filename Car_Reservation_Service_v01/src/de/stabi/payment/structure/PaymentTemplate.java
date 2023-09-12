package de.stabi.payment.structure;

public abstract class PaymentTemplate {
    public final void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount) {
        authenticateSender(senderAccount);
        transferAmount(senderAccount, receiverAccount, amount);
        createConfirmation();
    }

    private void authenticateSender(Account senderAccount) {
        System.out.println("Authenticating sender: " + senderAccount.getAccountName());
    }

    protected abstract void transferAmount(Account senderAccount, Account receiverAccount, CurrencyAmount amount);

    private void createConfirmation() {
        System.out.println("Payment is confirmed.");
    }
}
