package com.thbs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.data.ExamConstants;

@Controller
public class LogOutController {
	private final String VIEW_NAME = "home";
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";

@RequestMapping(value = "/logout",method = RequestMethod.GET)
public String getLogOut(HttpSession session,Model model){
	model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
	model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.HOME_PAGE_BACKGROUND_IMAGE);
	session.invalidate();
	return VIEW_NAME;
}
	
}
