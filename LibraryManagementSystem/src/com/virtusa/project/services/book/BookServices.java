package com.virtusa.project.services.book;

import java.util.Scanner;

public class BookServices {
	
	public void sortBooks(int n) {

        // System.out.println("Enter 1 for Sort by ID");
        // System.out.println("Enter 2 for Sort by Name");
        // System.out.println("Enter 3 for Sort by Author");
        // System.out.println("Enter 4 for Sort by Rating");
        switch (n) {
        case 1:
            
            break;
        case 2:
           
            break;
        case 3:
            
            break;
        case 4:
           
            break;
        default:
            System.out.println("Enter a valid choice");
        }
    }
    /*
     * to search a book in the database.
     */
    public void searchBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for Search by ID");
        System.out.println("Enter 2 for Search by Name");
        System.out.println("Enter 3 for Search by Author");
        System.out.println("Enter 4 for Search by Rating");
        int n = Integer.parseInt(sc.next());
        switch (n) {
        case 1:
            System.out.println("Enter the Id to search");
            int id = sc.nextInt();
            
            break;
        case 2:
            System.out.println("Enter the Book Name to search");
            String name = sc.next();
           
            break;
        case 3:
            System.out.println("Enter the Author Name to search");
            String author = sc.next();
            
            break;
        case 4:
            System.out.println("Enter the Rating to search");
            double rating = sc.nextDouble();
           
            break;
        default:
            System.out.println("Enter a valid choice");
        }
        sc.close();
    }
}

