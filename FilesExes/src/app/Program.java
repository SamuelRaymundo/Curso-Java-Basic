package app;

import entities.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Products> list = new ArrayList<>();
//        String[] primaryArchive = new String[]{
//                "TV LED,1290.99,1",
//                "Video Game Chair,350.50,3",
//                "Iphone X,900.00,2",
//                "Samsung Galaxy,9850.00,2"
//        };
//
        String firstArchivePath = "C:\\Users\\samue\\OneDrive\\Documentos\\FileLearn\\in.csv";
//
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(firstArchivePath))) {
//            for (String line : primaryArchive) {
//                bw.write(line);
//                bw.newLine();
//            }
//
//            System.out.println("First archive was successfully created");

        try (BufferedReader br = new BufferedReader(new FileReader(firstArchivePath))) {
            String archiveReader = br.readLine();

            while (archiveReader != null) {
                String[] splitArray = archiveReader.split(",");
                String product = splitArray[0];
                double price = Double.parseDouble(splitArray[1]);
                int quantity = Integer.parseInt(splitArray[2]);

                list.add(new Products(product, price, quantity));

                archiveReader = br.readLine();
            }


            String createFolderPath = "C:\\Users\\samue\\OneDrive\\Documentos\\FileLearn";
            boolean newArchive = new File(createFolderPath + "\\out").mkdir();
            System.out.println("Directory created successfully: " + newArchive);

            File path = new File(createFolderPath + "\\out\\summary.csv");

            try (BufferedWriter bwSummary = new BufferedWriter(new FileWriter(path))) {
                for (Products product : list) {
                    bwSummary.write(product.getProduct() + "," + String.format("%.2f", product.fullPrice()));
                    bwSummary.newLine();
                }

                System.out.println(path + " CREATED!");
            }
        }
        catch (IOException e){
        System.out.println("[ERROR] " + e.getMessage());
        }
        }
}

