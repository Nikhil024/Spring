package com.dao.InterfacesImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.User;
import com.dao.interfaces.IUser;
import com.datamappers.UserDataMapper;


public class UserDao implements IUser{
	String getallusersquery = "SELECT * FROM USERS";
	String insert_user = "INSERT INTO USERS(ID,USERNAME,PASSWORD,EMAIL,BIRTHDATE,PROFESSION) VALUES (USERS_ID.NEXTVAL,?,?,?,?,?)";
	String delete_user = "DELETE FROM USERS WHERE ID = ?";
	String update_user = "UPDATE USERS SET USERNAME = ?,PASSWORD = ?,EMAIL = ?,BIRTHDATE = ?,PROFESSION = ? WHERE ID = ?";
	int count = 0;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> user = jdbcTemplateObject.query(getallusersquery,new UserDataMapper());
		return user;
	}

	@Override
	public int insertUsers(User u) {
		count = jdbcTemplateObject.update(insert_user,u.getUsername(),u.getPassword(),u.getEmail(),u.getBirthdate(),u.getProfession());
		return count;
	}

	@Override
	public int updateUsers(User u) {
		count = jdbcTemplateObject.update(update_user,u.getUsername(),u.getPassword(),u.getEmail(),u.getBirthdate(),u.getProfession(),u.getId());
		return count;
	}

	@Override
	public int deleteUsers(User u) {
		count = jdbcTemplateObject.update(delete_user,u.getId());
		return count;
	}
}
