package org.my.developer.mywebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-org")
public class MyOrgWebController {

	@GetMapping
	public String getMapping() {
		return "I fight for the users!";
	}
}
