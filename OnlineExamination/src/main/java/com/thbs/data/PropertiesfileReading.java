package com.thbs.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

public class PropertiesfileReading {
	static Logger log = Logger.getLogger(PropertiesfileReading.class.getName());
	public static String getProperty(String name){
		//public static void main(String args[]){
	Properties prop = new Properties();
	InputStream input = null;

	try {
		//used to get the working directory of the catalina
		String strClassPath = System.getProperty("catalina.base");
		if(SystemUtils.IS_OS_LINUX){
		//appending the location of config.properties to the catalina home directory
		strClassPath = "/" + strClassPath + "/wtpwebapps/OnlineExamination/resources/config.properties";
		}
		if(SystemUtils.IS_OS_WINDOWS){
			strClassPath = strClassPath + "\\wtpwebapps\\OnlineExamination\\resources\\config.properties";
		}
		input = new FileInputStream(strClassPath);

		// load a properties file
		prop.load(input);
		/*log.info("name: "+name+" value: "+prop.getProperty(name));*/
		return prop.getProperty(name);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return prop.getProperty(name);
}
}