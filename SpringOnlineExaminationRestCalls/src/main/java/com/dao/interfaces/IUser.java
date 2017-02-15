package com.dao.interfaces;

import java.util.List;

import com.beans.User;

public interface IUser {
	public List<User> getAllUsers();
	public int insertUsers(User u);
	public int updateUsers(User u);
	public int deleteUsers(User u);

}
