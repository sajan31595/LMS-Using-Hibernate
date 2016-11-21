package com.virtusa.project.ztestfiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.virtusa.project.books.Book;
import com.virtusa.project.users.Admin;
import com.virtusa.project.users.Member;

public class InitiateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Admin admin = new Admin();
		//admin.setId(102);
		admin.setPhoneNumber(888888888l);;
		admin.setUserName("admin");
		admin.setUserPassword("admin");
		
		Book book1 = new Book();
		book1.setAuthor("Author1");
		//book1.setBookId(101);
		book1.setBookName("book1");
		book1.setEdition(7);
		book1.setRating(4.5);
		
		Book book2 = new Book();
		book2.setAuthor("Author2");
		//book2.setBookId(102);
		book2.setBookName("book2");
		book2.setEdition(8);
		book2.setRating(4);
		
		Book book3 = new Book();
		book3.setAuthor("Author3");
		//book3.setBookId(103);
		book3.setBookName("book3");
		book3.setEdition(9);
		book3.setRating(3.3);
		
		Member member1 = new Member();
		//member1.setId(101);
		member1.setPhoneNumber(9999999l);
		member1.setUserName("Job");
		member1.setUserPassword("abcd");
		
		Member member2 = new Member();
		//member2.setId(102);
		member2.setPhoneNumber(989898l);
		member2.setUserName("John");
		member2.setUserPassword("abcd");
		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(book1);
		session.save(book2);
		session.save(member1);
		session.save(member2);
		session.save(book3);
		session.save(admin);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}

/*select * from books
select * from members
select * from admins
select * from members_books

desc books
desc members
desc admins
desc members_books*/

