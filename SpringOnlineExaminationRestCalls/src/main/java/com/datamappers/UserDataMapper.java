package com.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.User;



public class UserDataMapper implements RowMapper<User> {

	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setBirthdate(rs.getString("birthdate"));
		user.setProfession(rs.getString("profession"));
		return user;
	}
}