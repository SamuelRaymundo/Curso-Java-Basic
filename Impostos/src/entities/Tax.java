package entities;

public abstract class Tax {
    private String name;
    private double annualIncome;

    public Tax() {
    }

    public Tax(String name, double annualIncome) {
        this.annualIncome = annualIncome;
        this.name = name;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double taxesPaid();
}
