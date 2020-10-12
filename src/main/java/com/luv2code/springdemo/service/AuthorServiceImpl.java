package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.repository.AuthorRepository;
import com.luv2code.springdemo.entity.Author;
import com.luv2code.springdemo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	// need to inject author dao
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	@Transactional
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	@Transactional
	public void saveAuthor(Author theauthor) {

		authorRepository.save(theauthor);
	}

	@Override
	@Transactional
	public Author getAuthor(int theId) {
		
		Optional<Author> optional = authorRepository.findById(theId);
		Author author = null;
			if (optional.isPresent()) {
				author = optional.get();
			} else {
				throw new RuntimeException(" Author not found for id :: " + theId);
			}
		 return author;
	}

	@Override
	@Transactional
	public void deleteAuthor(int theId) {
		
		authorRepository.deleteById(theId);
	}
}





