package com.virtusa.project;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.virtusa.project.services.database.DatabaseServices;

public class ServiceMain {

	Scanner scanner = new Scanner(System.in);
	DatabaseServices databaseServices = new DatabaseServices();

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

	}
	protected void memberPage() {
		System.out.print(
				"\n\nLMS>MEMBER>\n\nMEMBER : \n\t\t1.Issue book\n\t\t2.Return Book\n\t\t3.Search Books\n\t\t4.Logout\n\t\t5.Quit\n\nEnter Choice:");
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
