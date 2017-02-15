package com.thbs.Dao;

import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import com.thbs.Beans.UsersBean;
import com.thbs.DataMapper.UserDataMapper;
import com.thbs.data.ExamConstants;
import com.thbs.data.PropertiesfileReading;
import com.thbs.interfaces.Iuser;

public class UsersDao implements Iuser  {
	
	private static final Logger log = LoggerFactory.getLogger(UsersDao.class);
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	

	@Override
	public int insertData(UsersBean u) {
		int count = jdbcTemplateObject.update(ExamConstants.INSERT_USERS_DATA,u.getName(),u.getEmail(),u.getPassword(),u.getUserType(),u.getEmailVerified(),u.getAdminAccepted(),u.getLastLogin());
		if(count==1){
			log.info("Query to insert data "+ExamConstants.INSERT_USERS_DATA);
			log.info("Successfully inserted data with name "+u.getName());
		return count;
		}
		log.info("Error in Inserting the data for user "+u.getName());
		return count;
	}

	@Override
	public List<UsersBean> getUserDetails(String email) {
		log.info("Query of getuserdetails: "+ExamConstants.SELECT_A_USER_DATA+"'"+email+"'");
		List<UsersBean> users = jdbcTemplateObject.query(ExamConstants.SELECT_A_USER_DATA+"'"+email+"'", new UserDataMapper());
		return users;
	}

	
	
	@Override
	public List<UsersBean> getUserDetails(int id) {
		log.info("Query of getuserdetails: "+ExamConstants.SELECT_USER_DATA_BY_ID+id);
		List<UsersBean> users = jdbcTemplateObject.query(ExamConstants.SELECT_USER_DATA_BY_ID+id, new UserDataMapper());
		return users;
	}
	
	@Override
	public List<UsersBean> getallUser() {
		return null;
	}

	@Override
	public int getUserPassword(UsersBean u) {
		return 0;
	}


	@Override
	public int updateUserColumn(String query, int id) {
		int count = jdbcTemplateObject.update(query+id);
		
		return count;
	}

}
