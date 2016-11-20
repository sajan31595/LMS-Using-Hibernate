package com.virtusa.project.services.admin;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import com.virtusa.project.ServiceMain;
import com.virtusa.project.books.Book;
import com.virtusa.project.services.database.DatabaseServices;
import com.virtusa.project.users.Member;

public class AdminServices {

	

	public void addUser() {
		
		ServiceMain serviceMain = new ServiceMain();
		Member member = new Member();
		member.setId(serviceMain.intEntry("Id"));
		member.setUserName(serviceMain.stringEntry("UserName"));
		member.setUserPassword(serviceMain.stringEntry("Password"));
		member.setPhoneNumber(serviceMain.longEntry("Phone No"));

		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.save(member);
		transaction.commit();
		
		DatabaseServices databaseServices = new DatabaseServices();
		if(databaseServices.validateMemberId(member.getId())){
			ServiceMain.printAcknowledgeMessage("\nUser "+member.getUserName()+" added successfully\n");			
		}else{
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
		}
		session.close();
		sessionFactory.close();

	}
	public void displayUserDetails() {

		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Member.class);
		List<Member> member = criteria.list();
		Iterator it = member.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}

		transaction.commit();
		session.close();
		sessionFactory.close();

	}
	public void removeUser() {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		DatabaseServices databaseServices = new DatabaseServices();
		
		int memberId = serviceMain.intEntry("ID");
		Member member = (Member) session.get(Member.class, memberId);
		if(databaseServices.validateMemberId(memberId)){
			session.delete(member);		
		}else{
			ServiceMain.printAcknowledgeMessage("\nEnter Valid ID\n");
			removeUser();
		}
		
		transaction.commit();
		member = (Member) session.get(Member.class, memberId);
		if(member == null)
			ServiceMain.printAcknowledgeMessage("\nUser Deleted Successfully\n");
		else
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
		session.close();
		sessionFactory.close();

	}
	public void updateUserDetails() {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		System.out.println("Update the Details of User");
		int id = serviceMain.intEntry("ID");
		Member member = (Member)session.get(Member.class, id);
		member.setUserName(serviceMain.stringEntry("UserName"));
		member.setUserPassword(serviceMain.stringEntry("Password"));
		member.setPhoneNumber(serviceMain.longEntry("Phone No"));
		session.saveOrUpdate(member);
		transaction.commit();
		ServiceMain.printAcknowledgeMessage("\nUser Updated Successfully\n");
		session.close();
		sessionFactory.close();
		

	}
	public void addBook() {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Book book = new Book();
		book.setBookId(serviceMain.intEntry("Book Id"));
		book.setBookName(serviceMain.stringEntry("Book Name"));
		book.setAuthor(serviceMain.stringEntry("Author Name"));
		book.setEdition(serviceMain.intEntry("Edition"));
		book.setRating(serviceMain.doubleEntry("Rating"));

		session.save(book);
		transaction.commit();
		serviceMain.printAcknowledgeMessage("\nBook added successfully\n");
		session.close();
		sessionFactory.close();
	}
	public void updateBookDetails() {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Update the Details of User");
		int id = serviceMain.intEntry("ID");
		Book book = (Book)session.get(Book.class, id);
		book.setBookName(serviceMain.stringEntry("Book Name"));
		book.setAuthor(serviceMain.stringEntry("Author Name"));
		book.setEdition(serviceMain.intEntry("Edition"));
		book.setRating(serviceMain.doubleEntry("Rating"));
		
		session.saveOrUpdate(book);
		
		transaction.commit();
		ServiceMain.printAcknowledgeMessage("\nBook Updated Successfully\n");
		session.close();
		sessionFactory.close();

	}
	public void removeBook() {
		
		ServiceMain serviceMain = new ServiceMain();
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		DatabaseServices databaseServices = new DatabaseServices();
		
		int bookId = serviceMain.intEntry("ID");
		Book book = (Book) session.get(Book.class, bookId);
		if(databaseServices.validateBookId(bookId)){
			session.delete(book);		
		}else{
			ServiceMain.printAcknowledgeMessage("\nEnter Valid ID\n");
			removeBook();
		}
		
		transaction.commit();
		book = (Book) session.get(Book.class, bookId);
		if(book == null)
			ServiceMain.printAcknowledgeMessage("\nBook Deleted Successfully\n");
		else
			ServiceMain.printAcknowledgeMessage("\nSomething went wrong\n");
				
		session.close();
		sessionFactory.close();

	}
	public void displayBookDetails() {
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Book.class);
		List<Book> book = criteria.list();
		Iterator it = book.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}

		transaction.commit();
		session.close();
		sessionFactory.close();

	}
}