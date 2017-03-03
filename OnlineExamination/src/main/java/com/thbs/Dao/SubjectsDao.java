package com.thbs.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.thbs.Beans.SubjectsBean;
import com.thbs.DataMapper.SubjectsDataMapper;
import com.thbs.data.ExamConstants;
import com.thbs.interfaces.Isubjects;

public class SubjectsDao implements Isubjects{
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public int insertSubjects(SubjectsBean s) {
		int count = jdbcTemplateObject.update(ExamConstants.INSERT_SUBJECTS,s.getId(),s.getName());
		return count;
	}

	@Override
	public List<SubjectsBean> getAllSubjects() {
		List<SubjectsBean> sb = jdbcTemplateObject.query(ExamConstants.SELECT_ALL_SUBJECTS,new SubjectsDataMapper());
		return sb;
	}

}
