package entities;

public class Employee {

    private String name;
    protected Integer hours;
    protected double valuePerHour;

    public Employee() {
    }

    public Employee(String name, Integer hours, double valuePerHour) {
        this.hours = hours;
        this.name = name;
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double payment() {
        return hours * valuePerHour;
    }
}
