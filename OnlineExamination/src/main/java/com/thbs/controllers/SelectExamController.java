package com.thbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelectExamController {
	private final String VIEW_NAME = "selectexam"; 

	@RequestMapping(value = "/selectexam",method = RequestMethod.GET)
	public String getExam(){
		return VIEW_NAME;
	}
	
	
	@RequestMapping(value = "/selectexam",method = RequestMethod.POST)
	public String postExam(){
		return VIEW_NAME;
	}
	
}
