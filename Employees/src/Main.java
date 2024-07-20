import entities.Employee;
import entities.Outsourced;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int employeeQuantity = sc.nextInt();

        for (int i = 0;i < employeeQuantity;i++) {
            System.out.print("Outsourced (y/n): ");
            String outsourced = sc.next().toLowerCase();
            while (true){
                if (outsourced.equals("y") || outsourced.equals("n")){
                    break;
                }
                else {
                    System.out.print("[ERROR] Only (y/n) are considered answers: ");
                    outsourced = sc.next().toLowerCase();
                }
            }

            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (outsourced.equals("y")){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                list.add(new Outsourced(name,hours,valuePerHour,additionalCharge));
            }
            else {
               list.add(new Employee(name,hours,valuePerHour));
            }
        }
        System.out.println("Payments: ");
        for (Employee emp : list){
            System.out.println(emp.getName() + "- $ " + emp.payment());
        }
    }
}