package com.luv2code.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="subtitle")
	private String subtitle;
	
	@Column(name="series_name")
	private String series_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private Author author;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="details")
	private String details;
	
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Book() {
		
	}

	public Book(int id, String name, String subtitle, String series_name, String isbn,
			String details) {
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.series_name = series_name;
		this.isbn = isbn;
		this.details = details;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", subtitle=" + subtitle + ", series_name=" + series_name
				+  "isbn=" + isbn + ", details," + details + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


		
}





