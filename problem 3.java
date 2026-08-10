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
