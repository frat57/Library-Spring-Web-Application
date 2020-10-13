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

import com.luv2code.springdemo.entity.Author;
import com.luv2code.springdemo.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/list")
	public String listAuthors(Model theModel) {
		
		List<Author> theAuthors = authorService.getAuthors();
		
		theModel.addAttribute("authors", theAuthors);
		
		return "/list-authors";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Author theAuthors = new Author();
		
		theModel.addAttribute("author", theAuthors);
		
		return"author-form";
	}
	
	@PostMapping("/saveAuthor")
	public String saveauthor(@ModelAttribute("author") Author theAuthor) {
		
		authorService.saveAuthor(theAuthor);
		
		return "redirect:/author/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("authorId") int theId ,
									Model theModel) {
		
		Author theAuthor = authorService.getAuthor(theId);
		
		theModel.addAttribute("author", theAuthor);
		
		
				return "author-form";
	}
	
	@GetMapping("/delete")
	public String deleteauthor(@RequestParam("authorId") int theId){
		
		authorService.deleteAuthor(theId);
		
		
		return "redirect:/author/list";
		
	}
}
