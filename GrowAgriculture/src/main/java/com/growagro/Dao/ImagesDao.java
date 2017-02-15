package com.growagro.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.growagro.Bean.ImagesBean;
import com.growagro.DataMapper.ImagesDataMapper;
import com.growagro.DataMapper.UserDataMapper;
import com.growagro.Interfaces.IimagesData;

public class ImagesDao implements IimagesData {

	private static final Logger log = LoggerFactory.getLogger(ImagesDao.class);
	String tablename = "IMAGES";
	String insert = "INSERT INTO "+tablename+"(ID,USERS_PICTURE,USERS_PICTURE_LOCATION,FRUITS_VEGETABLES_NAME,FRUITS_VEGETABLES_PIC_LOCATION,UPLOADED_DATE) values (?,?,?,?,?,?)";
	String delete = "DELETE FROM "+tablename+" WHERE ID = ?";
	String allimages = "SELECT * FROM "+tablename +" ORDER BY UPLOADED_DATE DESC";

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}




	@Override
	public int insertImagesData(ImagesBean img) {
		int count = jdbcTemplateObject.update(insert,img.getId(),img.getUserpicture(),img.getUserpicturelocation(),img.getFruitsvegetablesname(),img.getFruitvegetablespiclocation(),img.getUploaddate());
		if(count == 1) {
			log.info("record has been inserted!!");
			return count;
		}
		return count ;
	}

	@Override
	public int deleteImagesData(ImagesBean img) {
		int count = jdbcTemplateObject.update(delete,img.getId());
		if(count == 1) {
			log.info("record has been deleted!!");
			return count;
		}
		return count;
	}

	@Override
	public List<ImagesBean> allImages(){
		List<ImagesBean> img = jdbcTemplateObject.query(allimages, new ImagesDataMapper());
		return img;
	}
	
	
}
