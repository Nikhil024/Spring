package com.thbs.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CurrentDate {
	private static final Logger log = LoggerFactory.getLogger(CurrentDate.class);

	public static String getCurrentDate(){
		log.info("In the getCurrentDate method");
		Date date = new Date( );
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String formatedDate = cal.get(Calendar.DATE) + "-" + new SimpleDateFormat("MMM").format(cal.getTime()) + "-" +cal.get(Calendar.YEAR);
		log.info("The current Date is : "+formatedDate);
		return formatedDate;
	}

}
