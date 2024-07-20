package entities;

public class Individual extends Tax{

    double healthPlan;

    public Individual() {
        super();
    }

    public Individual(String name, double annualIncome, double healthPlan) {
        super(name,annualIncome);
        this.healthPlan = healthPlan;
    }

    public double getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(double healthPlan) {
        this.healthPlan = healthPlan;
    }

    @Override
    public double taxesPaid() {
        double value = healthPlan * 0.50;
        if (healthPlan <= 0) {
            if (getAnnualIncome() < 20000.00) {
                return getAnnualIncome() * 0.15;
            }
            else{
                return getAnnualIncome() * 0.25;
            }
        }
        else {
            if (getAnnualIncome() < 20000.00) {
                return (getAnnualIncome() * 0.15) - value;
            }
            else{
                return (getAnnualIncome() * 0.25) - value;
            }
        }
    }
}
