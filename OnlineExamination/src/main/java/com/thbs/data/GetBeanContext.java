package com.thbs.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.thbs.Beans.UserDetailsBean;
import com.thbs.Dao.EmailLinkEncryptionDao;
import com.thbs.Dao.ImagesDao;
import com.thbs.Dao.UserDetailsDao;
import com.thbs.Dao.UsersDao;

public class GetBeanContext {
	String strClassPath = System.getProperty("catalina.base");
	ApplicationContext context = new FileSystemXmlApplicationContext(strClassPath+"\\wtpwebapps\\OnlineExamination\\resources\\xml\\Beans.xml");
	
	public UsersDao getUserBeanContext(){
		UsersDao userDao = (UsersDao)context.getBean("userDao"); 
		return userDao;
		
	}
	
	public EmailLinkEncryptionDao getEmailEncryptionBeanContext(){
		EmailLinkEncryptionDao emailLinkencryptionDao = (EmailLinkEncryptionDao)context.getBean("emailLinkencryptionDao");
		return emailLinkencryptionDao;
	}
	
	public ImagesDao getImagesBeanContext(){
		ImagesDao imagesDao = (ImagesDao)context.getBean("imagesDao");
		return imagesDao;
	}
	
	
	public UserDetailsDao getuserDetailsBeanContext(){
		UserDetailsDao userdetailsDao = (UserDetailsDao)context.getBean("userdetailsDao");
		return userdetailsDao;
	}
	
	
}
