package com.beans;

public class ueQuestions {
	
	private int id; 
	private int fkuserid;
	private int fkquestionid;
	private String selectedanswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFkuserid() {
		return fkuserid;
	}
	public void setFkuserid(int fkuserid) {
		this.fkuserid = fkuserid;
	}
	public int getFkquestionid() {
		return fkquestionid;
	}
	public void setFkquestionid(int fkquestionid) {
		this.fkquestionid = fkquestionid;
	}
	public String getSelectedanswer() {
		return selectedanswer;
	}
	public void setSelectedanswer(String selectedanswer) {
		this.selectedanswer = selectedanswer;
	}
}
