package com.virtusa.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.project.services.database.DatabaseServices;
import com.virtusa.project.users.Member;

public class LibraryManagementSystemMain {

	public static void main(String[] args) throws InterruptedException {
		ServiceMain serviceMain = new ServiceMain();
		//serviceMain.splashScreen();
		initiate();
	}
	protected static void initiate() {
		ServiceMain serviceMain = new ServiceMain();
		System.out.println("\nLMS Home Page\n");
		serviceMain.homePage();
		serviceMain.loginPage(serviceMain.intEntry("Choice"));
	}
}