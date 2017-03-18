package com.jntu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This controller is used for the sample page hello.jsp
// It is used for testing purposes (sending data to controller and passing data to AJAX client)

@Controller
public class HomeController {

	@RequestMapping(value = "/hello")
	public String helloController() {
		return "hello";
	}

}
