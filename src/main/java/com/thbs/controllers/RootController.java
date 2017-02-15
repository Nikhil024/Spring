package com.thbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.data.ExamConstants;

@Controller
public class RootController {
	
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String VIEW_NAME = "home";
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model) {
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.HOME_PAGE_BACKGROUND_IMAGE);
		return VIEW_NAME;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postHome(Model model) {
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.HOME_PAGE_BACKGROUND_IMAGE);
		return VIEW_NAME;
	}
	
}
