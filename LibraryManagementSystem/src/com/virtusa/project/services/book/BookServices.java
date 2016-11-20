package com.virtusa.project.services.book;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.virtusa.project.ServiceMain;
import com.virtusa.project.books.Book;
import com.virtusa.project.services.database.DatabaseServices;
import com.virtusa.project.users.Member;

public class BookServices {
	
	public void sortBooksById(){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("bookId"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void sortBooksByName(){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("bookName"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void sortBooksByRating(){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.desc("rating"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void sortByAuthor(){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("author"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void searchByID(int id){
	
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Book book =(Book)session.get(Book.class, id);
		//print 
		System.out.println(book);
		
		session.close();
		sessionFactory.close();
	}
	public void searchByName(String name){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		//need to fix for case insensitive matching
		criteria.add(Restrictions.eq("bookName",name));
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		session.close();
		sessionFactory.close();
	}
	public void searchByAuthor(String author){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		//need to fix for case insensitive matching
		criteria.add(Restrictions.eq("author",author));
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void searchByRating(double rating){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		//need to fix for case insensitive matching
		criteria.add(Restrictions.ge("rating", rating));
		criteria.addOrder(Order.asc("rating"));
		
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void displayBookList(){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		session.close();
		sessionFactory.close();
	}
	/*
	 *  Book Issue 
	 */
	public void issueBook(int memberId, int bookId) {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, memberId);
		if (member!=null){
			if(member.getBook().size()<3){
				Book book = (Book) session.get(Book.class, bookId);
				if(book != null){
					if(book.getMember() == null){
						member.setBook(book);
						book.setMember(member);
						session.saveOrUpdate(book);
						transaction.commit();
						System.out.println("Book Succefully Issued");
					}
					else{
						System.out.println("This book is Not available");
					}
				}
				else{
					System.out.println("Book Not found, Check Book Id Again");
				}
			}
			else{
				System.out.println("You Already Issued 3 books : Max Issue limit");
			}
		}
		else{
			System.out.println("Invalid User !!");
		}

		
		session.close();
		sessionFactory.close();
	}
	public void returnBook(int memberId,int bookId){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, memberId);
		if (member!=null){
			if(member.removeIssuedBooks(bookId)){
				Book book = (Book) session.get(Book.class, bookId);
				book.setMember(null);
				session.saveOrUpdate(book);
				transaction.commit();
				System.out.println("Book Successfully returend, Thank you");
			}
			else{
				System.out.println("Book is not found in your issued List");
			}
		}
		else{
			System.out.println("Invalid User !!");
		}
		session.close();
		sessionFactory.close();
	}
}
