package com.datamappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.Questions;



public class QuestionsDataMapper implements RowMapper<Questions> {


	public Questions mapRow(ResultSet rs, int rowNum) throws SQLException {
		Questions questions = new Questions();
		questions.setId(rs.getInt("id"));
		questions.setQuestion(rs.getString("question"));
		questions.setOption1(rs.getString("option1"));
		questions.setOption2(rs.getString("option2"));
		questions.setOption3(rs.getString("option3"));
		questions.setOption4(rs.getString("option4"));
		questions.setAnswer(rs.getString("answer"));
		questions.setSubject(rs.getString("subject"));
		return questions;
	}
}
