package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Installment {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private double amount;

    public Installment() {
    }

    public Installment(LocalDate dueDate, double amount) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return dueDate.format(dtf) + "-" + String.format("%.2f", amount);
    }
}

