package com.virtusa.project;

public class LibraryManagementSystemMain {

	public static void main(String[] args){
		ServiceMain serviceMain = new ServiceMain();
		serviceMain.splashScreen();
		initiate();
	}
	protected static void initiate() {
		ServiceMain serviceMain = new ServiceMain();
		System.out.println("\nLMS Home Page\n");
		serviceMain.homePage();
		serviceMain.loginPage(serviceMain.intEntry("Choice"));
	}
}