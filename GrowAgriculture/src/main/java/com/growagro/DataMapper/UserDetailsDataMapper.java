package com.growagro.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.growagro.Bean.UserDetailsBean;



public class UserDetailsDataMapper implements RowMapper<UserDetailsBean> {

	@Override
	public UserDetailsBean mapRow(ResultSet rs, int count) throws SQLException {
		UserDetailsBean userdetail = new UserDetailsBean();
		userdetail.setAboutme(rs.getString("about_me"));
		userdetail.setAddress(rs.getString("address"));
		userdetail.setCity(rs.getString("city"));
		userdetail.setCompany(rs.getString("company"));
		userdetail.setCountry(rs.getString("country"));
		userdetail.setEmailaddress(rs.getString("email_address"));
		userdetail.setFirstname(rs.getString("first_name"));
		userdetail.setId(rs.getInt("id"));
		userdetail.setLastname(rs.getString("last_name"));
		userdetail.setPostalcode(rs.getInt("postal_code"));
		userdetail.setUsername(rs.getString("username"));
		return userdetail;
	}

}
