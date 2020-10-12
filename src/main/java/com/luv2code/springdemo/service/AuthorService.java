package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Author;

public interface AuthorService {

	public List<Author> getAuthors();

	public void saveAuthor(Author theauthor);

	public Author getAuthor(int theId);

	public void deleteAuthor(int theId);
	
}
