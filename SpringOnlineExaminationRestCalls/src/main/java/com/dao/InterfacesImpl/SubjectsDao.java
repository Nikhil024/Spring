package com.dao.InterfacesImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.Questions;
import com.beans.Subjects;
import com.dao.interfaces.ISubjects;
import com.datamappers.SubjectsDataMapper;

public class SubjectsDao implements ISubjects {
	String getallSubjectssquery = "SELECT * FROM SUBJECTS";
	String subjects_insert = "INSERT INTO SUBJECTS(ID,SUBJECTNAME) VALUES (SUBJECTS_ID.NEXTVAL,?)";
	String subjects_delete = "DELETE FROM SUBJECTS WHERE ID = ?";
	String subjects_update = "UPDATE SUBJECTS SET SUBJECTNAME = ? WHERE ID = ?"; 
	int count = 0;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Subjects> getAllSubjects() {
		
		List<Subjects> subjects = jdbcTemplateObject.query(getallSubjectssquery,new SubjectsDataMapper());
		return subjects;
	}

	@Override
	public int insertSubjects(Subjects s) {
		count = jdbcTemplateObject.update(subjects_insert,s.getSubjectname());
		return count;
	}

	@Override
	public int deleteSubjects(Subjects s) {
		count = jdbcTemplateObject.update(subjects_delete,s.getId());
		return count;
	}

	@Override
	public int updateSubjects(Subjects s) {
		count = jdbcTemplateObject.update(subjects_update,s.getSubjectname(),s.getId());
		return count;
	}

}
