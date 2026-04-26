class Account {
    int accountNumber;
    double balance;
    static String bankName = "ABC Bank";

    Account(int accNo, double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }

    double calculateInterest() {
        return 0;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Account a1 = new SavingsAccount(1, 10000);
        Account a2 = new CurrentAccount(2, 10000);

        System.out.println(Account.bankName);
        System.out.println(a1.calculateInterest());
        System.out.println(a2.calculateInterest());
    }
}