package com.thbs.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thbs.Beans.UsersBean;

public class UserDataMapper implements RowMapper<UsersBean>{

	public UsersBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersBean u = new UsersBean();
		u.setId(rs.getInt("ID"));
		u.setName(rs.getString("NAME"));
		u.setEmail(rs.getString("EMAIL"));
		u.setPassword(rs.getString("PASSWORD"));
		u.setUserType(rs.getString("USER_TYPE"));
		u.setEmailVerified(rs.getString("EMAIL_VERIFIED"));
		u.setAdminAccepted(rs.getString("ADMIN_ACCEPTED"));
		u.setSubscribed(rs.getString("SUBSCRIBED"));
		u.setLastLogin(rs.getString("LAST_LOGIN"));
		return u;
	}
	
	
}
