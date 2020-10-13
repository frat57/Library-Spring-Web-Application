package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Author;
import com.luv2code.springdemo.entity.Book;
import com.luv2code.springdemo.entity.Publisher;
import com.luv2code.springdemo.service.BookService;
import com.luv2code.springdemo.service.PublisherService;
import com.luv2code.springdemo.service.AuthorService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;
	
	
	@RequestMapping("/search")
	public String search(@RequestParam String keyword,Model theModel) {
	    List<Book> result = bookService.search(keyword);
	    
	    theModel.addAttribute("books", result);
	   
	    return "/search";    
	}
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		
		List<Book> theBooks = bookService.getBooks();
		
		theModel.addAttribute("books", theBooks);
		
		return "/list-books";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		List<Author> theAuthors = authorService.getAuthors();
		
		theModel.addAttribute("author", theAuthors);
		
		List<Publisher> thePublishers = publisherService.getPublishers();
		
		theModel.addAttribute("publisher", thePublishers);


		return"book-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book theBook,BindingResult bindingResult) {
		try {
		bookService.saveBook(theBook);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/book/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId ,
									Model theModel) {
		
		Book theBook = bookService.getBook(theId);
		
		theModel.addAttribute("book", theBook);
		
		List<Author> theAuthors = authorService.getAuthors();
		
		theModel.addAttribute("author", theAuthors);
		
		List<Publisher> thePublishers = publisherService.getPublishers();
		
		theModel.addAttribute("publisher", thePublishers);
		
				return "book-form";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int theId){
		
		bookService.deleteBook(theId);
		
		
		return "redirect:/book/list";
		
	}
}
