public class LLBankDriver {

    public static void main(String[] args) {
        LLBank bank = new LLBank();
        bank.createAccount("bob", 3.40, "123");
        bank.createAccount("bill", 1000, "abc");

        bank.requestDeposit("bob", "124", 1);
        bank.requestDeposit("bob", "123", 1);

        bank.requestWithdrawal("bill", "ABC", 1000);
        bank.requestWithdrawal("bill", "abc", 1001);
        bank.requestWithdrawal("bill", "abc", 500);

        bank.requestAddInterest("bob","123");
    }
}
