package models.service;

public class PaypalService implements OnlineServicePayment{
    private static final double TAX = 0.02;
    private static final double SIMPLE_FEE = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount * TAX;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * SIMPLE_FEE * months;
    }
}
