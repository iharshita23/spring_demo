package com.greeterapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrretController {
	
	//http://localhost:8080/show
	@RequestMapping("/greet")
	public String greet() {
		return "Great Day";
	}
	
	//http://localhost:8080/show
	@RequestMapping("/show")
	public List<String> showCourses() {
		return Arrays.asList("Java","Spring","Mongo");
	}
	
	//http://localhost:8080/greet-user/Harshi
	@GetMapping("/greet-user/{uname}")
	public String sayHello(@PathVariable("uname")String username) {
		return "Welcome " + username;
	}
	
	//http://localhost:8080/show-movies?lang=Malayalam
	@GetMapping("/show-movies")
	public List<String> selectMovie(@RequestParam("lang")String language) {
	  if(language.equals("English"))
		  return List.of("","Tangled");
	  if(language.equals("Tamil"))
		  return List.of("Vikram","24");
	  if(language.equals("Malayalam"))
		  return List.of("Premam","Parava");
	  return null;
	}
	
}
