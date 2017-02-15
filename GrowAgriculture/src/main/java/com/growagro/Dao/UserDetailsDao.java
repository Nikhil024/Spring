package com.growagro.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.growagro.Bean.UserDetailsBean;
import com.growagro.DataMapper.UserDetailsDataMapper;
import com.growagro.Interfaces.IuserDetailsData;

public class UserDetailsDao implements IuserDetailsData {
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDao.class);
	String tablename = "USER_DETAILS";
	String insertuserdetails = "INSERT INTO "+tablename+" (ID,COMPANY,USERNAME,EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,ADDRESS,CITY,COUNTRY,POSTAL_CODE,ABOUT_ME) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	String updateuserdetails = "UPDATE "+tablename+" SET COMPANY = ?,EMAIL_ADDRESS = ?,FIRST_NAME = ?,LAST_NAME = ?,ADDRESS = ?,CITY = ?,COUNTRY = ?,POSTAL_CODE = ?,ABOUT_ME = ? WHERE ID = ?";
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public int insertData(UserDetailsBean u) {
		int count = jdbcTemplateObject.update(insertuserdetails,u.getId(),u.getCompany(),u.getUsername(),u.getEmailaddress(),u.getFirstname(),u.getLastname(),u.getAddress(),u.getCity(),u.getCountry(),u.getPostalcode(),u.getAboutme());
		if(count==1) {
			log.info("record has been inserted!!");
			return count;
	}
		return count;
	}

	@Override
	public List<UserDetailsBean> getUserDataDetails(String name) {
		String get_all_user_details_by_name = "SELECT * FROM "+tablename+" WHERE USERNAME = '"+name+"'";
		log.info("getUserDataDetails query : "+get_all_user_details_by_name);
		List<UserDetailsBean> userdetails = jdbcTemplateObject.query(get_all_user_details_by_name,new UserDetailsDataMapper());
		return userdetails;
	}



	@Override
	public int updateData(UserDetailsBean u) {
		int count  = jdbcTemplateObject.update(updateuserdetails,u.getCompany(),u.getEmailaddress(),u.getFirstname(),u.getLastname(),u.getAddress(),u.getCity(),u.getCountry(),u.getPostalcode(),u.getAboutme(),u.getId());
		return count;
	}



	@Override
	public List<UserDetailsBean> getallUserDataDetails(int id) {
		String getalluserdetails = "SELECT * FROM "+tablename;
		log.info("getallUserDataDetails query : "+getalluserdetails);
		List<UserDetailsBean> userdetails = jdbcTemplateObject.query(getalluserdetails,new UserDetailsDataMapper());
		return userdetails;
	}

}
