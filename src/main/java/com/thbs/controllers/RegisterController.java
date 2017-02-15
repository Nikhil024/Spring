package com.thbs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thbs.Beans.EmailLinkEncryptionBean;
import com.thbs.Beans.SendEmailBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.EmailLinkEncryptionDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.CurrentDate;
import com.thbs.data.Email;
import com.thbs.data.EmailTemplate;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;
import com.thbs.data.MD5;
import com.thbs.data.PasswordPattern;

@Controller
public class RegisterController {

	@Autowired
	protected UsersBean users;

	@Autowired
	protected EmailLinkEncryptionBean emaillinkencryption;

	@Autowired
	protected SendEmailBean sendemail;
	
	
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
	GetBeanContext gbc = new GetBeanContext();
	UsersDao userDao = gbc.getUserBeanContext();
	EmailLinkEncryptionDao emailLinkencryptionDao = gbc.getEmailEncryptionBeanContext(); 
	private final String ERROR_MESSAGE_MODEL_ATTRIBUTE = "errormessage";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String SUCCESS_MESSAGE_MODEL_ATTRIBUTE = "message";
	private final String SUCCESS_MODEL_ATTRIBUTE = "success";
	private final String BACKGROUND_IMAGE_NAME = "bgimagename";
	private final String COMPANY_NAME = "companyname";
	private final String PROJECT_NAME = "projectname";
	private final String PROJECT_DECSCRIPTION = "projectdescription";
	private final String SIDE_BAR = "sidebar";
	private final String SIDE_BAR_CONTENT = "content";
	private final String VIEW_NAME = "register";
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		model.addAttribute(COMPANY_NAME,ExamConstants.COMPANY_NAME);
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(PROJECT_DECSCRIPTION,ExamConstants.PROJECT_DESCRIPTION);
		model.addAttribute(SIDE_BAR+1,ExamConstants.SIDEBAR1);
		model.addAttribute(SIDE_BAR+1+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR1_CONTENT);
		model.addAttribute(SIDE_BAR+2,ExamConstants.SIDEBAR2);
		model.addAttribute(SIDE_BAR+2+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR2_CONTENT);
		model.addAttribute(SIDE_BAR+3,ExamConstants.SIDEBAR3);
		model.addAttribute(SIDE_BAR+3+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR3_CONTENT);
		return VIEW_NAME;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegsiter(@RequestParam("name")String username,@RequestParam("email")String email,@RequestParam("pass")String password,@RequestParam("cpass")String cpassword,Model model) {
		model.addAttribute(BACKGROUND_IMAGE_NAME,ExamConstants.BACKGROUND_IMAGE);
		model.addAttribute(COMPANY_NAME,ExamConstants.COMPANY_NAME);
		model.addAttribute(PROJECT_NAME,ExamConstants.PROJECT_NAME);
		model.addAttribute(PROJECT_DECSCRIPTION,ExamConstants.PROJECT_DESCRIPTION);
		model.addAttribute(SIDE_BAR+1,ExamConstants.SIDEBAR1);
		model.addAttribute(SIDE_BAR+1+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR1_CONTENT);
		model.addAttribute(SIDE_BAR+2,ExamConstants.SIDEBAR2);
		model.addAttribute(SIDE_BAR+2+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR2_CONTENT);
		model.addAttribute(SIDE_BAR+3,ExamConstants.SIDEBAR3);
		model.addAttribute(SIDE_BAR+3+SIDE_BAR_CONTENT,ExamConstants.SIDEBAR3_CONTENT);

		if((username.equals("")||username==null)&&(username.equals("")||username==null)&&(password.equals("")||password==null)&&(cpassword.equals("")||cpassword==null)&&(email.equals("")||email==null)){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" all the details.");
			return VIEW_NAME;
		}




		if(username.equals("")||username==null){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" name.");

