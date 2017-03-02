package com.thbs.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.thbs.Beans.ImagesBean;

public class ImagesDataMapper implements RowMapper<ImagesBean>{

	@Override
	public ImagesBean mapRow(ResultSet rs, int count) throws SQLException {
		ImagesBean i = new ImagesBean();
		i.setId(rs.getInt("ID"));
		i.setName(rs.getString("IMAGES_NAME"));
		i.setLocation(rs.getString("IMAGES_LOCATION"));
		i.setUploadDate(rs.getString("UPLOADED_DATE"));
		i.setPiechart(rs.getString("PIECHART"));
		i.setProfilepicture(rs.getString("PROFILEPICTURE"));
		i.setLastupdateDate(rs.getString("LAST_UPDATE"));
		return i;
	}

	

}
