package app;

import model.entities.Account;
import model.exceptions.DomainExeption;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Locale.setDefault(Locale.US);

            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();

            System.out.print("Enter amount for the withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.print("New balance: ");
            System.out.println(account.getBalance());
            sc.close();
        }
        catch (DomainExeption e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

    }
}
