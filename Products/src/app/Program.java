package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.print("Birth date (dd/MM/yyyy): ");
        Date birthDate = sdf.parse(sc.next());
        sc.nextLine();

        Client client = new Client(name, email, birthDate);


        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine().toUpperCase();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

        System.out.print("How many items to this order: ");
        int itemsQuantity = sc.nextInt();

        for (int i = 0; i < itemsQuantity; i++) {
            sc.nextLine();

            System.out.printf("Enter #%d item data: %n", (1 + i));

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            System.out.println("-----------------");

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderItem);
        }


        System.out.println("-----------------");
        System.out.println("Order summary: ");
        System.out.println(order);

        sc.close();
    }
}
