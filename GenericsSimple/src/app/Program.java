package app;

import services.PrintService;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values: ");
        int values = sc.nextInt();

        for (int i = 0; i < values; i++) {
            int valueAdded = sc.nextInt();
            ps.addValue(valueAdded);
        }
        ps.print();
        System.out.println(ps.first());

    }
}
