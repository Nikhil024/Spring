package com.growagro.Interfaces;

import java.util.List;

import com.growagro.Bean.UserDetailsBean;



public interface IuserDetailsData {
	
	public int insertData(UserDetailsBean u);
	public int updateData(UserDetailsBean u);
	public List<UserDetailsBean> getUserDataDetails(String name);
	public List<UserDetailsBean> getallUserDataDetails(int id);
}
