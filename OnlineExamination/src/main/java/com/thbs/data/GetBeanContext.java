package com.thbs.data;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.thbs.Beans.UserDetailsBean;
import com.thbs.Dao.EmailLinkEncryptionDao;
import com.thbs.Dao.ImagesDao;
import com.thbs.Dao.SubjectsDao;
import com.thbs.Dao.UserDetailsDao;
import com.thbs.Dao.UsersDao;

public class GetBeanContext {

	String strClassPath = System.getProperty("catalina.base");
	ApplicationContext context = null;

	public ApplicationContext getcontext(){

		if (SystemUtils.IS_OS_LINUX) {
			context = new FileSystemXmlApplicationContext("/"+strClassPath+"/wtpwebapps/OnlineExamination/resources/xml/Beans.xml");
			return context;
		}
		if(SystemUtils.IS_OS_WINDOWS){
			context = new FileSystemXmlApplicationContext(strClassPath+"\\wtpwebapps\\OnlineExamination\\resources\\xml\\Beans.xml");
			return context;
		}
		return context;
	}

	public UsersDao getUserBeanContext(){
		UsersDao userDao = (UsersDao)getcontext().getBean("userDao"); 
		return userDao;

	}

	public EmailLinkEncryptionDao getEmailEncryptionBeanContext(){
		EmailLinkEncryptionDao emailLinkencryptionDao = (EmailLinkEncryptionDao)getcontext().getBean("emailLinkencryptionDao");
		return emailLinkencryptionDao;
	}

	public ImagesDao getImagesBeanContext(){
		ImagesDao imagesDao = (ImagesDao)getcontext().getBean("imagesDao");
		return imagesDao;
	}


	public UserDetailsDao getuserDetailsBeanContext(){
		UserDetailsDao userdetailsDao = (UserDetailsDao)getcontext().getBean("userdetailsDao");
		return userdetailsDao;
	}


	public SubjectsDao getSubjectsBeanContext(){
		SubjectsDao subjectDao = (SubjectsDao)getcontext().getBean("subjectsDao");
		return subjectDao;
	}
	
	
}
