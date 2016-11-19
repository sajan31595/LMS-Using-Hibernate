package com.virtusa.project;

import java.util.Scanner;

import org.hibernate.cfg.Configuration;

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
	protected void loginPage() {
		System.out.println();
        System.out.print("Login as : \n\t\t1.Admin\n\t\t2.Member\n\t\t3.Quit\n\nEnter Choice:");
	}
	protected int intEntry(String str){
		System.out.println("Enter "+str);
		int intValue = scanner.nextInt();
		scanner.close();
		return intValue;
	}
	protected String stringEntry(String str){
		System.out.println("Enter "+str);
		String stringValue = scanner.next();
		scanner.close();
		return stringValue;
	}
	protected long longEntry(String str){
		System.out.println("Enter "+str);
		long longValue = scanner.nextLong();
		scanner.close();
		return longValue;
	}
	protected double doubleEntry(String str){
		System.out.println("Enter "+str);
		double doubleValue = scanner.nextDouble();
		scanner.close();
		return doubleValue;
	}
	public static Configuration config(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		return configuration;
	}
	
}
