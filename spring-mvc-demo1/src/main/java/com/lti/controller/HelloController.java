package com.lti.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("message") //to put data  session 
public class HelloController {
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String hello(Map <String,Object>model) {
		model.put("message", "Welcome to Spring MVC");
		return "/hello.jsp";

	}
}
