package com.json;

public class JsonGetSet {
	
	private String manufacturer;
	private String device;
	private String status;
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "eshop [manufacturer=" + manufacturer + ", device=" + device
				+ ", status=" + status + "]";
	}

}
