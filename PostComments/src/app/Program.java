package app;

import entities.Comments;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String anotherComment = "y";

        while (anotherComment.equals("y")) {

            Post post = new Post();
            Comments comments;

            System.out.print("Title: ");
            post.setTitle(sc.nextLine());

            System.out.print("How many likes this post will have? ");
            post.setLikes(sc.nextInt());

            sc.nextLine();

            System.out.print("Content: ");
            post.setContent(sc.nextLine());

            System.out.print("When this post was posted? (dd/MM/yyyy): ");
            post.setMoment(sdf.parse(sc.next()));

            sc.nextLine();

            System.out.print("How many comments you want to post? ");
            Integer commentsQuantity = sc.nextInt();
            sc.nextLine();

            List<String> commentList = new ArrayList<>();
            for (int i = 0; i < commentsQuantity; i++) {
                System.out.print("Comment " + (i + 1) + ": ");
                String commentText = sc.nextLine();
                commentList.add(commentText);
            }

            for (String commentText : commentList) {
                comments = new Comments();
                post.addComment(comments);
            }

            System.out.println("-------------");
            System.out.println("Title: " + post.getTitle());
            System.out.printf("%d likes - %s %n", post.getLikes(), sdf.format(post.getMoment()));
            System.out.println("Content: " + post.getContent());
            System.out.println("Comments:");
            for (String x : commentList) {
                System.out.println("- " + x);
            }

            while (true) {
                System.out.print("Do you want to make another post? (y/n): ");
                anotherComment = sc.nextLine().toLowerCase();
                if (anotherComment.equals("y") || anotherComment.equals("n")) {
                    break;
                } else {
                    System.out.println("[ERROR] Only (y/n) are considered answers!!!");
                }
            }
        }

        sc.close();
    }
}
