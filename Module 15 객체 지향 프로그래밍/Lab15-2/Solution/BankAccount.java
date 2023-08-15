import java.math.BigDecimal;

public class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected BigDecimal balance;

    public BankAccount(String ownerName, BigDecimal balance) {
        this.accountNumber = CreateAccount.createAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public boolean withDraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) == 1 || amount.compareTo(this.balance) == 0) {
            return false;
        } else {
            balance = balance.subtract(amount);
            return true;
        }
    }

    public void printAccount() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("Balance: " + this.balance.toString());
    }
}
