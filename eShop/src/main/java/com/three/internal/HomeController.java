package com.three.internal;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.json.JsonConversion;
import com.json.JsonGetSet;
import com.json.jsonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home1(HttpServletRequest request) {
		ModelAndView modelAndview = new ModelAndView("home.jsp");
		return modelAndview;
	}


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView ModelAndView(HttpServletRequest request, Model model,HttpSession session) {
		int count = 0;
		try{
			if(request.getParameter("input_count")!=null){
				count = Integer.parseInt(request.getParameter("input_count"));
			}

			session.setAttribute("count",count);
		}
		catch(Exception e){
			ModelAndView modelAndview = new ModelAndView("error.jsp");
			return modelAndview;
		}
		ModelAndView modelAndview = new ModelAndView("home.jsp");
		return modelAndview;
	}


	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public String details(HttpServletRequest request, Model model,HttpSession session) {
		ModelAndView modelAndview;
		String strClassPath = System.getProperty("catalina.base");
		strClassPath = strClassPath + "\\wtpwebapps\\eShopApp\\resources\\internal.json"; 
		try{

			int count = Integer.parseInt(session.getAttribute("count").toString());
			ArrayList<String> manufacturer = new ArrayList<String>();
			ArrayList<String> device = new ArrayList<String>();
			ArrayList<String> status = new ArrayList<String>();

			for(int i=0;i<count;i++){
				manufacturer.add(request.getParameter("manufacturer_name"+i));
				device.add(request.getParameter("device_name"+i));
				status.add(request.getParameter("Status"+i));
			}

			jsonService js = null;

			js.variablesdetails(device, status, count);
			/*JsonConversion.conversion(jsonService.getAlldetails(),device, status, count);
			session.setAttribute("filelocation", strClassPath);*/
		}
		catch(Exception e){
			log.info("Exception"+e);
		}
		String redirectUrl = "/details";
		session.removeAttribute("count");
		return "redirect:" +redirectUrl;
	}


	@RequestMapping(value = "/details",method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<JsonGetSet> getDetails(HttpSession session) {
		List<JsonGetSet> js=jsonService.getAlldetails();
		return js;
	}






}