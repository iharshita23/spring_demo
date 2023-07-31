package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	Logger logger = LoggerFactory.getLogger(GreetController.class);
	@GetMapping("/greet")
	public String greet() {
		return "welcome spring";
	}
	@RequestMapping("/show") 
    public String show() {
        logger.info("This is info");
        logger.warn("This is warn");
        logger.trace("This is trace");
        logger.debug("This is debug");
        logger.error("This is error");
        return "hello";
    }
	@RequestMapping("/userDetails/{name}/{city}") // data is attached to the url
    public String userDetails(@PathVariable("name") String username, @PathVariable("city") String city) {
        logger.debug("debugging userdetails");
       logger.info("inside userdetails");
        if(city.equals("ban")) {
           logger.debug("checking city");
            logger.warn("invalid input");
            return "Hello " + username+ "City is invalid";
        }

        if(username.equals("Priya")) {
            logger.debug("checking name");
            logger.info("correct username "+username);
            return "welcome " + username + " from " + city;
        }else {
            logger.debug("username is wrong - debug");
            logger.error("wrong user");
          return "wrong user";
        }
}
}
