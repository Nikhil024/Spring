package com.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.Subjects;
import com.beans.ueQuestions;



public class ueQuestionsDataMapper implements RowMapper<ueQuestions>{

	public ueQuestions mapRow(ResultSet rs, int rowNum) throws SQLException {
		ueQuestions ueq = new ueQuestions();
		ueq.setId(rs.getInt("ID"));
		ueq.setFkquestionid(rs.getInt("FKQUESTIONID"));
		ueq.setFkuserid(rs.getInt("FKUSERID"));
		ueq.setSelectedanswer(rs.getString("SELECTEDANSWER"));
		return ueq;
	}
}