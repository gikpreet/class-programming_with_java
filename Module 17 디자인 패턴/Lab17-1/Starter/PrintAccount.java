public class PrintAccount implements IPrint {
    public void printAccount(IAccount account) {
        BankAccount bankAccount = (BankAccount)account;
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Owner Name: " + bankAccount.getOwnerName());
        System.out.println("Balance: " + bankAccount.getBalance().toString());
    }
}
