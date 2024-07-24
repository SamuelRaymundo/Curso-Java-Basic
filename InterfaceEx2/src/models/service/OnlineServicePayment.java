package models.service;

public interface OnlineServicePayment {
    double paymentFee(double amount);
    double interest(double amount, int months);
}
