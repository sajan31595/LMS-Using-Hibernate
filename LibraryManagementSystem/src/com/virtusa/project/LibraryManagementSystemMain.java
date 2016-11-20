package com.virtusa.project;


public class LibraryManagementSystemMain {

	public static void main(String[] args) throws InterruptedException {
		ServiceMain serviceMain = new ServiceMain();
		// serviceMain.splashScreen();
		serviceMain.homePage();
		int chooseUser = serviceMain.intEntry("Choice");
		do {
			int userType = serviceMain.loginPage(chooseUser);
			serviceMain.adminPage();
			serviceMain.memberPage();
		} while (false);
	}
}