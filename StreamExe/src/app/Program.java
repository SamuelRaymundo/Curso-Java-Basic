package app;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\Users\\37352\\Programming\\Codes\\Java\\Curso-Java-Basic\\StreamExe\\src\\in.txt";



        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields =  line.split(",");
                list.add(new Product(fields[0],Double.parseDouble(fields[1])));
                br.readLine();
            }

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            double avg = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0,(x,y) -> x + y ) / list.size();

            List<String> names =  list.stream()
                    .map(p -> p.getProductName())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());

            names.forEach(System.out::println);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
