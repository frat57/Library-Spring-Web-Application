package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Publisher;

public interface PublisherService {

	public List<Publisher> getPublishers();

	public void savePublisher(Publisher thepublisher);

	public Publisher getPublisher(int theId);

	public void deletePublisher(int theId);
	
}
