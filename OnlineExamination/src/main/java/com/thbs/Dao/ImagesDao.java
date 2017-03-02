package com.thbs.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thbs.Beans.ImagesBean;
import com.thbs.DataMapper.ImagesDataMapper;
import com.thbs.data.ExamConstants;
import com.thbs.interfaces.Iimages;

public class ImagesDao implements Iimages {

private static final Logger log = LoggerFactory.getLogger(ImagesDao.class);
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public List<ImagesBean> getAllImage(int id) {
		List<ImagesBean> img = jdbcTemplateObject.query(ExamConstants.SELECT_IMAGE_QUERY+id,new ImagesDataMapper());
		return img;
	}

	@Override
	public int insertImage(ImagesBean i) {
		int count = jdbcTemplateObject.update(ExamConstants.INSERT_IMAGE_QUERY,i.getId(),i.getName(),i.getLocation(),i.getPiechart(),i.getProfilepicture(),i.getUploadDate());
		if(count==1){
			log.info("Query to insert data "+ExamConstants.INSERT_IMAGE_QUERY);
			log.info("Successfully inserted data with name "+i.getName());
		return count;
		}
		log.info("Error in Inserting the data for user "+i.getName());
		return count;
	}

	@Override
	public int UpdateImageLocation(String Query, int id) {
		return 0;
	}

}
