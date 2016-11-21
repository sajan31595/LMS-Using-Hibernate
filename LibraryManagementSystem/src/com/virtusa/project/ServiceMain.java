package com.virtusa.project;

import java.util.Scanner;

import com.virtusa.project.services.admin.AdminServices;
import com.virtusa.project.services.book.BookServices;
import com.virtusa.project.services.database.DatabaseServices;

public class ServiceMain {

	Scanner scanner = new Scanner(System.in);
	DatabaseServices databaseServices = new DatabaseServices();
	AdminServices adminServices = new AdminServices();
	BookServices bookServicesUtil = new BookServices();

	protected void splashScreen() {

		String library = "Welcome to Library Management System[LMS]";
		System.out.print("\n\n\n\n\t\t\t");
		for (int index = 0; index < library.length(); index++) {
			System.out.print(library.charAt(index));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("\n\n\n\n");
		System.out.println();
		for (int i = 5; i >= 0; i--) {
			System.out.print(i + "\t");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				System.out.println("\nADMIN Login");
				int adminId = intEntry("ID");
				String adminPassword = stringEntry("password");
				if (databaseServices.authenticateAdmin(adminId, adminPassword)){
					adminPage();
				}
				LibraryManagementSystemMain.initiate();
			case 2 :
				System.out.println("\n Member Login");
				int memberId = intEntry("ID");
				String memberPassword = stringEntry("password");
				if (databaseServices.authenticateMember(memberId,memberPassword)){
					memberPage(memberId);
				}
				LibraryManagementSystemMain.initiate();
			case 3 :
				printAcknowledgeMessage("\nThank U Vigit Again\n");
				System.exit(0);
			default :
				System.out.println("Invalid Choice");
				choice = intEntry("Choice");
				loginPage(choice);
		}
		return 0;
	}
	private void adminPage() {
		System.out
				.print("\n\nLMS>ADMIN>\n\nADMIN Page : \n\t\t1.Add User\n\t\t2.Update User Details\n\t\t3.Remove User\n\t\t4.Display User Details"
						+ "\n\t\t5.Add Book\n\t\t6.Update Book Details\n\t\t7.Delete Book\n\t\t8.Display Book Details\n\t\t9.Logout\n\t\t10.Quit\n\n");
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
				LibraryManagementSystemMain.initiate();
				break;
			case 10 :
				System.exit(0);
			default :
				printAcknowledgeMessage("\nWrong Choice\n");
				adminPage();
		}
	}
	private void memberPage(int memberId) {
		System.out.print(
				"\n\nLMS>MEMBER>\n\nMEMBER : \n\t\t" 
						+ "1.Issue book\n\t\t"
						+ "2.Return Book\n\t\t" 
						+ "3.View Book List\n\t\t"
						+ "4.Search Books\n\t\t" 
						+ "5.Change Password\n\t\t"
						+ "6.Logout\n\t\t" 
						+ "7.Quit\n\n");
		int memberChoose = intEntry("Choice");
		switch (memberChoose) {
			case 1 :
				bookServicesUtil.issueBook(memberId, intEntry("Book ID"));
				memberPage(memberId);
				break;
			case 2 :
				bookServicesUtil.returnBook(memberId, intEntry("Book ID"));
				memberPage(memberId);
				break;
			case 3 :
				// View Book List
				viewBookList(memberId);
				memberPage(memberId);
				break;
			case 4 :
				searchBook(memberId);
				memberPage(memberId);
				break;
			case 5 :
				databaseServices.changePassword(memberId);
				memberPage(memberId);
				break;
			case 6 :
				LibraryManagementSystemMain.initiate();
				break;
			case 7 :
				printAcknowledgeMessage("\nThank U Visit Again\n");
				System.exit(0);
			default :
				printAcknowledgeMessage("\nWrong Choice\n");
				memberPage(memberId);
		}
	}
	private void searchBook(int memberId) {
		System.out.print("\n\nLMS>MEMBER>ISSUE_BOOK>\n\nISSUE BOOK : \n\t\t"
				+ "1.Search by ID\n\t\t"
				+ "2.Search by Name\n\t\t"
				+ "3.Search by Author\n\t\t" 
				+ "4.Search by Rating\n\t\t"
				+ "5.Go Back\n\t\t" 
				+ "6.Logout\n\t\t"
				+ "7.Quit\n");
		int searchBookChoice = intEntry("Choice");
		switch (searchBookChoice) {
			case 1:
				bookServicesUtil.searchByID(intEntry("Book ID"));
				searchBook(memberId);
				break;
			case 2:
				bookServicesUtil.searchByName(stringEntry("Book Name"));
				searchBook(memberId);
				break;
			case 3:
				bookServicesUtil.searchByAuthor(stringEntry("Author Name"));
				searchBook(memberId);
				break;
			case 4:
				bookServicesUtil.searchByRating(doubleEntry("Rating"));
				searchBook(memberId);
				break;
			case 5:
				memberPage(memberId);
				//go back
				break;
			case 6:
				LibraryManagementSystemMain.initiate();
			case 7:
				printAcknowledgeMessage("\nThank U Visit Again\n");
				System.exit(0);
			default:
				printAcknowledgeMessage("Wrong Choice");
				viewBookList(memberId);
		}
	}
	private void viewBookList(int memberId) {
		System.out.print("\n\nLMS>MEMBER>ISSUE_BOOK>\n\nISSUE BOOK : \n\t\t"
				+ "1.Sort by ID\n\t\t"
				+ "2.Sort by Name\n\t\t"
				+ "3.Sort by Author\n\t\t" 
				+ "4.Sort by Rating\n\t\t"
				+ "5.Go Back\n\t\t" 
				+ "6.Logout\n\t\t"
				+ "7.Quit\n");
		int bookView = intEntry("Choice");
		switch (bookView) {
			case 1:
				bookServicesUtil.sortBooksById();
				viewBookList(memberId);
				break;
			case 2:
				bookServicesUtil.sortBooksByName();
				viewBookList(memberId);
				break;
			case 3:
				bookServicesUtil.sortByAuthor();
				viewBookList(memberId);
				break;
			case 4:
				bookServicesUtil.sortBooksByRating();
				viewBookList(memberId);
				break;
			case 5:
				//go back
				memberPage(memberId);
			case 6:
				//logout
				LibraryManagementSystemMain.initiate();
			case 7:
				printAcknowledgeMessage("\nThank U Visit Again\n");
				System.exit(0);
			default:
				printAcknowledgeMessage("Enter Valid Choice");
				viewBookList(memberId);
		}
	}
	

	public int intEntry(String type) {
		int intValue = 0;
		System.out.print("Enter " + type + ": ");
		try{
			intValue = scanner.nextInt();
		}catch(Exception e){
			printAcknowledgeMessage("\nInvalid Type\n");
			scanner.next();
			intEntry(type);
		}
		return intValue;
	}
	public String stringEntry(String type) {
		System.out.print("Enter " + type + ": ");
		String stringValue = scanner.next();
		return stringValue;
	}
	public long longEntry(String type) {
		long longValue = 0l;
		System.out.print("Enter " + type + ": ");
		try{
			longValue = scanner.nextLong();
		}catch(Exception e){
			printAcknowledgeMessage("\nInvalid Type\n");
			scanner.next();
			longEntry(type);
		}
		return longValue;
	}
	public double doubleEntry(String type) {
		double doubleValue = 0;
		System.out.print("Enter " + type + ": ");
		try{
			doubleValue = scanner.nextDouble();
		}catch(Exception e){
			printAcknowledgeMessage("\nInvalid Type\n");
			scanner.next();
			doubleEntry(type);
		}
		return doubleValue;
	}
	

	public static void printAcknowledgeMessage(String acknowledgeMessage) {
		System.out.println(acknowledgeMessage);
	}
}