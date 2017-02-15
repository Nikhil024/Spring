package com.growagro.Interfaces;

import java.util.List;

import com.growagro.Bean.UserBean;

public interface IuserData 
{
	
	public int insertData(UserBean u);
	
	public List<UserBean> getUserDetails(String name);
	
	public List<UserBean> getallUser();
	
	public int getUserPassword(UserBean u);
}
