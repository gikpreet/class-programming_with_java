public class CreateAccount {
    private static CreateAccount createAccount;

    private static String nextAccountNumber = "0";

    private CreateAccount() {}

    public static CreateAccount getCreateAccount() {
        if (createAccount == null) {
            createAccount = new CreateAccount();
        }
        return createAccount;
    }

    public String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}
