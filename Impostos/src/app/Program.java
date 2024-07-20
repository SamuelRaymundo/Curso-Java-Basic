package app;

import entities.Company;
import entities.Individual;
import entities.Tax;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Tax> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int taxPayers = sc.nextInt();

        for (int i = 0;i < taxPayers;i++) {
            System.out.printf("Tax payers #%d data:  %n", (i+1));
            System.out.print("Individual or company (i/c): ");
            String payer = sc.next().toLowerCase();
            sc.nextLine();
            while (true) {

                if (payer.equals("i") || payer.equals("c")){
                    break;
                }
                else {
                    System.out.println("[ERROR] Just (i/c) are correct answers");
                    payer = sc.nextLine().toLowerCase();
                }
            }
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            if (payer.equals("i")) {
                System.out.print("Health expenditures: ");
                double healthPlan = sc.nextDouble();

                list.add(new Individual(name,annualIncome,healthPlan));
            }
            else {
                System.out.print("Number of employees: ");
                int employers = sc.nextInt();

                list.add(new Company(name,annualIncome,employers));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID: ");
        double sum = 0;
        for (Tax tax : list) {
            System.out.printf("%s : $ %f %n",tax.getName(), tax.taxesPaid() );
            sum += tax.taxesPaid();
        }
        System.out.println("TOTAL TAXES:" + sum);
    }
}
