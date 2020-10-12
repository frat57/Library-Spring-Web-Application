package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Book;
import com.luv2code.springdemo.repository.BookRepository;
import com.luv2code.springdemo.service.BookService;

@Service
public class BookServiceimpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	@Transactional
	public List<Book> search(String keyword) {
	    return bookRepository.search(keyword);
	}
	
	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		bookRepository.save(theBook);
		
	}

	@Override
	@Transactional
	public Book getBook(int theId) {

		Optional<Book> optional = bookRepository.findById(theId);
		 Book book = null;
			if (optional.isPresent()) {
				book = optional.get();
			} else {
				throw new RuntimeException(" Book not found for id :: " + theId);
			}
		 return book;
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {
		
		bookRepository.deleteById(theId);
		
	}

}
