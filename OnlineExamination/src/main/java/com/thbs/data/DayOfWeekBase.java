package com.thbs.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class DayOfWeekBase extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String flag = "yes";
		String makeSiteDown = PropertiesfileReading.getProperty("MakeSiteDown");
		if(flag.equals(makeSiteDown)) {
			response.sendRedirect("/controllers/websiteisdown.html");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//before  the view 
		System.out.println("This is called before the controller calls the view ");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		//After the view
		System.out.println("this is called aftetr the view is called by the controller");
	}

}