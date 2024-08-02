package app;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String path = "/home/samuel-raymundo/Documents/Programming/Codes/Java/Curso-Java-Basic/StreamEx2/src/in.txt";

        Scanner sc = new Scanner(System.in);

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter the salary: ");
            double salary = sc.nextDouble();

            Comparator<String> stringComparator = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> email = list.stream()
                    .filter(employee -> employee.getSalary() >= salary)
                    .map(employee -> employee.getEmail())
                    .sorted(stringComparator)
                    .collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than " + salary);

            email.forEach(System.out::println);

            char intialLetter = 'M';
            double sum = list.stream()
                    .filter(employee -> employee.getName().charAt(0) == intialLetter)
                    .map(employee -> employee.getSalary())
                    .reduce(0.0,(x,y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sum );

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
