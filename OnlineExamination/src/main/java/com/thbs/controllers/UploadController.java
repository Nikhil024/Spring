package com.thbs.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.thbs.Beans.ImagesBean;
import com.thbs.Beans.UsersBean;
import com.thbs.Dao.ImagesDao;
import com.thbs.Dao.UsersDao;
import com.thbs.data.CurrentDate;
import com.thbs.data.ExamConstants;
import com.thbs.data.GetBeanContext;

@Controller
public class UploadController {
	
	@Autowired
	ImagesBean images;
	
	@Autowired
	UsersBean users;
	
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	File image_in_file_system = null;
	private final String SESSSION_EMAIL_NAME = "email";
	GetBeanContext gc = new GetBeanContext();
	UsersDao usersdao = gc.getUserBeanContext();
	ImagesDao imagesdao = gc.getImagesBeanContext();
	
	
	
	
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String handleFormUpload(Model model, 
	    @RequestParam("file") MultipartFile file,HttpSession session) throws IOException{
		
		
		
		
		if(session.getAttribute(SESSSION_EMAIL_NAME)!=null){
		
			List<UsersBean> usersbean = usersdao.getUserDetails(session.getAttribute(SESSSION_EMAIL_NAME).toString());
			
			for(UsersBean u : usersbean){
				users.setId(u.getId());
				users.setEmail(u.getEmail());
				users.setName(u.getName());
				users.setPassword(u.getPassword());
				users.setUserType(u.getUserType());
				users.setLastLogin(u.getLastLogin());
				
			}
			
			List<ImagesBean> imgb = imagesdao.getAllImage(users.getId());
			
		log.info("catalinahomelocation: "+ExamConstants.CATILANA_HOME_LOCATION);
		
		image_in_file_system = new File(ExamConstants.PROFILE_IMAGE_STORED_LCOATION);
		if (SystemUtils.IS_OS_LINUX) {
			image_in_file_system = new File(ExamConstants.PROFILE_IMAGE_STORED_LCOATION);
			  log.info("OS is Linux based, image Storage Location is set to : "+image_in_file_system);
		    }
		
		if (!image_in_file_system.exists()) {
			image_in_file_system.mkdirs();
        }
		String filename = file.getOriginalFilename();
		log.info("Location of catilana "+image_in_file_system+File.separator+filename);
		if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".gif")){
	if (!file.isEmpty()) {
		images.setId(users.getId());
		images.setName(users.getName());
		images.setLocation(ExamConstants.PROFILE_IMAGE_STORED_LCOATION);
		images.setUploadDate(CurrentDate.getCurrentDate());
		if(imgb.isEmpty()){
		imagesdao.insertImage(images);
		}
		else{
			ExamConstants.UPDATE_IMAGE_QUERY = ExamConstants.UPDATE_IMAGE_QUERY.replace("column_name=value", "IMAGES_LOCATION="+images.getLocation());
			ExamConstants.UPDATE_IMAGE_QUERY = ExamConstants.UPDATE_IMAGE_QUERY.replace("date_value", CurrentDate.getCurrentDate());
			log.info("Update Image Query :"+ExamConstants.UPDATE_IMAGE_QUERY);
			imagesdao.UpdateImageLocation(ExamConstants.UPDATE_IMAGE_QUERY, users.getId());
		}
		try{
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 
	 File destination = new File(image_in_file_system+File.separator+users.getName()+ExamConstants.JPEG_IMAGE_EXTENSION); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 log.info("Actual location of file : "+image_in_file_system+File.separator+users.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
	 ImageIO.write(src, ExamConstants.JPEG_IMAGE_EXTENSION, destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	 }
		catch(FileNotFoundException fe){
			log.info("FileNotFoundException : "+fe);
			log.info("FileNotFoundException : in location : "+image_in_file_system);
			model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
			return "profile";
		}
		model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
		return "profile"; 
		}
}
		model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
		return "profile";
}
		else{
			return "profile";
		}
	}	
	
}
