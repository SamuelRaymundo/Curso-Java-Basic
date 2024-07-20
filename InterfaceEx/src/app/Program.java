package app;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(number,date,contractValue);

        System.out.println("Enter the quota amount: ");
        int quotaAmount = sc.nextInt();

        ContractService contractService = new ContractService(new PayPalService());
        contractService.processContract(contract,quotaAmount);

        System.out.println("Quotas: ");
        for (Installment installment : contract.getInstallmentList()) {
            System.out.println(installment);
        }




    }
}
