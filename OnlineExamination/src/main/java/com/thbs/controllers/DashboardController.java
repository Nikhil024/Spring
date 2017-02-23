package com.thbs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.Beans.ImagesBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.ImagesDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;

@Controller
public class DashboardController {
	
	private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	UsersBean user;
	
	@Autowired
	ImagesBean images;
	
	
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userdao = gbc.getUserBeanContext();
	ImagesDao imagesdao = gbc.getImagesBeanContext();
	private final String VIEW_NAME = "dashboard";
	private final String NO_LOGIN_VIEW_NAME = "login";
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String PIE_CHART_LOCATION = "piechartlocation";
	private final String MESSAGE_MODEL_ATTRIBUTE = "data";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String SESSION_AND_MODEL_EMAIL_VARIABLE = "email";
	private final String USER_NAME = "username";
	private final String NO_USER_PROFILE_PICTURE = "userprofileimage";
	private final String LOCK_SCREEN_VIEW_NAME = "lockscreen";
	private final String USER_PROFILE_PICTURE = "userprofileimage";
	private final String NO_PICTURE = "nopicture";
	private final String PICTURE = "picture";
	private final String CURRENT_PAGE_SESSION_NAME = "currentpage";
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
				user.setId(u.getId());
				user.setEmail(u.getEmail());
				user.setName(u.getName());
				user.setLastLogin(u.getLastLogin());
				
				List<ImagesBean> img = imagesdao.getAllImage(u.getId());
				for(ImagesBean i :img){
					images.setId(i.getId());
					images.setName(i.getName());
					images.setLocation(i.getLocation());
					images.setUploadDate(i.getUploadDate());
					images.setLastupdateDate(i.getLastupdateDate());
				}
			}
		 
		 
		 for(UsersBean u : users){
			model.addAttribute(USER_NAME,u.getName()); 
			model.addAttribute(PIE_CHART_LOCATION,u.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
		 }
		 
		 
		 if(session.getAttribute(CURRENT_PAGE_SESSION_NAME)!=null){
				if(session.getAttribute(CURRENT_PAGE_SESSION_NAME).equals(LOCK_SCREEN_VIEW_NAME)){
					model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.SCREEN_LOCKED_MESSAGE);
					model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
					if(images.getName() == null){
						model.addAttribute(NO_PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
						model.addAttribute(USER_PROFILE_PICTURE,ExamConstants.FIRST_TIME_PROFILE_AND_NO_PROFILE_PICTURE); 
						return LOCK_SCREEN_VIEW_NAME;
					}
					else{
						model.addAttribute(PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
						model.addAttribute(USER_PROFILE_PICTURE,images.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
						return LOCK_SCREEN_VIEW_NAME;
					}
				}
				}
			
			session.setAttribute(CURRENT_PAGE_SESSION_NAME, VIEW_NAME);
		 
		 
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
