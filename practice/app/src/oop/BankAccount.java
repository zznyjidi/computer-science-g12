package oop;

public class BankAccount {
    private final String accountNumber;
    private double balance = 0;

    protected double interestRate = 0;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be higher than 0: " + amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be higher than 0: " + amount);
        if (amount > balance)
            throw new IllegalArgumentException("Not enough money: " + balance);
        balance -= amount;
    }

    protected void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    protected void calculateInterest(int daysSinceLastInterest) {
        balance += balance * interestRate * (daysSinceLastInterest / 365.25);
    }
}
