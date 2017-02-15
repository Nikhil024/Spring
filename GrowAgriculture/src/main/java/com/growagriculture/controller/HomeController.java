package com.growagriculture.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.HandlerMapping;

import com.growagro.Bean.ImagesBean;
import com.growagro.Bean.UserBean;
import com.growagro.Bean.UserDetailsBean;
import com.growagro.Dao.ImagesDao;
import com.growagro.Dao.UserDao;
import com.growagro.Dao.UserDetailsDao;
import com.growagro.Data.CurrentDate;
import com.growagro.Data.MD5;
import com.growagro.Data.PropertiesfileReading;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	UserDao UserDaoObj =  (UserDao)context.getBean("userDao");
	UserDetailsDao UserDetailsDaoObj = (UserDetailsDao)context.getBean("userDetailsDao");
	ImagesDao ImagesDao = (ImagesDao)context.getBean("imagesDao");
	UserBean users = new UserBean();
	
	
	private File imagestorelocation ; 
	private static String windowsimagestorelocation = PropertiesfileReading.getProperty("imagelocation");
	private String uniximagesStoreLoacation = PropertiesfileReading.getProperty("unixstoreloacation");
	private static String catalinahomelocation =System.getProperty("catalina.home");
	
	
	
	
	@RequestMapping(value="/")
	public String home(){
		log.info("Inside the home method");
		return "home";
	}

	@RequestMapping(value="/farmerlogin",method=RequestMethod.GET)
	public String login(Model model){
		log.info("Inside the farmerlogin GET method");
		model.addAttribute("login","Farmer Login");
		return "login";
	}

	@RequestMapping(value="/farmerlogin",method=RequestMethod.POST)
	public String Login(HttpServletRequest request,HttpSession session,Model model,@RequestParam ("name")String name,@RequestParam ("password")String password){
		String path = "login";


		log.info("path is : "+path);
		log.info("Inside the farmerlogin POST method");
		log.info("name "+name+" password "+password+" from farmerlogin");
		if((name == null || name.equals("")) && (password == null || password.equals(""))){
			log.info("name and password are null");
			model.addAttribute("data_null","Please enter valid details");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Farmer Login");
			return "fail";
		}

		if(name == null || name.equals("") ){
			log.info("name is null");
			model.addAttribute("data_null","Please enter a valid name");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Farmer Login");
			return "fail";
		}

		if(password == null || password.equals("")){
			log.info("password is null");
			model.addAttribute("data_null","Please enter a valid password");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Farmer Login");
			return "fail";
		}
		log.info("password before encryption "+password);
		password = MD5.encryption(password);
		log.info("password after encryption "+password);

		List<UserBean> userBean = UserDaoObj.getUserDetails(name);
		if(userBean.isEmpty()){
			log.info("no user from DB");
			model.addAttribute("data_null","Sorry "+name+" ..! Please Register your details with us and try again.!");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Farmer Login");
			return "fail";
		}


		for(UserBean data: userBean ) {
			log.info("Name from the DB in login : "+data.getName());
			log.info("Password from the DB in login :"+data.getPassword());
			log.info("Usertype from the DB in login :"+data.getUsertype());

			if(data.getName().equals(name) && data.getPassword().equals(password) && data.getUsertype().equals("Farmer")){
				log.info("both name and password and usertype match as per the DB");
				log.info("The id is : "+data.getId());
				session.setAttribute("id", data.getId());
				users.setId(data.getId());
				session.setAttribute("usertype", data.getUsertype());
				model.addAttribute("success","Hi "+name+" Welcome to GrowAgriculture. Please wait while you are being redirected to the Dashboard");
				model.addAttribute("page",path+".jsp");
				model.addAttribute("redirect","dashboard");
				session.setAttribute("username", name);
				model.addAttribute("login","Farmer Login");
				return "success";
			}

			if(data.getName().equals(name) && data.getPassword().equals(password) && !data.getUsertype().equals("Farmer")){
				log.info("name and password match but usertype does not match user entered "+data.getUsertype());
				model.addAttribute("data_null","Sorry "+name+" ..! you are not registred as "+data.getUsertype());
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Farmer Login");
				return "fail";
			}

			if(!(data.getName().equals(name) && data.getPassword().equals(password))){
				log.info("Both the name and password do not match");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login details and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Farmer Login");
				return "fail";
			}


			else if(!(data.getName().equals(name))){
				log.info("name do not match");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login name and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Farmer Login");
				return "fail";
			}
			else if(!(data.getPassword().equals(password))){
				log.info("password do not match");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login password and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Farmer Login");
				return "fail";
			}
		}

		return "dashboard";
	}

	@RequestMapping(value="/buyerlogin",method=RequestMethod.GET)
	public String blogin(Model model){
		log.info("Inside the buyerlogin GET method");
		model.addAttribute("login","Buyer Login");
		return "login";
	}

	@RequestMapping(value="/buyerlogin",method=RequestMethod.POST)
	public String bLogin(@RequestParam("name") String name,@RequestParam("password") String password,HttpSession session,Model model){
		String path = "login";

		log.info("path is : "+path);
		log.info("Inside the buyerlogin POST method");
		log.info("name "+name+" and password "+password+" from buyerlogin POST method");
		if((name == null || name.equals("")) && (password == null || password.equals(""))){
			log.info("both name and password are null in buyerlogin");
			model.addAttribute("data_null","Please enter valid details");
			model.addAttribute("login","Buyer Login");
			model.addAttribute("fail",path+".jsp");
			return "fail";
		}

		if(name == null || name.equals("") ){
			log.info("name is null in buyerlogin");
			model.addAttribute("data_null","Please enter a valid name");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Buyer Login");
			return "fail";
		}

		if(password == null || password.equals("")){
			log.info("password is null in buyerlogin");
			model.addAttribute("data_null","Please enter a valid password");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Buyer Login");
			return "fail";
		}
		log.info("password before encryption "+password);
		password = MD5.encryption(password);
		log.info("password after encryption "+password);
		List<UserBean> userBean = UserDaoObj.getUserDetails(name);
		if(userBean.isEmpty()){
			log.info("no user from DB");
			model.addAttribute("data_null","Sorry "+name+" ..! Please Register your details with us and try again.!");
			model.addAttribute("fail",path+".jsp");
			model.addAttribute("login","Buyer Login");
			return "fail";
		}


		for(UserBean data: userBean ) {
			log.info("Name from the DB in login : "+data.getName());
			log.info("Password from the DB in login :"+data.getPassword());
			log.info("Usertype from the DB in login :"+data.getUsertype());
			if(data.getName().equals(name) && data.getPassword().equals(password) && data.getUsertype().equals("Buyer")){
				log.info("name and password are equal");
				log.info("The id is : "+data.getId());
				session.setAttribute("id", data.getId());
				model.addAttribute("success","Hi "+name+" Welcome to GrowAgriculture. Please wait while you are being redirected to the Dashboard");
				model.addAttribute("page",path+".jsp");
				session.setAttribute("username", name);
				session.setAttribute("usertype", data.getUsertype());
				model.addAttribute("redirect","dashboard");
				model.addAttribute("login","Buyer Login");
				return "success";
			}

			if((data.getName().equals(name) && data.getPassword().equals(password)) && (!(data.getUsertype().equals("Buyer")))){
				log.info("name and password are equal but User_type is "+data.getUsertype());
				model.addAttribute("data_null","Sorry "+name+" ..! You are registered as "+data.getUsertype());
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Buyer Login");
				return "fail";
			}


			if(!(data.getName().equals(name) && data.getPassword().equals(password))){
				log.info("name and password do not match as per DB");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login details and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Buyer Login");
				return "fail";
			}


			else if(!(data.getName().equals(name))){
				log.info("name does not match as per the DB in buyerlogin");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login name and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Buyer Login");
				return "fail";
			}
			else if(!(data.getPassword().equals(password))){
				log.info("password does not match as per the DB in buyerlogin");
				model.addAttribute("data_null","Sorry "+name+" ..! Please check your login password and try again");
				model.addAttribute("fail",path+".jsp");
				model.addAttribute("login","Buyer Login");
				return "fail";
			}
		}

		return path;
	}


	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		log.info("Inside the register GET method");
		return "register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String Register(HttpServletRequest request,HttpSession session,Model model){
		String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
		path = path.replace("/", "");


		log.info("pathis is : "+path);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String details = request.getParameter("list");
		log.info("Select box value is "+details);
		if(details.equals("/controller/resources/img/home.jpg")){
			details = "Farmer";
			log.info("Select box value is "+details);
		}
		else if(details.equals("/controller/resources/img/buyers.jpg")){
			details = "Buyer";
			log.info("Select box value is "+details);
		}
		password = MD5.encryption(password);
		log.info("MD5 encrypted password : "+password);

		if((name == null || name.equals("")) && 
				(password == null || password.equals(""))){
			model.addAttribute("data_null","Please enter valid details");
			model.addAttribute("fail",path+".jsp");
			log.info("Inside the register POST method");
			return "fail";
		}

		if(name == null || name.equals("")){
			model.addAttribute("data_null","Please enter valid name");
			model.addAttribute("fail",path+".jsp");
			log.info("Inside the register POST method");
			return "fail";
		}

		if(password == null || password.equals("")){
			model.addAttribute("data_null","Please enter valid password");
			model.addAttribute("fail",path+".jsp");
			log.info("Inside the register POST method");
			return "fail";
		}
		UserBean user = new UserBean();
		user.setName(name);
		user.setPassword(password);
		user.setUsertype(details);




		log.info("Current Date: " + CurrentDate.getCurrentDate());
		user.setCreateddate(CurrentDate.getCurrentDate());

		int count = UserDaoObj.insertData(user);
		if(count == 1){
			log.info("User : "+name+" succesfully registered");
			model.addAttribute("success","Hi "+name+" You Have successfully registered. Please wait while your'e being redirected to Login page.");
			model.addAttribute("page",path+".jsp");
			if(details.equals("Farmer")){
				log.info("selected farmer in the registerpage");
				model.addAttribute("redirect","farmerlogin");
			}
			else if(details.equals("Buyer")){
				log.info("selected buyer in the registerpage");
				model.addAttribute("redirect","buyerlogin");
			}

		}

		return "success";
	}
	@RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
	public String Forgotpasswordget(){
		return "forgotpassword";
	}

	@RequestMapping(value="/forgotpassword",method=RequestMethod.POST)
	public String Forgotpasswordpost(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("cpassword") String confirmpassword, HttpSession session,Model model){
		log.info("name "+name+" password "+password+" confirm password "+confirmpassword);

		if(((name.equals(""))&&(password.equals(""))&&(confirmpassword.equals("")))){
			model.addAttribute("data_null","Please enter the details");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("None of the values entered");
			return "fail";
		}

		if(name.equals("")){
			model.addAttribute("data_null","Please enter a name");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("Name is null");
			return "fail";
		}
		if(password.equals("")){
			log.info("Password is null");
			model.addAttribute("data_null","Please enter Password");
			model.addAttribute("fail","forgotpassword.jsp");
			return "fail";
		}
		if(confirmpassword.equals("")){
			model.addAttribute("data_null","Please enter Confirm Password");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("Confirm Password is null");
			return "fail";
		}


		if(!(password.equals(confirmpassword))){
			model.addAttribute("data_null","Please enter the same Confirm Password and Password.");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("Confirm password and password fields are not equal");
			return "fail";
		}

		UserBean user = new UserBean();
		user.setName(name);
		user.setPassword(MD5.encryption(password));
		List<UserBean> userBean = UserDaoObj.getUserDetails(name);
		if(userBean.isEmpty()){
			model.addAttribute("data_null","Sorry a user with this name does not exist in our Database, Please Register");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("The user with this name does not exits");
			return "fail";
		}

		int count = UserDaoObj.getUserPassword(user);
		if(count!=1){
			model.addAttribute("data_null","Sorry a user with this name does not exist in our Database, Please Register");
			model.addAttribute("fail","forgotpassword.jsp");
			log.info("The user with this name does not exits");
			return "fail";
		}
		else{
			int updated_count = UserDaoObj.getUserPassword(user);
			if(updated_count==1){
				model.addAttribute("success","Hi "+name+" You're Password has been sucessfully reset. Please wait while redirecting you to Home Page");
				model.addAttribute("redirect","");
				model.addAttribute("page","forgotpassword.jsp");
				log.info("successfully updated the password in DB");
				return "success";
			}
		}
		return "forgotpassword";
	}

	@RequestMapping(value="/dashboard")
	public String dashboard(Model model,HttpSession session){
		session.setAttribute("header", "dashboard");
		log.info("in dashboard module");
		model.addAttribute("name",session.getAttribute("username"));
		int id = users.getId();
		log.info("id: "+id);
		ArrayList<String> location = new ArrayList<String>();
		List<ImagesBean> img = ImagesDao.allImages();
		int count = img.size();
		log.info("count: "+count);
		if(count!=0){
		model.addAttribute("count", count);
		}
		if(!img.isEmpty()){
		 for(ImagesBean im : img){
				 log.info("location of picture "+im.getFruitsvegetablesname());
				 location.add(im.getFruitsvegetablesname());
		 }
		}
		 session.setAttribute("location",location);
		return "dashboard";
	}

	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile(HttpSession session,Model model){
		session.setAttribute("header", "profile");
		log.info("in profile module");
		String username  = session.getAttribute("username").toString();
		List<UserDetailsBean> userdetailsBean = UserDetailsDaoObj.getUserDataDetails(username);
		for(UserDetailsBean data: userdetailsBean ) {
			log.info("data from profile : ");
			log.info("name : "+data.getUsername());
			log.info("description : "+data.getAboutme());
			log.info("address : "+data.getAddress());
			log.info("city : "+data.getCity());
			log.info("country : "+data.getCountry());
			log.info("email : "+data.getEmailaddress());
			log.info("fname : "+data.getFirstname());
			log.info("lname : "+data.getLastname());
			log.info("pincode : "+data.getPostalcode());
			model.addAttribute("name",username);
			model.addAttribute("description",data.getAboutme());
			model.addAttribute("address",data.getAddress());
			model.addAttribute("city",data.getCity());
			model.addAttribute("company","Grow Agriculture Inc.");
			model.addAttribute("country",data.getCountry());
			model.addAttribute("email",data.getEmailaddress());
			model.addAttribute("fname",data.getFirstname());
			model.addAttribute("lname",data.getLastname());
			model.addAttribute("pincode",data.getPostalcode());
		}
		return "profile";
	}


	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public String profileinsert(HttpSession session,Model model,@RequestParam("email") String email,@RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("country") String country,@RequestParam("pincode") int pincode,@RequestParam("description") String description){
		session.setAttribute("header", "profile");
		log.info("in profileinsert module");
		String username  = session.getAttribute("username").toString();
		model.addAttribute("name",username);
		int id = Integer.parseInt(session.getAttribute("id").toString());
		UserDetailsBean u = new UserDetailsBean();
		u.setId(id);
		u.setCompany("Grow Agriculture Inc.");
		u.setEmailaddress(email);
		u.setFirstname(fname);
		u.setUsername(username);
		u.setCountry(country);
		u.setLastname(lname);
		u.setAddress(address);
		u.setCity(city);
		u.setPostalcode(pincode);
		u.setAboutme(description);
		List<UserDetailsBean> userdetailsBean = UserDetailsDaoObj.getUserDataDetails(username);
		for(UserDetailsBean data: userdetailsBean){
			if(data.getId()==id){
				UserDetailsDaoObj.updateData(u);
				model.addAttribute("name",username);
				model.addAttribute("description",description);
				model.addAttribute("address",address);
				model.addAttribute("city",city);
				model.addAttribute("company","Grow Agriculture Inc.");
				model.addAttribute("country",country);
				model.addAttribute("email",email);
				model.addAttribute("fname",fname);
				model.addAttribute("lname",lname);
				model.addAttribute("pincode",pincode);
				return "profile";
			}
		}


		UserDetailsDaoObj.insertData(u);
		model.addAttribute("name",username);
		model.addAttribute("description",description);
		model.addAttribute("address",address);
		model.addAttribute("city",city);
		model.addAttribute("company","Grow Agriculture Inc.");
		model.addAttribute("country",country);
		model.addAttribute("email",email);
		model.addAttribute("fname",fname);
		model.addAttribute("lname",lname);
		model.addAttribute("pincode",pincode);
		return "profile";
	}



	@RequestMapping(value="/farmerslist")
	public String farmerslist(Model model,HttpSession session){
		session.setAttribute("header", "farmerlist");
		List<Integer> id = new ArrayList<Integer>();
		List<String> name = new ArrayList<String>();
		List<String> email = new ArrayList<String>();
		List<String> address = new ArrayList<String>();
		List<UserBean> userBean = UserDaoObj.getallUser();
		for (UserBean u : userBean){
			if(u.getUsertype().equals("Farmer")){
				List<UserDetailsBean> userdetails = UserDetailsDaoObj.getallUserDataDetails(u.getId());
				for(UserDetailsBean ud : userdetails){
					if(u.getId()==ud.getId()){
						id.add(u.getId());
						name.add(ud.getFirstname()+" "+ud.getLastname());
						email.add(ud.getEmailaddress());
						address.add(ud.getAddress()+" "+ud.getCity()+" "+ud.getPostalcode()+" "+ud.getCountry());
						break;
					}
				}
				if(!id.contains(u.getId())){
					id.add(u.getId());
					name.add(u.getName());
					email.add("");
					address.add("");
				}
			}
		}
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		session.setAttribute("address", address);
		return "farmerslist";
	}


	
	@RequestMapping(value="upload")  
	public String saveimage(HttpSession session,Model model){
		int id = users.getId();
		log.info("id: "+id);
		ArrayList<String> loc = new ArrayList<String>();
		List<ImagesBean> img = ImagesDao.allImages();
		int count = img.size();
		log.info("count: "+count);
		if(count!=0){
		model.addAttribute("count", count);
		}
		if(!img.isEmpty()){
		 for(ImagesBean im : img){
			 if(id==im.getId()){
				 log.info("location of picture "+im.getFruitsvegetablesname());
				 loc.add(im.getFruitsvegetablesname());
			 }
		 }
		}
		 session.setAttribute("location",loc);
		return "uploadform";
	}
	
	
	
	/*@RequestMapping(value="savefile",method=RequestMethod.POST)  
	public String saveimage(@RequestParam CommonsMultipartFile file,  
			HttpSession session,Model model) throws Exception{
		
		
		imagestorelocation =  windowsStoreLoacation;
		  if (SystemUtils.IS_OS_LINUX) {
			  imagestorelocation = unixStoreLoacation;
			  log.info("OS is Linux based, image Storage Location is set to : "+imagestorelocation);
		    }
		 
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("/images");  
		log.info("Imagelocation from config : "+imagestorelocation);
		String filename = file.getOriginalFilename();
		log.info("path<nikhil> : "+path);
		
		log.info("filename : "+filename);
		File destination = new File("c://images/"+filename);
		if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".gif")){
		ImagesBean img = new ImagesBean();
		img.setId(users.getId());
		img.setFruitsvegetablesname(filename);
		img.setFruitvegetablespiclocation(path + File.separator + filename);
		img.setUploaddate(CurrentDate.getCurrentDate());
		ImagesDao.insertImagesData(img);
		byte[] bytes = file.getBytes();  
		try{
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(  
				new File(imagestorelocation + File.separator + filename)));  
		stream.write(bytes);  
		stream.flush();  
		stream.close();
		}
		catch(FileNotFoundException fe){
			log.info("FileNotFoundException : "+fe);
			log.info("FileNotFoundException : in location : "+imagestorelocation);
			model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
			return "warning";
		}
		model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
		return "uploadsuccess"; 
		}
		model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
		return "warning";
	}  */

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String handleFormUpload(Model model, 
	    @RequestParam("file") MultipartFile file) throws IOException{
		
		log.info("catalinahomelocation: "+catalinahomelocation);
		
		
		imagestorelocation = new File(catalinahomelocation+windowsimagestorelocation);
		
		if (SystemUtils.IS_OS_LINUX) {
			  imagestorelocation = new File(catalinahomelocation+uniximagesStoreLoacation);
			  log.info("OS is Linux based, image Storage Location is set to : "+imagestorelocation);
		    }
		
		
		if (!imagestorelocation.exists()) {
			imagestorelocation.mkdirs();
        }
		
		
		
		
		String filename = file.getOriginalFilename();
		log.info("Location of catilana "+imagestorelocation+File.separator+filename);
		if(filename.contains(".jpg")||filename.contains(".png")||filename.contains(".gif")){
			
	if (!file.isEmpty()) {
		
		ImagesBean img = new ImagesBean();
		img.setId(users.getId());
		img.setFruitsvegetablesname(filename);
		img.setFruitvegetablespiclocation(imagestorelocation+File.separator+filename);
		img.setUploaddate(CurrentDate.getCurrentDate());
		ImagesDao.insertImagesData(img);
		try{
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 
	 File destination = new File(imagestorelocation+File.separator+filename); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 ImageIO.write(src, "png", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	 }
		catch(FileNotFoundException fe){
			log.info("FileNotFoundException : "+fe);
			log.info("FileNotFoundException : in location : "+imagestorelocation);
			model.addAttribute("warningmessage","Sorry our servers are facing problems. Please tray again later! ");
			return "warning";
		}
		model.addAttribute("successmessage","Successfully Uploaded the picture.Please refresh this page to see your Uploads.");
		return "uploadsuccess"; 
		}
}
		model.addAttribute("warningmessage","Please Upload a Picture with .jpg,.gif or .png formats. ");
		return "warning";
}
		
		
		
		
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "home";
	}






}