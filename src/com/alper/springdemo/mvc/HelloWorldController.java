package com.alper.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.*;



@Controller
public class HelloWorldController {
	
	//Controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from html form
		String theName= request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Yo!" + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		
		theName = theName.toUpperCase();
		
		String result = "Hello from v3" + theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
