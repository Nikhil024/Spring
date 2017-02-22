package com.thbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LockScreenController {

	@RequestMapping(value = "/lockscreen", method = RequestMethod.GET)
	public String getLockScreen(){
		return "lockscreen";
	}
	
}
