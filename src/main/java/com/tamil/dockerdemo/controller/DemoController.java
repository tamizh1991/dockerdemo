package com.tamil.dockerdemo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(value = "/demo")
	public String getMethodName() {
		String hostname=null;
		try {
			hostname=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "application is running in port : "+hostname;
	}

}
