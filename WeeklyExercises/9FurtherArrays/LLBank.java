public class LLBank {

    LLCustomer[] customerAccounts;
    int noOfAccounts;

    public LLBank() {
         customerAccounts = new LLCustomer[30];
         noOfAccounts = 0;
    }

    public void createAccount(String name, double balance, String pass) {
        if (noOfAccounts < 29) {
            customerAccounts[noOfAccounts] = new LLCustomer(name, balance, pass);
            System.out.println("new account created !" + customerAccounts[noOfAccounts].toString());
            noOfAccounts += 1;
        }
    }

    public void requestDeposit(String accountName, String accountPass, double amount) {
        for (LLCustomer eachCustomer : customerAccounts) {
            if (eachCustomer == null) {
                System.out.println("\n! Account name not found !");
                break;
            }
            if (eachCustomer.getCustomerName() == accountName) {
                if (eachCustomer.getCustomerPass() == accountPass) {
                    eachCustomer.deposit(amount);
                } else {
                    System.out.println("\n! Invalid Password !");
                }
                break;
            }
        }
    }

    public double requestWithdrawal(String accountName, String accountPass, double amount) {
        for (LLCustomer eachCustomer : customerAccounts) {
            if (eachCustomer == null) {
                System.out.println("\n! Account name not found !");
                return 0;
            }
            if (eachCustomer.getCustomerName() == accountName) {
                if (eachCustomer.getCustomerPass() == accountPass) {
                    return eachCustomer.withdraw(amount);
                } else {
                    System.out.println("\n! Invalid Password !");
                    return 0;
                }
            }
        }
        return 0;
    }

    public void requestAddInterest(String accountName, String accountPass) {
        for (LLCustomer eachCustomer : customerAccounts) {
            if (eachCustomer == null) {
                System.out.println("\n! Account name not found !");
                break;
            }
            if (eachCustomer.getCustomerName() == accountName) {
                if (eachCustomer.getCustomerPass() == accountPass) {
                    eachCustomer.addInterest();
                    break;
                } else {
                    System.out.println("\n! Invalid Password !");
                    break;
                }
            }
        }
    }
}
