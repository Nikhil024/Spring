package com.thbs.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thbs.Beans.ImagesBean;
import com.thbs.Beans.UserDetailsBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.ImagesDao;
import com.thbs.Dao.UserDetailsDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;

@Controller
public class ProfileController {

	private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	UsersBean user;

	@Autowired
	ImagesBean images;
	
	@Autowired
	UserDetailsBean userdetails;

	String pagename;
	private final String VIEW_NAME = "profile";
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String SESSION_AND_MODEL_EMAIL_VARIABLE = "email";
	private final String USER_NAME = "username";
	private final String MESSAGE_MODEL_ATTRIBUTE = "data";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String NO_LOGIN_VIEW_NAME = "login";
	private final String USER_PROFILE_PICTURE = "userprofileimage";
	private final String NO_PICTURE = "nopicture";
	private final String PICTURE = "picture";
	private final String COMPANY_NAME = "company";
	private final String EMAIL = "email";
	private final String FIRST_NAME = "fname";
	private final String LAST_NAME = "lname";
	private final String ADDRESS = "address";
	private final String CITY = "city";
	private final String COUNTRY = "country";
	private final String POSTAL_CODE = "postalcode";
	private final String ABOUT_ME = "aboutme";
	private final String CURRENT_PAGE_SESSION_NAME = "currentpage";
	private final String LOCK_SCREEN_VIEW_NAME = "lockscreen";
	
	
	
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userdao = gbc.getUserBeanContext();
	ImagesDao imagesdao = gbc.getImagesBeanContext();
	UserDetailsDao userdetailsdao = gbc.getuserDetailsBeanContext();




	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getPorfile(Model model,HttpSession session){
		
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);

		if(session.getAttribute(SESSION_AND_MODEL_EMAIL_VARIABLE)==null){
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_LOGIN_MESSAGE+" To Access The Profile Page.!");
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
					images.setPiechart(i.getPiechart());
					images.setProfilepicture(i.getProfilepicture());
					images.setLastupdateDate(i.getLastupdateDate());
				}
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
			
			model.addAttribute(USER_NAME,user.getName()); 
			model.addAttribute(COMPANY_NAME,ExamConstants.COMPANY_NAME);
			model.addAttribute(EMAIL,user.getEmail());
			
			
			List<UserDetailsBean> ud = userdetailsdao.getAllUserDetails(user.getId());
			
			if(!ud.isEmpty()){
				for(UserDetailsBean userdetls : ud){
					model.addAttribute(FIRST_NAME,userdetls.getName());
					log.info("Name from DB : "+userdetls.getName());
					model.addAttribute(LAST_NAME,userdetls.getLname());
					model.addAttribute(ADDRESS,userdetls.getAddress());
					model.addAttribute(CITY,userdetls.getCity());
					model.addAttribute(COUNTRY,userdetls.getCountry());
					model.addAttribute(POSTAL_CODE,userdetls.getPostalcode());
					model.addAttribute(ABOUT_ME,userdetls.getAboutme());
				}
			}
			
			if(images.getProfilepicture() == null){
				model.addAttribute(NO_PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
				model.addAttribute(USER_PROFILE_PICTURE,ExamConstants.FIRST_TIME_PROFILE_AND_NO_PROFILE_PICTURE); 
			}
			else{
				model.addAttribute(PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
				model.addAttribute(USER_PROFILE_PICTURE,images.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
			}
			

		}


		return VIEW_NAME;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String postProfile(Model model,HttpSession session,@RequestParam("fname") String firstName ,@RequestParam("lname") String lastName ,@RequestParam("address") String address ,@RequestParam("city") String city ,@RequestParam("country") String country,@RequestParam("postalcode") String postalCode ,@RequestParam("aboutme") String aboutMe){
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		if(session.getAttribute(SESSION_AND_MODEL_EMAIL_VARIABLE)==null){
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_LOGIN_MESSAGE+" To Access The Profile Page.!");
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			return NO_LOGIN_VIEW_NAME;
		}
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
		
		model.addAttribute(USER_NAME,user.getName()); 
		
		List<UserDetailsBean> userdetailsBean = userdetailsdao.getAllUserDetails(user.getId());
		
		
		userdetails.setId(user.getId());
		userdetails.setName(firstName);
		userdetails.setLname(lastName);
		userdetails.setEmail(user.getEmail());
		userdetails.setCompanyname(ExamConstants.COMPANY_NAME);
		userdetails.setAddress(address);
		userdetails.setCity(city);
		userdetails.setCountry(country);
		userdetails.setPostalcode(postalCode);
		userdetails.setAboutme(aboutMe);
		
		if(userdetailsBean.isEmpty()){
		int count = userdetailsdao.insertUserDetails(userdetails);
		log.info("Count for insert "+count);
		return "redirect:"+VIEW_NAME;
		}
		else{
			ExamConstants.UPDATE_USER_DETAILS = ExamConstants.UPDATE_USER_DETAILS.replace("coulumnname_withvalue", "FNAME='"+firstName+"',LNAME='"+lastName+"',EMAIL='"+userdetails.getEmail()+"',ADDRESS='"+address+"',CITY='"+city+"',COUNTRY='"+country+"',POSTALCODE='"+postalCode+"',ABOUTME='"+aboutMe+"'");
			log.info("UpdateUserDetails Query: "+ExamConstants.UPDATE_USER_DETAILS);
			int count = userdetailsdao.UpdateUserDetails(ExamConstants.UPDATE_USER_DETAILS, user.getId());
			log.info("Count for update "+count);
			return "redirect:"+VIEW_NAME;
		}
		
	}

}
