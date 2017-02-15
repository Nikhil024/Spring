package com.json;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonConversion {
	public static void conversion(ArrayList<String> manufacturer,ArrayList<String> device,ArrayList<String> status,int count){
		JSONObject obj = null;
		try {
			//used to get the working directory of the catalina
			String strClassPath = System.getProperty("catalina.base");


			//appending the location of config.properties to the catalina home directory
			strClassPath = strClassPath + "\\wtpwebapps\\eShop\\resources\\internal.json";
			System.out.println("Location of the json file "+strClassPath);
			FileWriter file = new FileWriter(strClassPath);
			if(manufacturer.size() == device.size()&&device.size()==status.size()&&status.size()==manufacturer.size() ) {
				for(int i=0;i<count;i++){
					String manufacturers = manufacturer.get(i);
					String devices = device.get(i);
					String statuss = status.get(i);
					obj = new JSONObject();

					obj.put("manufacturer", manufacturers);
					obj.put("device", devices);
					obj.put("status", statuss);
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