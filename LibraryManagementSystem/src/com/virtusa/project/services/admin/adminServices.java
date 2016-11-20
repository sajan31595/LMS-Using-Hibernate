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

	ServiceMain serviceMain = new ServiceMain();

	public void addUser() {

		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Member member = new Member();
		member.setId(serviceMain.intEntry("Id"));
		member.setUserName(serviceMain.stringEntry("UserName"));
		member.setUserPassword(serviceMain.stringEntry("Password"));
		member.setPhoneNumber(serviceMain.longEntry("Phone No"));

		session.save(member);
		transaction.commit();
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
		
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Member.class);
		
		int id = serviceMain.intEntry("Enter the id of the User :");
		criteria.setProjection(Projections.property("studentId"));
		List<Member> member = criteria.list();
		int found=0;
		Iterator it=member.iterator();
		while(it.hasNext())
		{
			if(id==Integer.parseInt(it.next()+""));
			{
				found=1;
				System.out.println("User exists!!!");
				break;
			}
		}
		if(found==1)
		{
			Query query = session.createQuery("delete from member where id=(?)");
			query.setInteger("id", id);
			transaction.commit();
		}
		else if(found==0)
		{
			System.out.println("User doesnot exist \nTryagain!!!!\n ");
			new AdminServices().removeUser();
		}		
		session.close();
		sessionFactory.close();

	}
	public void updateUserDetails() {
		
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Update the Details of User");
		int id = serviceMain.intEntry("Enter the id of the User :");
		Member member = (Member)session.get(Member.class, id);
		member.setUserName(serviceMain.stringEntry("UserName"));
		member.setUserPassword(serviceMain.stringEntry("Password"));
		member.setPhoneNumber(serviceMain.longEntry("Phone No"));
		session.saveOrUpdate(member);
		
		
		session.close();
		sessionFactory.close();
		

	}
	public void addBook() {
		
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Book book = new Book();
		book.setBookId(serviceMain.intEntry("Book Id"));
		book.setBookName(serviceMain.stringEntry("Book Name"));
		book.setAuthor(serviceMain.stringEntry("Author Name"));
		book.setEdition(serviceMain.intEntry("Phone No"));
		book.setRating(serviceMain.doubleEntry("Rating"));

		session.save(book);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public void updateBookDetails() {
		
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Update the Details of User");
		int id = serviceMain.intEntry("Enter the id of the User :");
		Book book = (Book)session.get(Book.class, id);
		book.setBookName(serviceMain.stringEntry("Book Name"));
		book.setAuthor(serviceMain.stringEntry("Author Name"));
		book.setEdition(serviceMain.intEntry("Phone No"));
		book.setRating(serviceMain.doubleEntry("Rating"));
		
		
		session.close();
		sessionFactory.close();

	}
	public void removeBook() {
		
		Configuration cfg = DatabaseServices.config();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Member.class);
		
		int id = serviceMain.intEntry("Enter the id of the Book :");
		criteria.setProjection(Projections.property("bookId"));
		List<Book> book = criteria.list();
		int found=0;
		Iterator it=book.iterator();
		while(it.hasNext())
		{
			if(id==Integer.parseInt(it.next()+""));
			{
				found=1;
				System.out.println("Book exists!!!");
				break;
			}
		}
		if(found==1)
		{
			Query query = session.createQuery("delete from book where id=(?)");
			query.setInteger("id", id);
			transaction.commit();
		}
		else if(found==0)
		{
			System.out.println("Book doesnot exist \nTryagain!!!!\n ");
			new AdminServices().removeUser();
		}		
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