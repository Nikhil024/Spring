package com.thbs.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thbs.Beans.EmailLinkEncryptionBean;

public class EmailLinkEncryptionDataMapper implements RowMapper<EmailLinkEncryptionBean>{

	@Override
	public EmailLinkEncryptionBean mapRow(ResultSet rs, int count) throws SQLException {
		EmailLinkEncryptionBean ele = new EmailLinkEncryptionBean();
		ele.setId(rs.getInt("ID"));
		ele.setName(rs.getString("NAME"));
		ele.setEmail(rs.getString("EMAIL"));
		ele.setLastUpdate(rs.getString("LAST_UPDATE"));
		return ele;
	}

}
