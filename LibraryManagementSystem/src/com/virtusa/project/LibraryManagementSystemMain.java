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
//		serviceMain.homePage();
//		int chooseUser = serviceMain.intEntry("Choice");
//		do {
//			int userType = serviceMain.loginPage(chooseUser);
//			serviceMain.adminPage();
//			serviceMain.memberPage();
//		} while (false);
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, 103);
		System.out.println(member.getUserName());
		//session.delete(member);
		
		transaction.commit();
		member = (Member) session.get(Member.class, 103);
		System.out.println(member);
		session.close();
		sessionFactory.close();
	}
}