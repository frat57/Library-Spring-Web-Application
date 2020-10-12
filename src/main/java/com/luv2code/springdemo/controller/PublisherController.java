package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Publisher;
import com.luv2code.springdemo.service.PublisherService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/list")
	public String listPublishers(Model theModel) {
		
		List<Publisher> thePublishers = publisherService.getPublishers();
		
		theModel.addAttribute("publishers", thePublishers);
		
		return "/list-publishers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Publisher thePublishers = new Publisher();
		
		theModel.addAttribute("publisher", thePublishers);
		
		return"publisher-form";
	}
	
	@PostMapping("/savePublisher")
	public String savePublisher(@ModelAttribute("publisher") Publisher thePublisher) {
		
		publisherService.savePublisher(thePublisher);
		return "redirect:/publisher/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("publisherId") int theId ,
									Model theModel) {
		
		Publisher thePublisher = publisherService.getPublisher(theId);
		
		theModel.addAttribute("publisher", thePublisher);
		
		
				return "publisher-form";
	}
	
	@GetMapping("/delete")
	public String deletePublisher(@RequestParam("publisherId") int theId){
		
		publisherService.deletePublisher(theId);
		
		
		return "redirect:/publisher/list";
		
	}
}
