package com.thbs.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thbs.Beans.UserDetailsBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.EmailLinkEncryptionDao;
import com.thbs.Dao.UserDetailsDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;
import com.thbs.data.MD5;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userdao = gbc.getUserBeanContext();
	UserDetailsDao userdetailsdao = gbc.getuserDetailsBeanContext();
	private final String PROJECT_NAME = "projectname";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String MESSAGE_MODEL_ATTRIBUTE = "data";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String SUCCESS_MODEL_ATTRIBUTE = "success";
	private final String EMAIL_VALUE = "email_value";
	private final String REDIRECT = "redirect";
	private final String REDIRECT_VALUE = "redirectValue";
	private final String VIEW_NAME = "login";
	private final String SUCCESS_VIEW_NAME = "profile";
	private final String DASHBOARD_SUCCESS_VIEW_NAME = "dashboard";
	private final String REGISTER_COMPONENT_VIEW = "registerComponentView";
	private final String SESSSION_EMAIL_NAME = "email";
	private final String CURRENT_PAGE_SESSION_NAME = "currentpage";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model,HttpSession session) {
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		return VIEW_NAME;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam(value = "subscribe",required = false) String subscribe,Model model,HttpSession session) {
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		log.info("email: "+email);
		log.info("password: "+password);
		log.info("subscribe: "+subscribe);

		if((password.equals("")||password == null) && (email.equals("")||email == null)){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" the data");
			return VIEW_NAME;
		}


		if(password.equals("")||password == null){
			model.addAttribute("email_value",email);
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" password");
			return VIEW_NAME;
		}

		if(email.equals("")||email == null){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" email");
			return VIEW_NAME;
		}





		List<UsersBean> users = userdao.getUserDetails(email);

		if(users.isEmpty()){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_USER_EXIST);
			model.addAttribute(REGISTER_COMPONENT_VIEW,ExamConstants.PAGE_DISPLAY_VALUE);
			return VIEW_NAME;
		}
		String[] usertype = ExamConstants.USERTYPE.split(",");
		for(UsersBean u : users){
			if(u.getUserType().equals(usertype[0])){
				if(u.getEmailVerified().equals(ExamConstants.AFTER_VERIFICATION_VALUE)){
					if(u.getEmail().equals(email)){
						if(u.getPassword().equals(MD5.encryption(password))){
							if(u.getSubscribed()!=null){
								if(subscribe!=null){
									userdao.updateUserColumn(ExamConstants.UPDATE_USER_SUBSCRIBED, u.getId());
								}
							}
							List<UserDetailsBean> ud = userdetailsdao.getAllUserDetails(u.getId());
							if(ud.isEmpty()){
							model.addAttribute(SUCCESS_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
							model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,"Hi "+u.getName()+", "+ExamConstants.STUDENT_LOGIN_SUCCESSFULL);
							session.setAttribute(SESSSION_EMAIL_NAME, u.getEmail());
							log.info("Session variable in login : "+session.getAttribute(SESSSION_EMAIL_NAME));
							model.addAttribute(REDIRECT,ExamConstants.REDIRECT_VALUE);
							model.addAttribute(EMAIL_VALUE,email);
							model.addAttribute(REDIRECT_VALUE,SUCCESS_VIEW_NAME);
							session.setAttribute(CURRENT_PAGE_SESSION_NAME,VIEW_NAME);
							return VIEW_NAME;
							}
							else{
								model.addAttribute(SUCCESS_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
								model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,"Hi "+u.getName()+", "+ExamConstants.STUDENT_LOGIN_SUCCESSFULL);
								session.setAttribute(SESSSION_EMAIL_NAME, u.getEmail());
								log.info("Session variable in login : "+session.getAttribute(SESSSION_EMAIL_NAME));
								model.addAttribute(REDIRECT,ExamConstants.REDIRECT_VALUE);
								model.addAttribute(EMAIL_VALUE,email);
								model.addAttribute(REDIRECT_VALUE,DASHBOARD_SUCCESS_VIEW_NAME);
								session.setAttribute(CURRENT_PAGE_SESSION_NAME,DASHBOARD_SUCCESS_VIEW_NAME);
								return VIEW_NAME;
							}

						}
						else{
							model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
							model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.LOGIN_PASSWORD_FAIL);
							model.addAttribute(EMAIL_VALUE, u.getEmail());
							return VIEW_NAME;
						}
					}
					else{
						model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
						model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_USER_EXIST);
						return VIEW_NAME;
					}
				}
			}
			else{
				model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
				model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_USER_EXIST);
				return VIEW_NAME;
			}
		}

		return VIEW_NAME;
	}





}
