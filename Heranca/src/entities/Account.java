package entities;

public class Account {
    private Integer number;
    private String holder;
    protected double balance;

    public Account() {

    }

    public Account(Integer number, String holder, double balance) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
    }

    public double getBalance() {
        return balance;
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

    public void withdraw(double amount) {
        balance -= amount + 5.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
