package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.UserDetailsBean;


public interface IuserDetails {
	
	public List<UserDetailsBean> getAllUserDetails(int id);
	public int insertUserDetails(UserDetailsBean ud);
	public int UpdateUserDetails(String Query,int id);

}
