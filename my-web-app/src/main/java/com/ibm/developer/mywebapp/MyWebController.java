package com.ibm.developer.mywebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebController {

	@GetMapping
	public String getMapping() {
		return "Hello world";
	}
	
	@PostMapping
	public String postMapping(String name) {
		return "Hello " + name ;
	}
}
