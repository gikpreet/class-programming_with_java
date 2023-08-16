public class PrintLimitedBankAccount implements IPrint {
    public void printAccount(IAccount account) {
        LimitedBankAccount bankAccount = (LimitedBankAccount)account;
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Owner Name: " + bankAccount.getOwnerName());
        System.out.println("Balance: " + bankAccount.getBalance());
        System.out.println("Balance Limited: " + bankAccount.getBalanceLimit());
    }
}
