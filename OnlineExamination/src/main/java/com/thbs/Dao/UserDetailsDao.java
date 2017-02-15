package com.thbs.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.thbs.Beans.UserDetailsBean;
import com.thbs.DataMapper.UserDetailsDataMapper;
import com.thbs.data.ExamConstants;
import com.thbs.interfaces.IuserDetails;

public class UserDetailsDao implements IuserDetails {
	
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public List<UserDetailsBean> getAllUserDetails(int id) {
		List<UserDetailsBean> ub = jdbcTemplateObject.query(ExamConstants.SELECT_USER_DETAILS+id,new UserDetailsDataMapper());
		return ub;
	}

	@Override
	public int insertUserDetails(UserDetailsBean ud) {
		int count = jdbcTemplateObject.update(ExamConstants.INSERT_USER_DETAILS,ud.getId(),ud.getName(),ud.getLname(),ud.getEmail(),ud.getAddress(),ud.getCity(),ud.getCountry(),ud.getPostalcode(),ud.getAboutme());
		return count;
	}

	@Override
	public int UpdateUserDetails(String query, int id) {
		int count = jdbcTemplateObject.update(query+id);
		return count;
	}

}
