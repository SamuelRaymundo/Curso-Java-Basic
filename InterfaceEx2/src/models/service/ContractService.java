package models.service;

import models.entities.Contract;
import models.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlineServicePayment onlineServicePayment;

    public ContractService(OnlineServicePayment onlineServicePayment) {
        this.onlineServicePayment = onlineServicePayment;
    }

    public void processContract(Contract contract,int months){
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months;i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlineServicePayment.interest(basicQuota,i);
            double fee = onlineServicePayment.paymentFee(interest + i);
            double quota = basicQuota + interest + fee;
            contract.getList().add(new Installment(dueDate,quota));
        }
    }
}
