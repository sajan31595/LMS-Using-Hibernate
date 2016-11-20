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

import com.virtusa.project.books.Book;
import com.virtusa.project.services.database.DatabaseServices;
import com.virtusa.project.users.Member;

public class BookServicesUtil {
	/*
	 * Sort book by Id in asc order
	 */
	public void sortBooksById() {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("BOOKID"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 * Sort Book by name in asc order
	 */

	public void sortBooksByName() {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("bookname"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 * Sort Book By rating in descending order
	 */
	public void sortBooksByRating() {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.desc("rating"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 * Sort by Author in asc order
	 */
	public void sortByAuthor() {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		criteria.addOrder(Order.asc("rating"));
		List<Book> books = criteria.list();
		Iterator iterator = books.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 * Search book by Id
	 */
	public void searchByID(int id) {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Book book = (Book) session.get(Book.class, id);
		// print
		book.toString();

		session.close();
		sessionFactory.close();
	}
	/*
	 * Searching book By name
	 */
	public void searchByName(String name) {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		// need to fix for case insensitive matching
		criteria.add(Restrictions.eq("bookname", name));
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 *  Searching Author
	 */
	public void searchByAuthor(String author) {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		// need to fix for case insensitive matching
		criteria.add(Restrictions.eq("author", author));
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 * Search Book By rating return all book greater than given
	 * rating in asc order
	 */
	public void searchByRating(double rating) {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		// need to fix for case insensitive matching
		criteria.add(Restrictions.gt("rating", rating));
		criteria.addOrder(Order.asc("rating"));

		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		session.close();
		sessionFactory.close();
	}
	/*
	 *  Display Complete Book List
	 */
	public void displayBookList() {
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Book.class);
		List<Book> book = criteria.list();
		Iterator iterator = book.iterator();

		while (iterator.hasNext()) {
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
			if(member.getBook().size()<=3){
				Book book = (Book) session.get(Book.class, bookId);
				if(book != null){
					if(book.getMember() == null){
						member.setBook(book);
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

		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	/*
	 * return books 
	 */
	public void returnBook(int memberId,int bookId){
		Configuration configuration = DatabaseServices.config();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Member member = (Member) session.get(Member.class, memberId);
		if (member!=null){
			if(member.removeIssuedBooks(bookId)){
				System.out.println("Book Successfully returend, Thank you");
			}
			else{
				System.out.println("Book is not found in your issued List");
			}
		}
		else{
			System.out.println("Invalid User !!");
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
