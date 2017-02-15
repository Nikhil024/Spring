package com._48months.org;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.data.CaesarCipher;
import com.data.Constants;
import com.data.Email;
import com.data.PropertiesfileReading;
import com.data.Queries;
import com.data.RegexMatches;
import com.sql.Dbutil;


@Controller
public class HomeControllers {
	static Logger log = Logger.getLogger(HomeControllers.class.getName());
	String pagename;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String commingSoons(HttpServletRequest request){
		log.debug("Entered into commingSoon GET method");
		String email = request.getParameter("email");
		log.info(email);
		return "commingsoon";

	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String commingSoon(HttpServletRequest request){
		log.debug("Entered into commingSoon post method");
		try{
			String email = request.getParameter("email");

			if (!(RegexMatches.match(email) || email.equalsIgnoreCase(""))){
				return "commingsoonerror";
			}
			else{
				String subject = "You have successfully subscribed";
				String name = email.substring(0,email.indexOf("@"));
				log.info("subject "+subject+" name"+name);
				Email.sendemail(email, subject, name);
				return "commingsoonsuccess";
			}
		}
		catch(Exception e){
			log.info("Exception "+e);
			return "commingsoonerror";
		}
	}




	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String regsiter(){
		log.debug("Entered into Register GET method");
		return "register";

	}






	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String doRegsiter(HttpServletRequest request,HttpSession session,Model model){
		log.debug("Entered into Register POST method");
		Random rg = new Random();
		int randomInt = rg.nextInt(10000);
		log.debug("randomInt: "+randomInt);
		String name = request.getParameter("username");
		log.debug("name is "+name);
		String password = CaesarCipher.encrypt(request.getParameter("password"));
		log.debug("encrypted password "+password);
		String email = request.getParameter("email");
		log.debug("email :"+email);
		System.out.println(name+" "+password+" "+email);
		if (!(RegexMatches.match(email) || (request.getParameter("username") == null) || (request.getParameter("password")== null))){
			log.debug("matching of username,password,email error");
			model.addAttribute("error","all");
			return "registerfail";
		}
		else{
			try{
				log.debug("Matching username and process");
				Date date = new Date();
				model.addAttribute("emailverification",randomInt);
				String DbDate = date.toString();
				log.debug("date to be entered into db : "+DbDate);
				log.debug("insert Query : " +Queries.Create("USERS_FLOW_48", "USERS_FLOW_48_SEQUENCE.NEXTVAL,'"+name+"','"+password+"','"+email+"','"+DbDate+"','"+randomInt+"','n'"));
				Dbutil.Orcale(Queries.Create("USERS_FLOW_48", "USERS_FLOW_48_SEQUENCE.NEXTVAL,'"+name+"','"+password+"','"+email+"','"+DbDate+"','"+randomInt+"','n'"));
				log.info("Sending mail to "+email);
				String subject = "Hi "+name+" welcome to 48Flows";
				Email.sendemailverf(email, randomInt, name, subject);
				log.info("successfully sent mail to "+email);
				return "success";
			}

			catch(Exception e){
				log.debug("Exception: "+e,e);
				return "registeralfail";
			}
		}

	}


	@RequestMapping("/homepage")
	public String goHomepage(HttpSession session){
		pagename = "homepage";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		return pagename;
	}

	@RequestMapping("/orderfreesim")
	public String Orderafreesim(HttpSession session){
		pagename = "orderfreesim";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		return pagename;
	}

	@RequestMapping("/download")
	public String Downloads(HttpSession session){
		pagename = "downloads";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		return pagename;
	}

	@RequestMapping("/activateafreesim")
	public String activateaim(HttpSession session){
		pagename = "activateafreesim";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		return pagename;
	}
	@RequestMapping("/credentials")
	public String Credentails(HttpSession session,Model model){
		pagename = "credentials";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		log.info("PropertiesfileReading.getProperty('github_url')"+PropertiesfileReading.getProperty("github_url"));

		model.addAttribute("github_url",Constants.GITHUB_URL);
		model.addAttribute("github_username",Constants.GITHUB_USERNAME);
		model.addAttribute("github_password",Constants.GITHUB_PASSWORD);

		model.addAttribute("confluenceurl",Constants.CONFLUENCEURL);
		model.addAttribute("confluence_username",Constants.CONFLUENCE_USERNAME);
		model.addAttribute("confluence_password",Constants.CONFLUENCE_PASSWORD);

		model.addAttribute("jira_url",Constants.JIRA_URL);
		model.addAttribute("jira_username",Constants.JIRA_USERNAME);
		model.addAttribute("jira_password",Constants.JIRA_PASSWORD);


		model.addAttribute("jbpm_url",Constants.JBPM_URL);
		model.addAttribute("jbpm_username",Constants.JBPM_USERNAME);
		model.addAttribute("jbpm_password",Constants.JBPM_PASSWORD);



		model.addAttribute("cs_url",Constants.CS_URL);
		model.addAttribute("cs_username",Constants.CS_USERNAME);
		model.addAttribute("cs_password",Constants.CS_PASSWORD);

		model.addAttribute("sup_url",Constants.SUP_URL);



		model.addAttribute("konakart_url",Constants.KONAKART_URL);
		model.addAttribute("konakart_username",Constants.KONAKART_USERNAME);
		model.addAttribute("konakart_password",Constants.KONAKART_PASSWORD);


		model.addAttribute("portal_db_ip",Constants.PORTAL_DB_IP);
		model.addAttribute("portal_db_username",Constants.PORTAL_DB_USERNAME);
		model.addAttribute("portal_db_password",Constants.PORTAL_DB_PASSWORD);


		model.addAttribute("konakart_db_url",Constants.KONAKART_DB_URL);
		model.addAttribute("konakart_db_username",Constants.KONAKART_DB_USERNAME);
		model.addAttribute("konakart_db_password",Constants.KONAKART_DB_PASSWORD);

		model.addAttribute("jbpm_db_url",Constants.JBPM_DB_URL);
		model.addAttribute("jbpm_db_username",Constants.JBPM_DB_USERNAME);
		model.addAttribute("jbpm_db_password",Constants.JBPM_DB_PASSWORD);

		model.addAttribute("db_server_url",Constants.DB_SERVER_URL);
		model.addAttribute("db_server_username",Constants.DB_SERVER_USERNAME);
		model.addAttribute("db_server_password",Constants.DB_SERVER_PASSWORD);

		model.addAttribute("bs_url",Constants.BS_URL);
		model.addAttribute("bs_username",Constants.BS_USERNAME);
		model.addAttribute("bs_password",Constants.BS_PASSWORD);

		model.addAttribute("fe_url",Constants.FE_URL);
		model.addAttribute("fe_username",Constants.FE_USERNAME);
		model.addAttribute("fe_password",Constants.FE_PASSWORD);

		model.addAttribute("be_url",Constants.BE_URL);
		model.addAttribute("be_username",Constants.BE_USERNAME);
		model.addAttribute("be_password",Constants.BE_PASSWORD);		
		return pagename;
	}

	/*@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String Signups(){
		log.info("in signup get block");
		return "signup";
	}


	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String Signup(HttpServletRequest request,HttpSession session,Model model){
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		log.info("in Signup block name= "+name+" email= "+email+" password= "+password);
		pagename = "signup";
		session.setAttribute("currentpage", pagename);
		log.info("Session of current page "+session.getAttribute("currentpage"));
		return pagename;
	}*/




	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String Login(){
		log.debug("Entered into Login GET method");

		return "Login";
	}


	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String Afterlogin(HttpServletRequest request,HttpSession session,Model model){
		log.debug("Entered into Login POST method");
		String name = request.getParameter("username");
		Date date = new Date();
		String DbDate = date.toString();
		String password = request.getParameter("password");
		System.out.println("name from form is "+name);
		System.out.println("password(encrypt) from form is "+CaesarCipher.encrypt(password));
		log.debug("username "+name+" password "+password);
		try{
			log.debug("select Query : "+Queries.Select("*", "USERNAME = '"+name+"'"));
			ResultSet rs = Dbutil.Orcale(Queries.Select("*", "USERNAME = '"+name+"'"));
			if(rs.next()){
				log.debug("the username is "+rs.getString(2)+" and password from db is "+CaesarCipher.decrypt(rs.getString(3)));
				log.debug("the username entered in for is "+name+" and the passoword from form is "+password);
				if (rs.getString(2).equals(name) && (CaesarCipher.decrypt(rs.getString(3)).equals(password))){
					Dbutil.Orcale(Queries.Update(name,DbDate));
					if(rs.getString(7).equals("y")){
						model.addAttribute("name",name);
						session.setAttribute("lastlogindate", rs.getString(5));
						session.setAttribute("name", name);
						log.debug("name and password are equal");
						log.debug("after success login name: "+name+" logindate : "+rs.getString(5));

						/*
						 * 
						 * Used to redirect to the same page where the user currently is
						 * 
						 */
						String pagename = (String)session.getAttribute("currentpage");
						if(pagename == null)
						{
							log.info("Entered into the login redirect block "+session.getAttribute("currentpage"));
							pagename = "homepage";
						}
						log.info("Entered into the login redirect block "+session.getAttribute("currentpage"));
						return pagename;
					}
					else{
						model.addAttribute("name",name);
						return "EmailVarif";
					}
				}

				else{
					model.addAttribute("data","password OR username");
					log.debug("username and password are not equal");
					return "loginfail";
				}	
			}
			else{
				log.debug("no data in db");
				System.out.println("Error");
				return "loginfail";

			}
		}
		catch(Exception e){
			log.debug("Exception"+e);
			e.printStackTrace();
		}
		return "Login";


	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		log.debug("entered logout");
		log.debug("loggin out "+session.getAttribute("name")+" and removing from session attribute");
		session.removeAttribute("name");
		log.debug("removed after logout");

		/*
		 * 
		 * Used to redirect to the same page where the user currently is
		 * 
		 */
		String pagename = (String)session.getAttribute("currentpage");
		if(pagename == null)
		{
			log.info("Entered into the logout redirect block "+session.getAttribute("currentpage"));
			pagename = "homepage";
		}
		log.info("Entered into the logout redirect block "+session.getAttribute("currentpage"));
		return pagename;
	}

	@RequestMapping(value="/email/verification/{evid}",method=RequestMethod.GET)
	public String EmailVerification(Model model,@PathVariable("evid") int evid){
		log.debug("Entered verify email block");
		try{
			log.debug("Select Query"+Queries.Select("USERNAME,EMAIL,EMAILVERIFICATION,EVERIFIED", "EMAILVERIFICATION = "+evid));
			ResultSet rs = Dbutil.Orcale(Queries.Select("USERNAME,EMAIL,EMAILVERIFICATION,EVERIFIED", "EMAILVERIFICATION = "+evid));
			if(rs.next()){
				if(rs.getString(4).equals("y")){
					model.addAttribute("name",rs.getString(1));
					log.info("email already success for name : "+rs.getString(1));
					return "EmailValAlreadySuccess";
				}
				else
				{
					model.addAttribute("name",rs.getString(1));
					System.out.println("email details"+rs.getString(1)+" "+rs.getString(2)+""+rs.getString(3));
					Dbutil.Orcale(Queries.Updateemailverif(rs.getString(2), "y"));
					return "EmailValSuccess";
				}
			}
			else{
				return "EmailValFailure";
			}
		}
		catch(Exception e){
			log.debug("Exception"+e);
			e.printStackTrace();
		}
		return "EmailValFailure";

	}
	
	@RequestMapping(value="/email/unsubscribe/{uscid}",method=RequestMethod.GET)
	public String unsubscribe(Model model,@PathVariable("uscid") int uscid){
		log.info("entered into the unsubscribeblock");
		try{
			log.debug("Select Query"+Queries.Select("USERNAME,EMAIL,EMAILVERIFICATION,EVERIFIED", "EMAILVERIFICATION = "+uscid));
		}catch(Exception e){
			
		}
		return "";
	}
	
	@RequestMapping("/demo")
	public String demo(){
		return "demo";
	}

	@RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
	public String Forgotpassword(){
		log.debug("forgotpassword get block");
		return "forgotpassword";
	}

	@RequestMapping(value="/forgotpassword",method=RequestMethod.POST)
	public String doForgotpassword(Model model,HttpSession session,HttpServletRequest request){
		log.debug("entering forgotpassword block");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		log.debug("name: "+name+" password: "+password+" confirm password: "+cpassword);
		if(password.equals(cpassword)){
			try{
				log.debug("passwords are equal");
				log.debug("Update Query: "+Queries.Updatepass("USERS_FLOW_48", name, CaesarCipher.encrypt(password),"n"));
				Dbutil.Orcale(Queries.Updatepass("USERS_FLOW_48", name, CaesarCipher.encrypt(password),"n"));
				ResultSet rs = Dbutil.Orcale(Queries.Select("EMAIL,EMAILVERIFICATION", "username='"+name+"'"));
				if(rs.next()){
					String email = rs.getString(1);
					int randomInt = Integer.parseInt(rs.getString(2));
					String subject = "Hi "+name+" welcome to 48Flows";
					Email.sendemailverf(email, randomInt, name, subject);
				}
				return "forgotpasssuccess";
			}
			catch(Exception e){
				log.debug("Exception: "+e);
				e.printStackTrace();
				return "forgotpassfailure";
			}
		}
		else{
			log.debug("passwords are not equal");
			return "forgotpassfailure";
		}

	}
}
