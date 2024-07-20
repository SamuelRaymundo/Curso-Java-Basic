package model.services;

public class PayPalService implements OnlinePaymentService{
    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTH_PERCENTAGE = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, Integer months) {
        return amount * MONTH_PERCENTAGE * months;
    }


}
