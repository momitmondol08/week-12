package com.mycompany.labreport;

class BankAccount {

    private long balance = 0;
    private boolean open = false;

    public synchronized void open() {
        open = true;
    }

    public synchronized void close() {
        open = false;
    }

    public synchronized long getBalance() {
        if (!open) {
            throw new IllegalStateException();
        }

        return balance;
    }

    public synchronized void deposit(long amount) {
        if (!open) {
            throw new IllegalStateException();
        }

        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        balance += amount;
    }

    public synchronized void withdraw(long amount) {
        if (!open) {
            throw new IllegalStateException();
        }

        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException();
        }

        balance -= amount;
    }
}

public class Solution {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        try {
            account.open();
            System.out.println("Account opened.");

            account.deposit(5000);
            System.out.println("Balance: " + account.getBalance());

            account.withdraw(2000);
            System.out.println("Balance after withdraw: " + account.getBalance());

            account.deposit(1000);
            System.out.println("Balance after deposit: " + account.getBalance());

            account.close();
            System.out.println("Account closed.");

        } catch (IllegalStateException e) {
            System.out.println("Account is not open.");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount.");
        }
    }
}

        balance -= amount;
    }
}
