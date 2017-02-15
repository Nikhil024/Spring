package com.thbs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.Beans.EmailLinkEncryptionBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.EmailLinkEncryptionDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;
import com.thbs.data.MD5;

@Controller
public class EmailVerificationController {

	@Autowired
	UsersBean user;
	
	@Autowired
	EmailLinkEncryptionBean emaillinkencryption;
	
	
	private static final Logger log = LoggerFactory.getLogger(EmailVerificationController.class);
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userDao = gbc.getUserBeanContext();
	EmailLinkEncryptionDao emailLinkencryptionDao = gbc.getEmailEncryptionBeanContext(); 
	private final String NAME_REPLACE = "nameid";
	private final String EMAIL_REPLACE = "emailid";
	private final String VIEW_NAME = "emailVerification";
	
	@RequestMapping(value="/emailverification.html/oed/{id}/oem/{email}/oeu/{username}")
	public String Emailverification(@PathVariable("id") String id,@PathVariable("email") String email,@PathVariable("username") String name,final Model model){
	
	log.info("id: "+id);
	log.info("email: "+email);
	log.info("name: "+name);
	model.addAttribute("name",name);
	
	List<EmailLinkEncryptionBean> ele = emailLinkencryptionDao.getEmailLinkEncryption(email);
	
	for(EmailLinkEncryptionBean el : ele){
		emaillinkencryption.setEmail(el.getEmail());
		emaillinkencryption.setId(el.getId());
		emaillinkencryption.setName(el.getName());
		emaillinkencryption.setLastUpdate(el.getLastUpdate());
	}
	
	log.info("emaillinkencryption.getId(): "+emaillinkencryption.getId());
	List<UsersBean> usr = userDao.getUserDetails(emaillinkencryption.getId());
	log.info("usr.isEmpty(): "+usr.isEmpty());
	log.info("ele.isEmpty(): "+ele.isEmpty());
	
	if(ele.isEmpty()||usr.isEmpty()){
		model.addAttribute(ExamConstants.MODEL_ATTRIBUTE,ExamConstants.NO_DATA_FOR_EMAIL_VERIFICATION);
		return VIEW_NAME;
	}
	
	for(UsersBean u : usr){
		user.setId(u.getId());
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setEmailVerified(u.getEmailVerified());
	}
	
	if(user.getEmailVerified().equals(ExamConstants.AFTER_VERIFICATION_VALUE)){
		ExamConstants.EMAIL_VERIFICATION_ALREADY_DONE = ExamConstants.EMAIL_VERIFICATION_ALREADY_DONE.replace(NAME_REPLACE, user.getName());
		ExamConstants.EMAIL_VERIFICATION_ALREADY_DONE = ExamConstants.EMAIL_VERIFICATION_ALREADY_DONE.replace(EMAIL_REPLACE, user.getEmail());
		model.addAttribute(ExamConstants.MODEL_ATTRIBUTE, ExamConstants.EMAIL_VERIFICATION_ALREADY_DONE);
		return VIEW_NAME;
	}
	
	if(id.equals(MD5.encryption(String.valueOf(emaillinkencryption.getId())))){
		log.info("in the 1st if");
		if(name.equals(emaillinkencryption.getName())){
			userDao.updateUserColumn(ExamConstants.UPDATE_USER_EMAIL_VERIFIED, user.getId());
			log.info("in the 2nd if");
			ExamConstants.EMAIL_VERIFICATION_SUCCESS = ExamConstants.EMAIL_VERIFICATION_SUCCESS.replace(NAME_REPLACE, user.getName());
			ExamConstants.EMAIL_VERIFICATION_SUCCESS = ExamConstants.EMAIL_VERIFICATION_SUCCESS.replace(EMAIL_REPLACE, user.getEmail());
			model.addAttribute(ExamConstants.MODEL_ATTRIBUTE, ExamConstants.EMAIL_VERIFICATION_SUCCESS);
		}
	}
	return VIEW_NAME;
	}
	
}
