package com.virtusa.project;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.virtusa.project.services.admin.AdminServices;
import com.virtusa.project.services.book.BookServices;
import com.virtusa.project.services.database.DatabaseServices;

public class ServiceMain {

	Scanner scanner = new Scanner(System.in);
	DatabaseServices databaseServices = new DatabaseServices();
	AdminServices adminServices = new AdminServices();
	BookServices bookServicesUtil = new BookServices();

	protected void splashScreen() throws InterruptedException {

		String library = "Welcome to Library Management System[LMS]";
		System.out.print("\n\n\n\n\t\t\t");
		for (int index = 0; index < library.length(); index++) {
			System.out.print(library.charAt(index));
			Thread.sleep(100);
		}
		System.out.print("\n\n\n\n");
		System.out.println();
		for (int i = 5; i >= 0; i--) {
			System.out.print(i + "\t");
			Thread.sleep(500);
		}
		System.out.print("\n\n\n\n");
	}
	protected void homePage() {
		printAcknowledgeMessage(
				"\nLogin as : \n\t\t1.Admin\n\t\t2.Member\n\t\t3.Quit\n\n");
	}
	protected int loginPage(int choice) {
		switch (choice) {
			case 1 :
				int adminId = intEntry("ID");
				String adminPassword = stringEntry("password");
				if (databaseServices.authenticateAdmin(adminId, adminPassword))
					return 1;
				return 0;
			case 2 :
				int memberId = intEntry("ID");
				String memberPassword = stringEntry("password");
				if (databaseServices.authenticateMember(memberId,
						memberPassword))
					return 1;
				return 0;
			case 3 :
				System.exit(0);
				return 0;
			default :
				System.out.println("Invalid Choice");
				choice = intEntry("Choice");
				loginPage(choice);
		}
		return 0;
	}
	protected void adminPage() {
		System.out
				.print("\n\nLMS>ADMIN>\n\nADMIN Page : \n\t\t1.Add User\n\t\t2.Update User Details\n\t\t3.Remove User\n\t\t4.Display User Details"
						+ "\n\t\t5.Add Book\n\t\t6.Change Book Availability\n\t\t7.Delete Book\n\t\t8.Display Book Details\n\t\t9.Logout\n\t\t10.Quit\n\n");
		int adminChoose = intEntry("Choice");
		switch (adminChoose) {
			case 1 :
				System.out.println("Enter the Details of the user : ");
				adminServices.addUser();
				adminPage();
				break;
			case 2 :
				adminServices.updateUserDetails();
				adminPage();
				break;
			case 3 :
				adminServices.removeUser();
				adminPage();
				break;
			case 4 :
				adminServices.displayUserDetails();
				adminPage();
				break;
			case 5 :
				adminServices.addBook();
				adminPage();
				break;
			case 6 :
				adminServices.updateBookDetails();
				adminPage();
				break;
			case 7 :
				adminServices.removeBook();
				adminPage();
				break;
			case 8 :
				adminServices.displayBookDetails();
				adminPage();
				break;
			case 9 :
				// logout
				break;
			case 10 :
				System.exit(0);
			default :
				break;
		}
	}
	protected void memberPage() {
		System.out.print(
				"\n\nLMS>MEMBER>\n\nMEMBER : \n\t\t" 
						+ "1.Issue book\n\t\t"
						+ "2.Return Book\n\t\t" 
						+ "3.View Book List\n\t\t"
						+ "4.Search Books\n\t\t" 
						+ "5.Change Password\n\t\t"
						+ "6.Logout\n\t\t" 
						+ "7.Quit\n\nEnter Choice:4");
		switch (4) {
			case 1 :
				// Issue
				break;
			case 2 :
				// Return
				break;
			case 3 :
				// View Book List
				viewBookList();
				break;
			case 4 :
				searchBook();
				break;
			case 5 :
				break;
			case 6 :
				break;
			case 7 :
				System.exit(0);
			default :
				break;
		}
	}

	private void searchBook() {
		System.out.print("\n\nLMS>MEMBER>ISSUE_BOOK>\n\nISSUE BOOK : \n\t\t"
				+ "1.Search by ID\n\t\t"
				+ "2.Search by Name\n\t\t"
				+ "3.Search by Author\n\t\t" 
				+ "4.Search by Rating"
				+ "5.Go Back\n\t\t" 
				+ "6.Logout\n\t\t"
				+ "7.Quit\n\nEnter Choice:1");
		switch (1) {
			case 1:
				bookServicesUtil.searchByID(101);
				break;
			case 2:
				bookServicesUtil.searchByName("book1");
				break;
			case 3:
				bookServicesUtil.searchByAuthor("Author1");
				break;
			case 4:
				bookServicesUtil.searchByRating(4);
				break;
			case 5:
				//go back
				break;
			case 6:
				//logout
				break;
			case 7:
				System.exit(0);
			default:
				printAcknowledgeMessage("Enter Valid Choice");
				viewBookList();
		}
	}
	private void viewBookList() {
		System.out.print("\n\nLMS>MEMBER>ISSUE_BOOK>\n\nISSUE BOOK : \n\t\t"
				+ "1.Sort by ID\n\t\t"
				+ "2.Sort by Name\n\t\t"
				+ "3.Sort by Author\n\t\t" 
				+ "4.Sort by Rating"
				+ "5.Go Back\n\t\t" 
				+ "6.Logout\n\t\t"
				+ "7.Quit\n\nEnter Choice:");
		switch (1) {
			case 1:
				bookServicesUtil.sortBooksById();
				break;
			case 2:
				bookServicesUtil.sortBooksByName();
				break;
			case 3:
				bookServicesUtil.sortByAuthor();
				break;
			case 4:
				bookServicesUtil.sortByAuthor();
				break;
			case 5:
				//go back
				break;
			case 6:
				//logout
				break;
			case 7:
				System.exit(0);
			default:
				printAcknowledgeMessage("Enter Valid Choice");
				viewBookList();
		}
	}
	public int intEntry(String type) {
		System.out.print("Enter " + type + ": ");
		int intValue = scanner.nextInt();
		return intValue;
	}
	public String stringEntry(String type) {
		System.out.print("Enter " + type + ": ");
		String stringValue = scanner.next();
		return stringValue;
	}
	public long longEntry(String type) {
		System.out.print("Enter " + type + ": ");
		long longValue = scanner.nextLong();
		return longValue;
	}
	public double doubleEntry(String type) {
		System.out.print("Enter " + type + ": ");
		double doubleValue = scanner.nextDouble();
		return doubleValue;
	}
	public static void printAcknowledgeMessage(String acknowledgeMessage) {
		System.out.println(acknowledgeMessage);
	}
}
