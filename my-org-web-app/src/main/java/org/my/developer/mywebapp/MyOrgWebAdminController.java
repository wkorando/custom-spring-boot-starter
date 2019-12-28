package org.my.developer.mywebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class MyOrgWebAdminController {

	@GetMapping
	public String getMapping() {
		return "Assuming direct control!";
	}

}
