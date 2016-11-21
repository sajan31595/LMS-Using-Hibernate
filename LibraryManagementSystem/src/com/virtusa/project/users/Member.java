package com.virtusa.project.users;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.virtusa.project.books.Book;

@Entity
@Table(name = "members")
public class Member extends User{
	
	@Override
	@Id
	@Column(name = "memberId")
	@GeneratedValue( generator = "generatorM",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="generatorM",sequenceName="MEMBER_SEQ") 
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}
	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}
	@Override
	public String getUserPassword() {
		// TODO Auto-generated method stub
		return super.getUserPassword();
	}
	@Override
	public void setUserPassword(String userPassword) {
		// TODO Auto-generated method stub
		super.setUserPassword(userPassword);
	}
	@Override
	public long getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}
	@Override
	public void setPhoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}
	
	private List<Book> book;
	@OneToMany
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public void setBook(Book book) {
		this.book.add(book);
	}
	public boolean removeIssuedBooks(int bookId){
		//Used to remove given issued book from book list 
		boolean flag=false;
		for(Iterator<Book> iter = book.listIterator();iter.hasNext(); ){
			Book obj =iter.next();
			if(obj.getBookId() == bookId){
				iter.remove();
				flag=true;
			}
		}
		return flag;
	}
	@Override
	public String toString() {
		return "Member [getId()=" + getId() + ", getUserName()=" + getUserName()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getBook()="
				+ getBook() + "]";
	}
	
	
}
