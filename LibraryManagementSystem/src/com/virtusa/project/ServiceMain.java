package com.virtusa.project;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

import com.virtusa.project.services.database.DatabaseServices;

public class ServiceMain {
	
	Scanner scanner = new Scanner(System.in);
	
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
        printAcknowledgeMessage("\nLogin as : \n\t\t1.Admin\n\t\t2.Member\n\t\t3.Quit\n\nEnter Choice:");
	}
	protected void loginPage() {
		int adminId = intEntry("ID");
		String passwd = stringEntry("password");
		DatabaseServices databaseServices = new DatabaseServices();
		databaseServices.authenticateAdmin(adminId, passwd);
	}
	public int intEntry(String type){
		System.out.print("\t\tEnter " +type+ ": ");
		int intValue = scanner.nextInt();
		return intValue;
	}
	public String stringEntry(String type){
		System.out.print("\t\tEnter " +type+ ": ");
		String stringValue = scanner.next();
		return stringValue;
	}
	public long longEntry(String type){
		System.out.print("\t\tEnter " +type+ ": ");
		long longValue = scanner.nextLong();
		return longValue;
	}
	public double doubleEntry(String type){
		System.out.print("\t\tEnter " +type+ ": ");
		double doubleValue = scanner.nextDouble();
		return doubleValue;
	}
	public void printAcknowledgeMessage(String acknowledgeMessage){
		System.out.println(acknowledgeMessage);
	}
}
