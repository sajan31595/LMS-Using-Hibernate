package com.virtusa.project.services.book;

import java.util.Scanner;

public class BookServices {
	BookServicesUtil bookServicesutil = new BookServicesUtil();
	
	public void sortBooks(int n) {

        // System.out.println("Enter 1 for Sort by ID");
        // System.out.println("Enter 2 for Sort by Name");
        // System.out.println("Enter 3 for Sort by Author");
        // System.out.println("Enter 4 for Sort by Rating");
        switch (n) {
        case 1:
        	bookServicesutil.sortBooksById();
            break;
        case 2:
        	bookServicesutil.sortBooksByName();
            break;
        case 3:
            bookServicesutil.sortByAuthor();
            break;
        case 4:
           bookServicesutil.sortByAuthor();
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
        System.out.println("Enter 4 for Search by Rating (return greter than id)");
        int n = Integer.parseInt(sc.next());
        switch (n) {
        case 1:
            System.out.println("Enter the Id to search");
            int id = sc.nextInt();
            bookServicesutil.searchByID(id);
            break;
        case 2:
            System.out.println("Enter the Book Name to search");
            String name = sc.next();
            bookServicesutil.searchByName(name);
            break;
        case 3:
            System.out.println("Enter the Author Name to search");
            String author = sc.next();
            bookServicesutil.searchByAuthor(author);
            break;
        case 4:
            System.out.println("Enter the Rating to search");
            double rating = sc.nextDouble();
           bookServicesutil.searchByRating(rating);
            break;
        default:
            System.out.println("Enter a valid choice");
        }
        sc.close();
    }
}

