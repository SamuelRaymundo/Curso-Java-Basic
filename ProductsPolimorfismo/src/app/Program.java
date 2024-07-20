package app;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int productsQuantity = sc.nextInt();

        for (int i = 0; i < productsQuantity; i++) {
            System.out.printf("Product #%d data %n", (1+i));
            System.out.print("Commom, used or imported (c/u/i)? ");
            String option = sc.next().toLowerCase();
            while (true){
                if (option.equals("c") || option.equals("u") || option.equals("i")) {
                    break;
                }
                else{
                    System.out.println("[ERROR] Invalid option, the only valid option are (c/u/i): ");
                    option = sc.next();
                }
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (option.equals("c")) {
                list.add(new Product(name,price));
            }
            else if (option.equals("u")) {
                System.out.print("Manufacture date (dd/MM/yyyy):");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                list.add(new UsedProduct(name,price,date));
            }
            else {
                System.out.print("Custom fee: ");
                double customFee = sc.nextDouble();

                list.add(new ImportedProduct(name,price,customFee));
            }
        }
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }
        sc.close();
    }
}

