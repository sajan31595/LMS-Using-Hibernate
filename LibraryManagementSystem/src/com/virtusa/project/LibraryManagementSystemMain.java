package com.virtusa.project;

public class LibraryManagementSystemMain {

	public static void main(String[] args) throws InterruptedException {
		
		ServiceMain serviceMain = new ServiceMain();
		//ServiceMain.splashScreen();
		serviceMain.loginPage();
	}
}
//Configuration configuration = new Configuration();
//configuration.configure("hibernate.cfg.xml");
//SessionFactory sessionFactory = configuration.buildSessionFactory();
//Session session = sessionFactory.openSession();
//Transaction transaction = session.beginTransaction();
//
//
//
//transaction.commit();
//session.close();
//sessionFactory.close();