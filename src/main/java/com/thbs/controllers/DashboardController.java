package com.thbs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.Beans.UsersBean;
import com.thbs.Dao.UsersDao;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;

@Controller
public class DashboardController {

	@Autowired
	UsersBean user;
	
	
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userdao = gbc.getUserBeanContext();
	private final String VIEW_NAME = "dashboard";
	private final String NO_LOGIN_VIEW_NAME = "login";
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String PIE_CHART_LOCATION = "piechartlocation";
	private final String MESSAGE_MODEL_ATTRIBUTE = "data";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String SESSION_AND_MODEL_EMAIL_VARIABLE = "email";
	private final String USER_NAME = "username";
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<Integer> marks = new ArrayList<Integer>();
	
	
	
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String getDashboard(Model model,HttpSession session){
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		
		
		if(session.getAttribute(SESSION_AND_MODEL_EMAIL_VARIABLE)==null){
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_LOGIN_MESSAGE+" To Access The Dashboard Page.!");
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			return NO_LOGIN_VIEW_NAME;
		}
		
		
		if(session.getAttribute(SESSION_AND_MODEL_EMAIL_VARIABLE)!=null){
			
		 List<UsersBean> users = userdao.getUserDetails(session.getAttribute(SESSION_AND_MODEL_EMAIL_VARIABLE).toString());
		 
		 
		 for(UsersBean u : users){
			model.addAttribute(USER_NAME,u.getName()); 
		 }
		 
		 
		 
		 return VIEW_NAME;
		}
		
		return VIEW_NAME;
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String postDashboard(Model model){
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		return VIEW_NAME;
	}
}
