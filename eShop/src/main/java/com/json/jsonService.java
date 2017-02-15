package com.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class jsonService {
	
	static ArrayList<String> device = new ArrayList<String>();
	static ArrayList<String> status = new ArrayList<String>();
	static int count = 0;
	
	public static void variablesdetails(ArrayList<String> device1,ArrayList<String> status1,int count1){
		device = device1;
		status = status1;
		count = count1;
	}


	public static List<JsonGetSet> getAlldetails() {
		List<JsonGetSet> details = new ArrayList<JsonGetSet>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		for(int i=0;i<count;i++){
			JsonGetSet js = new JsonGetSet();
			js.setId(i);
			js.setBadge_id(i);
			js.setDevice_name(device.get(i));
			js.setStatus(status.get(i));
			js.setActive(1);
			js.setCreated_at(dateFormat.format(date));
			js.setUpdated_at(dateFormat.format(date));
			js.setOffer_description(" ");
			js.setBadge("null");
			details.add(js);
		}
		
		return details;
	}

}
