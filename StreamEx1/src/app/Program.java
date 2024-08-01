package app;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String path = "/home/samuel-raymundo/Documents/Programming/Codes/Java/Curso-Java-Basic/StreamEx2again/src/in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> productList = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                productList.add(new Product(fields[0],Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            double avg = productList.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0,(x,y) -> x + y ) / productList.size();

            System.out.println(String.format("Average price: %.2f", avg));

            Comparator<String> comp = (p1, p2) -> p1.toUpperCase().compareTo(p2.toUpperCase());

            List<String> productsName = productList.stream()
                    .filter(p -> p.getPrice() < avg)
                    .map(p -> p.getName())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());

            productsName.forEach(System.out::println);

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
