package com.json;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonConversion {
	public static void conversion(List<JsonGetSet> getAlldetails,ArrayList<String> device,ArrayList<String> status,int count){
		
		
		JSONObject obj = null;
		
		try {
			//used to get the working directory of the catalina
			String strClassPath = System.getProperty("catalina.base");
			System.out.println(strClassPath);
			
			//appending the location of config.properties to the catalina home directory
			strClassPath = strClassPath + "\\wtpwebapps\\eShop\\resources\\internal.json"; 
			FileWriter file = new FileWriter(strClassPath);
			if(device.size()==status.size()) {
			for(int i=0;i<count;i++){
			String devices = device.get(i);
			String statuss = status.get(i);
			obj = new JSONObject();
			
				obj.put("device", devices);
				obj.put("status", statuss);
				System.out.print(obj);
				file.write(obj.toJSONString());
			}
			}
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}
}