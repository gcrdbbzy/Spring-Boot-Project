package com.bobAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StringAdd {
	
	@RequestMapping("/addString")
	public String addString(String a, String b) 
	{
	
		return a + b;
	}

}
