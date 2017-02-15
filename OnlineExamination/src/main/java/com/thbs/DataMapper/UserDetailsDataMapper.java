package com.thbs.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thbs.Beans.UserDetailsBean;

public class UserDetailsDataMapper implements RowMapper<UserDetailsBean> {

	@Override
	public UserDetailsBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsBean ud = new UserDetailsBean();
		ud.setAboutme(rs.getString("ABOUTME"));
		ud.setAddress(rs.getString("ADDRESS"));
		ud.setCity(rs.getString("CITY"));
		ud.setCountry(rs.getString("COUNTRY"));
		ud.setEmail(rs.getString("EMAIL"));
		ud.setId(rs.getInt("ID"));
		ud.setLname(rs.getString("LNAME"));
		ud.setName(rs.getString("FNAME"));
		ud.setPostalcode(rs.getString("POSTALCODE"));
		ud.setLastupdate(rs.getString("LASTUPDATE"));
		return ud;
	}

}
