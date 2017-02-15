package com.thbs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {
	private final String VIEW_NAME = "home";

@RequestMapping(value = "/logout",method = RequestMethod.GET)
public String getLogOut(HttpSession session){
	session.invalidate();
	return VIEW_NAME;
}
	
}
