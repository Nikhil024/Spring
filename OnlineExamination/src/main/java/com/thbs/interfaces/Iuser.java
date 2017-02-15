package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.UsersBean;



public interface Iuser {

public int insertData(UsersBean u);
	
	public List<UsersBean> getUserDetails(String email);
	
	public List<UsersBean> getUserDetails(int id);
	
	public List<UsersBean> getallUser();
	
	public int getUserPassword(UsersBean u);
	
	public int updateUserColumn(String query, int id);
}
