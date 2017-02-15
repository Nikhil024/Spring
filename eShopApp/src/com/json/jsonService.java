package com.json;

import java.util.ArrayList;
import java.util.List;

public class jsonService {

	static ArrayList<String> manufacturer = new ArrayList<String>();
	static ArrayList<String> device = new ArrayList<String>();
	static ArrayList<String> status = new ArrayList<String>();
	static int count = 0;
	public static void variablesdetails(ArrayList<String> manufacturers,ArrayList<String> devices,ArrayList<String> statuss,int counts){
		manufacturer = manufacturers;
		device = devices;
		status = statuss;
		count = counts;
	}


	public static List<JsonGetSet> getAlldetails() {
		List<JsonGetSet> details = new ArrayList<JsonGetSet>();

		for(int i=0;i<count;i++){
			JsonGetSet js = new JsonGetSet();
			js.setManufacturer(manufacturer.get(i));
			js.setDevice(device.get(i));
			js.setStatus(status.get(i));
			details.add(js);
		}

		return details;
	}

}
