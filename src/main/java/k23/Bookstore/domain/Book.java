package k23.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private int publishingYear;
	private double price;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, String isbn, int year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishingYear = year;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;	
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPublishingYear() {
		return publishingYear;
	}
	
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishingYear=" + publishingYear + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}
	

}
