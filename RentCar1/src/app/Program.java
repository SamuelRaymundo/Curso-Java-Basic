package app;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;
import model.services.TaxService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            System.out.println("Enter the rent data:");
            System.out.print("Car model: ");
            String model = sc.nextLine();
            System.out.print("Withdrawal (dd/MM/yyyy HH:mm): ");
            String startInput = sc.nextLine().trim();
            LocalDateTime start = LocalDateTime.parse(startInput, fmt);
            System.out.print("Return (dd/MM/yyyy HH:mm): ");
            String finishInput = sc.nextLine().trim();
            LocalDateTime finish = LocalDateTime.parse(finishInput, fmt);

            CarRental cr = new CarRental(start, finish, new Vehicle(model));

            System.out.print("Enter the price per hour: ");
            double pricePerHour = sc.nextDouble();
            System.out.print("Enter the price per day: ");
            double pricePerDay = sc.nextDouble();

            RentalService service = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
            service.processInvoice(cr);

            System.out.println("TOTAL:");
            System.out.printf("Basic payment: %.2f%n", cr.getInvoice().getBasicPayment());
            System.out.printf("Tax: %.2f%n", cr.getInvoice().getTax());
            System.out.printf("Total payment: %.2f%n", cr.getInvoice().getTotalPayment());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
