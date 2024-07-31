package app;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the path: ");
        String path = "C:\\Users\\37352\\Programming\\Codes\\Java\\Curso-Java-Basic\\SetExe1\\src\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            Set<LogEntry> logEntries = new HashSet<>();
            String line = br.readLine();
            while (line != null) {
                String[] fileSplit = line.split(" ");
                String name = fileSplit[0];
                Date moment = Date.from(Instant.parse(fileSplit[1]));
                LogEntry entry = new LogEntry(name,moment);
                logEntries.add(entry);

                line = br.readLine();
            }
            System.out.println("Size: " +  logEntries.size());

        }
        catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }
}
