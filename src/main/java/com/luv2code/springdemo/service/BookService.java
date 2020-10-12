package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Book;

public interface BookService {

	public List<Book> search(String keyword);
	
	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);
	
}
