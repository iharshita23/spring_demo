package com.example.controllers;

	import java.util.List;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/greet-api/v1")
	public class GreetController {
		
		Logger logger = LoggerFactory.getLogger(GreetController.class);
		public String greet() {
			return "welcome spring";
		}
		
		@GetMapping("/admin/books")
		public String addBook() {
			return "Book added";
		}
		
		@GetMapping("admin/books/one")
		public String getOne() {
			return "one book added";
		}
		
		@GetMapping("/user/show-books")
		public List<String> showBooks(){
			return List.of("Java in Action","5am club");
		}
		 
	}

