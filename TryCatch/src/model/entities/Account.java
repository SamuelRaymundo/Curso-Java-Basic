package model.entities;

import model.exceptions.DomainExeption;

public class Account {
    private Integer number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account(Integer number,String holder, double balance, double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public double withdraw(double amount) {
        validateWithdraw(amount);
        return balance -= amount;
    }

    public void validateWithdraw(double amount) {
        if (amount > withdrawLimit) {
            throw new DomainExeption("Withdraw error: The amount exceeds withdraw limit");
        }
        if (balance < amount) {
            throw new DomainExeption("Withdraw error: Not enough balance");
        }
    }

}