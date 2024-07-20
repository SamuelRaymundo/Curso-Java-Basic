package entities;

public class Company extends Tax{
    int employers;

    public Company() {
        super();
    }

    public Company(String name, double annualIncome, int employers) {
        super(name,annualIncome);
        this.employers = employers;
    }

    public int getEmployers() {
        return employers;
    }

    public void setEmployers(int employers) {
        this.employers = employers;
    }

    @Override
    public double taxesPaid() {
        if (employers > 10) {
            return getAnnualIncome() * 0.14;
        }
        else {
            return getAnnualIncome() * 0.16;
        }
    }
}
