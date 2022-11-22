package com.tamil.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(value = "/demo")
	public String getMethodName() {
		return "this application is running";
	}

}
