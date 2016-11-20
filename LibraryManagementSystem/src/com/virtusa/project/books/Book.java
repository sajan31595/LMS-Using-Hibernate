package com.virtusa.project.books;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.virtusa.project.users.Member;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	private int bookId;
	private String bookName;
	private String author;
	private int edition;
	private double rating;
	@ManyToOne
	@JoinColumn(name="memberId")
	private Member member;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author="
				+ author + ", edition=" + edition + ", rating=" + rating
				+ ", member=" + member + "]";
	}

}
