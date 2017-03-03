package com.thbs.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thbs.Beans.SubjectsBean;



public class SubjectsDataMapper implements RowMapper<SubjectsBean>{

	@Override
	public SubjectsBean mapRow(ResultSet rs, int count) throws SQLException {
		SubjectsBean s = new SubjectsBean();
		s.setId(rs.getInt("ID"));
		s.setName(rs.getString("NAME"));
		s.setLastupdate(rs.getString("LAST_UPDATE"));
		return s;
	}

}
