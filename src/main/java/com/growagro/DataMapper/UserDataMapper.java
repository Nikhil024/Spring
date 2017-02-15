package com.growagro.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.growagro.Bean.UserBean;

public class UserDataMapper implements RowMapper<UserBean> {

	
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean userBean = new UserBean();
		userBean.setId(rs.getInt("id"));
		userBean.setName(rs.getString("name"));
		userBean.setPassword(rs.getString("password"));
		userBean.setUsertype(rs.getString("USER_TYPE"));
		userBean.setCreateddate(rs.getString("CREATED_DATE"));
		return userBean;
	}
}