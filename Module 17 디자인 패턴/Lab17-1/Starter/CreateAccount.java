public class CreateAccount {
    // Write private, static CreateAccount here

    private static String nextAccountNumber = "0";

    //
    // Write private constructor here
    //

    //
    // Write public getCreateAccount method here
    //

    public static String createAccountNumber() {
        int accountNumber = Integer.parseInt(nextAccountNumber);
        nextAccountNumber = Integer.toString(++accountNumber);
        return "0000-" + nextAccountNumber;
    }
}
