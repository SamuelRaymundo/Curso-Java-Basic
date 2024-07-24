package app;

import models.entities.Contract;
import models.entities.Installment;
import models.service.ContractService;
import models.service.PaypalService;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.print("Contract value: ");
        double totaValue = sc.nextDouble();
        Contract contract = new Contract(number,date,totaValue);
        System.out.print("Enter the number of the installment: ");
        int installment = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract,installment);

        System.out.println("Quota: ");
        for (Installment installment1 : contract.getList()){
            System.out.println(installment1);
        }

    }
}
