package app;

import entities.Students;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Students> studentsHashSet = new HashSet<>();
        char firstClass =  'a';
        System.out.println("How many Classes: ");
        int classes = sc.nextInt();
        for (int j = 0; j < classes; j ++ ) {
            char letter = (char) (firstClass + j);
            System.out.println("Class: " + letter);
            System.out.print("How many students: ");
            int studentsQuantity = sc.nextInt();

            for (int i = 0; i < studentsQuantity; i++) {
                int id = sc.nextInt();
                Students students = new Students(id);
                studentsHashSet.add(students);
            }
        }
        System.out.println("Number of students: " + studentsHashSet.size());
    }
}