			if(!(email.equals("")||email==null)){
				model.addAttribute("email",email);
			}
			return VIEW_NAME;
		}


		if(email.equals("")||email==null){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" email.");
			if(!(username.equals("")||username==null)){
				model.addAttribute("name",username);
			}

			return VIEW_NAME;
		}

		if(password.equals("")||password==null){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" password.");

			if(!(email.equals("")||email==null)){
				model.addAttribute("email",email);
			}

			if(!(username.equals("")||username==null)){
				model.addAttribute("name",username);
			}

			return VIEW_NAME;
		}

		if(cpassword.equals("")||cpassword==null){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" confirm password.");

			if(!(email.equals("")||email==null)){
				model.addAttribute("email",email);
			}

			if(!(username.equals("")||username==null)){
				model.addAttribute("name",username);
			}

			return VIEW_NAME;
		}

		if(!cpassword.equals(password)){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_DATA+" same password.");
			if(!(email.equals("")||email==null)){
				model.addAttribute("email",email);
			}

			if(!(username.equals("")||username==null)){
				model.addAttribute("name",username);
			}
			return VIEW_NAME;
		}

		if(!PasswordPattern.match(password)){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			log.info("value: "+PasswordPattern.match(password));
			log.info("pass: "+password);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.PASSWORD_MATCH_FAIL);
			if(!(email.equals("")||email==null)){
				model.addAttribute("email",email);
			}

			if(!(username.equals("")||username==null)){
				model.addAttribute("name",username);
			}
			return VIEW_NAME;
		}

		List<UsersBean> u = userDao.getUserDetails(email);

		if(!u.isEmpty()){
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			model.addAttribute(ERROR_MESSAGE_MODEL_ATTRIBUTE,ExamConstants.USER_ALREADY_EXISTS);
			return VIEW_NAME;
		}


		model.addAttribute(SUCCESS_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
		model.addAttribute(SUCCESS_MESSAGE_MODEL_ATTRIBUTE,"Registration Successful.!! <br/>Please wait for a comformation mail.");
		password = MD5.encryption(password);
		log.info("password after MD5 encryption: "+password);

		String[] usertype = ExamConstants.USERTYPE.split(",");
		log.info("usertype later: "+usertype);

		users.setName(username);
		users.setEmail(email);
		users.setPassword(password);
		users.setEmailVerified(ExamConstants.INITIAL_VERIFICATION_VALUE);
		users.setUserType(usertype[0]);
		users.setAdminAccepted(ExamConstants.INITIAL_VERIFICATION_VALUE);
		users.setLastLogin(CurrentDate.getCurrentDate());



		userDao.insertData(users);

		List<UsersBean> usr = userDao.getUserDetails(email);
		if(usr.isEmpty()){
			log.info("No data in userDao.getUserDetails ");
		}
		
		for(UsersBean us:usr){
		emaillinkencryption.setId(us.getId());
		log.info("found data in db with useid as : "+us.getId());
		}
		emaillinkencryption.setEmail(MD5.encryption(email));
		log.info("found data in db with email as : "+email);
		emaillinkencryption.setName(MD5.encryption(username));
		log.info("found data in db with username as : "+username);
		


		emailLinkencryptionDao.insertEmailLinkEncryption(emaillinkencryption);



		String verification_link = ExamConstants.ONLINE_EXAMINATION_PORTAL_WEBSITE + "emailverification.html/oed/" +MD5.encryption(String.valueOf(emaillinkencryption.getId()))+ "/oem/" +emaillinkencryption.getEmail()+ "/oeu/"+emaillinkencryption.getName();
		log.info("The verification link is "+verification_link);
		log.info("sending mail: ");
		
		if(users.getEmail()!=null||users.getName()!=null||verification_link!=null){
		sendemail.setFrom(ExamConstants.EMAIL_USERNAME);
		sendemail.setPassword(ExamConstants.EMAIL_PASSWORD);
		sendemail.setPortnumber(ExamConstants.EMAIL_SMTP_PORT);
		sendemail.setSmtpauth(ExamConstants.EMAIL_SMTP_AUTH);
		sendemail.setSmtphost(ExamConstants.EMAIL_SMTP_HOST);
		sendemail.setSocketfactoryclass(ExamConstants.EMAIL_SOCKET_FACTORY_CLASS);
		sendemail.setSubject(ExamConstants.EMAIL_VERIFICATION_SUBJECT);
		sendemail.setContent(EmailTemplate.verification(users.getName(), verification_link));
		sendemail.setName(users.getName());
		sendemail.setTo(users.getEmail());
		sendemail.setLink(verification_link);
		
		Email.sendemailverf(sendemail);
		}
		
		log.info("mail sent : ");
		log.info("name: "+username);
		log.info("email: "+email);
		log.info("pass: "+password);
		log.info("cpass: "+cpassword);

		return VIEW_NAME;
	}


}
