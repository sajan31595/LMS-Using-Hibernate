package com.virtusa.project.services.book;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.virtusa.project.ServiceMain;
import com.virtusa.project.books.Book;

public class BookServicesUtil {
	
	public void sortBooksById(){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("BOOKID"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	
	public void sortBooksByName(){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("bookname"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void sortBooksByRating(){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("rating"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public  void sortByAuthor(){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("rating"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		session.close();
		sessionFactory.close();
	}
	public void searchByID(int id){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Book book =(Book)session.get(Book.class, id);
		//print 
		book.toString();
		
		session.close();
		sessionFactory.close();
	}
	public void searchByName(String name){
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		//need to fix for case insensitive matching
		criteria.add(Restrictions.eq("bookname",name));
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		session.close();
		sessionFactory.close();
	}
	public void searchByAuthor(String author){
		Configuration configuration = ServiceMain.config();
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
		Configuration configuration = ServiceMain.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Book.class);
		//need to fix for case insensitive matching
		criteria.add(Restrictions.gt("rating", rating));
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
		Configuration configuration = ServiceMain.config();
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
	
	public void issueBook(){
	}
	public void returnBook(){}
	

	
}
