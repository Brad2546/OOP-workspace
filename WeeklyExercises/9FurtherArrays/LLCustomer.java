import java.text.NumberFormat;

public class LLCustomer {

    String customerName, customerPass;
    double customerBalance;
    NumberFormat money;

    public LLCustomer(String name, double balance, String pass) {
        customerName = name;
        customerPass = pass;
        customerBalance = balance;
        money = NumberFormat.getCurrencyInstance();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            System.out.println("\n--- Account name : "+getCustomerName());
            System.out.println("Current Account Balance = "+money.format(customerBalance)+ " + ("+amount+")");
            customerBalance += amount;
            System.out.println("New Account Balance = "+money.format(customerBalance));
        }
    }

    public double withdraw(double amount) {
        System.out.println("\n--- Account name : "+getCustomerName());
        if (amount <= customerBalance) {
            System.out.println("Current Account Balance = "+money.format(customerBalance)+ " - ("+amount+")");
            customerBalance -= amount;
            System.out.println("New Account Balance = "+money.format(customerBalance));
            return amount;
        } else {
            System.out.println("Current Account Balance = "+money.format(customerBalance));
            System.out.println("Insufficient funds to withdraw "+amount);
            return 0;
        }
    }

    public void addInterest() {
        System.out.println("\n--- Account name : "+getCustomerName());
        System.out.println("Current Account Balance = "+money.format(customerBalance)+" + 3%");
        customerBalance *= 1.03;
        System.out.println("New Account Balance = "+money.format(customerBalance));
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPass() {
        return customerPass;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    @Override
    public String toString() {
        return "LLCustomer{" +
                "customerName='" + customerName + '\'' +
                ", customerBalance=" + customerBalance +
                '}';
    }
}
