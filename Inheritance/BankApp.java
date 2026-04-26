class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int acc, double bal) {
        this.accountNumber = acc;
        this.balance = bal;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate = 4;

    SavingsAccount(int acc, double bal) {
        super(acc, bal);
    }

    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    CheckingAccount(int acc, double bal) {
        super(acc, bal);
    }

    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    FixedDepositAccount(int acc, double bal) {
        super(acc, bal);
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount acc = new SavingsAccount(101, 5000);
        ((SavingsAccount) acc).displayAccountType();
    }
}