package com.growagro.DataMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.growagro.Bean.ImagesBean;


public class ImagesDataMapper implements RowMapper<ImagesBean>{

	@Override
	public ImagesBean mapRow(ResultSet rs, int arg1) throws SQLException {
		ImagesBean img = new ImagesBean();
		img.setId(rs.getInt("ID"));
		img.setUserpicture(rs.getString("USERS_PICTURE"));
		img.setUserpicturelocation(rs.getString("USERS_PICTURE_LOCATION"));
		img.setFruitsvegetablesname(rs.getString("FRUITS_VEGETABLES_NAME"));
		img.setFruitvegetablespiclocation(rs.getString("FRUITS_VEGETABLES_PIC_LOCATION"));
		img.setUploaddate(rs.getString("UPLOADED_DATE"));
		return img;
	}

}
