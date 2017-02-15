package com.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.Questions;
import com.beans.Subjects;



public class SubjectsDataMapper implements RowMapper<Subjects>{
	public Subjects mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subjects subjects = new Subjects();
		subjects.setId(rs.getInt("id"));
		subjects.setSubjectname(rs.getString("subjectname"));
		return subjects;
	}
}
