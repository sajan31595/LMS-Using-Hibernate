package com.virtusa.project.services.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.project.books.Book;
import com.virtusa.project.users.Admin;
import com.virtusa.project.users.Member;

public class DatabaseServices {

	public boolean authenticateAdmin(int adminId,String passwd) {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		if(validateAdminId(adminId)){
			Admin admin = (Admin) session.get(Admin.class, adminId);
			if(admin.getId() == adminId && admin.getUserPassword().equals(passwd)){
				transaction.commit();
				session.close();
				sessionFactory.close();
				System.out.println("\nAuthentication Successful\n");
				return true;
			}
			else{
				transaction.commit();
				session.close();
				sessionFactory.close();
				System.out.println("\nInvalid User ID or Password\n");
				return false;
			}
		}
		System.out.println("\nUser ID does not exist\n");
		return false;
	}
	public boolean authenticateMember(int mamberId,String passwd) {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		if(validateMemberId(mamberId)){
			Member member = (Member) session.get(Member.class, mamberId);
			if(member.getId() == mamberId && member.getUserPassword().equals(passwd)){
				transaction.commit();
				session.close();
				sessionFactory.close();
				System.out.println("\nAuthentication Successful\n");
				return true;
			}
			else{
				transaction.commit();
				session.close();
				sessionFactory.close();
				System.out.println("\nInvalid User ID or Password\n");
				return false;
			}
		}
		System.out.println("\nUser ID does not exist\n");
		return false;
	}
	public boolean validateBookId(int bookId) {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Book book = (Book) session.get(Book.class, bookId);
		if(book != null){
			transaction.commit();
			session.close();
			sessionFactory.close();
			return true;
		}
		else{
			transaction.commit();
			session.close();
			sessionFactory.close();
			return false;
		}
	}
	public boolean validateMemberId(int memberId) {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, memberId);
		if(member != null){
			transaction.commit();
			session.close();
			sessionFactory.close();
			return true;
		}
		else{
			transaction.commit();
			session.close();
			sessionFactory.close();
			return false;
		}
	}
	public boolean validateAdminId(int adminId) {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Admin admin = (Admin) session.get(Admin.class, adminId);
		if(admin != null){
			transaction.commit();
			session.close();
			sessionFactory.close();
			return true;
		}
		else{
			transaction.commit();
			session.close();
			sessionFactory.close();
			return false;
		}
	}
	public static Configuration config(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		return configuration;
	}
}
