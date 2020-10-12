package com.luv2code.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.repository.PublisherRepository;
import com.luv2code.springdemo.entity.Publisher;
import com.luv2code.springdemo.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	// need to inject publisher dao
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	@Transactional
	public List<Publisher> getPublishers() {
		return publisherRepository.findAll();
	}

	@Override
	@Transactional
	public void savePublisher(Publisher thepublisher) {

		publisherRepository.save(thepublisher);
	}

	@Override
	@Transactional
	public Publisher getPublisher(int theId) {
		
		Optional<Publisher> optional = publisherRepository.findById(theId);
		 Publisher publisher = null;
			if (optional.isPresent()) {
				publisher = optional.get();
			} else {
				throw new RuntimeException(" Publisher not found for id :: " + theId);
			}
		 return publisher;
	}

	@Override
	@Transactional
	public void deletePublisher(int theId) {
		
		publisherRepository.deleteById(theId);
	}
}





