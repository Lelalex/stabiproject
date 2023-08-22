package Payment;

public class Account {
    private String accountNumber;
    private String accountName;

    public Account(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    // Weitere Getter und Setter, falls erforderlich
}
