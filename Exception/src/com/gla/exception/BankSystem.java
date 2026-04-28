package com.gla.exception;

public class BankSystem {

    int balance = 10000;

    // withdraw method
    public void withdraw(int amount) {
        try {
            // check if balance is sufficient
            if (amount > balance) {
                throw new InsufficientBalance("Insufficient balance"); // custom exception
            }

            balance = balance - amount; // deduct amount
            System.out.println("Amount withdrawn successfully: " + balance);

        } catch (InsufficientBalance e) {
            // handling custom exception
            System.out.println("Exception handled inside method: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BankSystem bs = new BankSystem();

        bs.withdraw(200000); // triggers exception
        bs.withdraw(5000);   // works normally
    }
}