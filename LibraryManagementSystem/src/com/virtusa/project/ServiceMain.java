package com.virtusa.project;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.virtusa.project.services.admin.AdminServices;
import com.virtusa.project.services.database.DatabaseServices;

public class ServiceMain {

	Scanner scanner = new Scanner(System.in);
	DatabaseServices databaseServices = new DatabaseServices();
	AdminServices adminServices = new AdminServices();

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
						+ "\n\t\t5.Add Book\n\t\t6.Change Book Availability\n\t\t7.Delete Book\n\t\t8.Display Book Details\n\t\t9.Logout\n\t\t10.Quit\n\nEnter Choice:");
		switch (2) {
            case 1:
            	System.out.println("Enter the Details of the user : ");
            	adminServices.addUser();
                break;
            case 2:
            	adminServices.updateUserDetails();
            	break;
            case 3:
            	adminServices.removeUser();
            	break;
            case 4:
            	adminServices.displayUserDetails();
            	break;
            case 5:
            	adminServices.addBook();
            	break;
            case 6:
            	adminServices.updateBookDetails();
            	break;
            case 7:
            	adminServices.removeBook();
            	break;
            case 8:
            	adminServices.displayBookDetails();
            	break;
            case 9:
            	//logout
            	break;
            case 10:
            	System.exit(0);
            default:
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
				+ "7.Quit\n\nEnter Choice:");
		switch(1){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.exit(0);
			default:
				break;
		}
	}

	public int intEntry(String type) {
		System.out.print("Enter " + type + ": ");
		int intValue = scanner.nextInt();
		return intValue;
	}
	public String stringEntry(String type) {
		System.out.print("\t\tEnter " + type + ": ");
		String stringValue = scanner.next();
		return stringValue;
	}
	public long longEntry(String type) {
		System.out.print("\t\tEnter " + type + ": ");
		long longValue = scanner.nextLong();
		return longValue;
	}
	public double doubleEntry(String type) {
		System.out.print("\t\tEnter " + type + ": ");
		double doubleValue = scanner.nextDouble();
		return doubleValue;
	}
	public void printAcknowledgeMessage(String acknowledgeMessage) {
		System.out.println(acknowledgeMessage);
	}
}
