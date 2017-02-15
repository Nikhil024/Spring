package com.growagro.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.growagro.Bean.UserBean;
import com.growagro.DataMapper.UserDataMapper;
import com.growagro.Interfaces.IuserData;

public class UserDao implements IuserData {
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	String tablename = "USERS";
	private String insertusers = "INSERT INTO "+tablename+" (ID,NAME,PASSWORD,USER_TYPE,CREATED_DATE)VALUES(USERS_ID.NEXTVAL,?,?,?,?)";
	String updatepassword = "UPDATE "+tablename+" SET PASSWORD = ? WHERE NAME = ?";
	String allusers="SELECT * FROM "+tablename;
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	

	
	public int insertData(UserBean u) {
		
		
		int count = jdbcTemplateObject.update(insertusers ,u.getName(),u.getPassword(),u.getUsertype(),u.getCreateddate());
		if(count==1) {
			log.info("record has been inserted!!");
			return count;
	}
		return count;
	}

	
	public List<UserBean> getUserDetails(String name) {
		String selectusers = "SELECT * FROM "+tablename+" WHERE NAME = '"+name+"'";
		List<UserBean> userBean  = jdbcTemplateObject.query(selectusers, new UserDataMapper());
		return userBean;
	}
	
	
	public List<UserBean> getallUser() {
		List<UserBean> userBean  = jdbcTemplateObject.query(allusers, new UserDataMapper());
		return userBean;
	}
	
	
	
	public int getUserPassword(UserBean u){
		int insertsuccess  = jdbcTemplateObject.update(updatepassword,u.getPassword(),u.getName());
		return insertsuccess;
	}
	
	
	/*public List<UserDetailsBean> findUserExistsForLogin(String Email) {
		String IS_USER_EXISTS="SELECT * FROM USERSS WHERE EMAIL ='"+Email+"'";
		LOG.info("Finding if the user is exits in the database using the "+Email+" in the Method findUserExistsForLogin(String Email)");
		List<UserDetailsBean> userDetailsBean  = jdbcTemplateObject.query(IS_USER_EXISTS, new UserDetailsMapper());
		return userDetailsBean;
	}*/
	
	
	
}
