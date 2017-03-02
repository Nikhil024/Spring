package com.thbs.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
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
	private final String UPLOAD_INCLUDE_PAGE = "upload_include_page";
	private final String UPLOAD_INCLUDE_PAGE_NAME = "profile";
	private final String USER_PROFILE_PICTURE = "userprofileimage";
	private final String VIEW_NAME = "uploadForm";
	private final String NO_PICTURE = "nopicture";
	private final String PICTURE = "picture";
	private final String USER_NAME = "username";
	private final String MESSAGE_MODEL_ATTRIBUTE = "data";
	private final String FAIL_MODEL_ATTRIBUTE = "fail";
	private final String NO_LOGIN_VIEW_NAME = "login";
	GetBeanContext gc = new GetBeanContext();
	UsersDao usersdao = gc.getUserBeanContext();
	ImagesDao imagesdao = gc.getImagesBeanContext();


	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUploadForm(Model model,HttpSession session){
		model.addAttribute(UPLOAD_INCLUDE_PAGE,UPLOAD_INCLUDE_PAGE_NAME);
		
		
		if(session.getAttribute(SESSSION_EMAIL_NAME)==null){
			model.addAttribute(MESSAGE_MODEL_ATTRIBUTE,ExamConstants.NO_LOGIN_MESSAGE+" To Access The Profile Page.!");
			model.addAttribute(FAIL_MODEL_ATTRIBUTE,ExamConstants.PAGE_DISPLAY_VALUE);
			return NO_LOGIN_VIEW_NAME;
		}
		
		log.info("Session variable in upload : "+session.getAttribute(SESSSION_EMAIL_NAME));

		List<UsersBean> usr = usersdao.getUserDetails(session.getAttribute(SESSSION_EMAIL_NAME).toString());


		for(UsersBean u : usr){
			users.setId(u.getId());
			users.setEmail(u.getEmail());
			users.setName(u.getName());
			users.setLastLogin(u.getLastLogin());
			
			List<ImagesBean> img = imagesdao.getAllImage(u.getId());
			for(ImagesBean i :img){
				images.setId(i.getId());
				images.setName(i.getName());
				images.setLocation(i.getLocation());
				images.setUploadDate(i.getUploadDate());
				images.setLastupdateDate(i.getLastupdateDate());
			}
		}
		
		
		model.addAttribute(USER_NAME,users.getName()); 
		if(images.getName() == null){
			model.addAttribute(NO_PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
			model.addAttribute(USER_PROFILE_PICTURE,ExamConstants.FIRST_TIME_PROFILE_AND_NO_PROFILE_PICTURE); 
			return VIEW_NAME;
		}
		else{
			model.addAttribute(PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
			model.addAttribute(USER_PROFILE_PICTURE,images.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
			return VIEW_NAME;
		}
	}
	
	
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String handleFormUpload(Model model, 
			@RequestParam("file") MultipartFile file,HttpSession session,HttpServletRequest request) throws IOException{




		if(session.getAttribute(SESSSION_EMAIL_NAME)!=null){
			model.addAttribute(USER_NAME,users.getName()); 
			List<ImagesBean> imgb = imagesdao.getAllImage(users.getId());

			log.info("catalinahomelocation: "+ExamConstants.CATILANA_HOME_LOCATION);
			if (SystemUtils.IS_OS_WINDOWS) {
			image_in_file_system = new File(ExamConstants.WINDOWS_PROFILE_IMAGE_STORED_LCOATION);
			}
			if (SystemUtils.IS_OS_LINUX) {
				image_in_file_system = new File(ExamConstants.LINUX_PROFILE_IMAGE_STORED_LCOATION);
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
					images.setLocation(image_in_file_system.getAbsolutePath());
					images.setUploadDate(CurrentDate.getCurrentDate());
					images.setProfilepicture(ExamConstants.AFTER_VERIFICATION_VALUE);
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
						ImageIO.write(src, "png", destination);
						//Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
						if(images.getName() == null){
							model.addAttribute(NO_PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
							model.addAttribute(USER_PROFILE_PICTURE,ExamConstants.FIRST_TIME_PROFILE_AND_NO_PROFILE_PICTURE);
							log.info("NNNN : "+ request.getLocalName());
							return "redirect:/profile/";
						}
						else{
							model.addAttribute(PICTURE,ExamConstants.AFTER_VERIFICATION_VALUE);
							model.addAttribute(USER_PROFILE_PICTURE,images.getName()+ExamConstants.JPEG_IMAGE_EXTENSION);
							String url = request.getRequestURL().toString();
							/*url = url.replace("savefile", "profile");
							log.info("URL:: "+url);*/
							    return "redirect:profile";
						}
					}
					catch(FileNotFoundException fe){
						log.info("FileNotFoundException : "+fe);
						log.info("FileNotFoundException : in location : "+image_in_file_system);
						model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
						return "profile";
					}
					
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
