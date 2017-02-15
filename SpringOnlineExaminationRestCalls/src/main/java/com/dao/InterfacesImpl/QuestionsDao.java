package com.dao.InterfacesImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.Questions;
import com.dao.interfaces.IQuestions;
import com.datamappers.QuestionsDataMapper;

public class QuestionsDao implements IQuestions{
	String getallquestionsquery = "SELECT * FROM QUESTIONS";
	String insert_questions = "INSERT INTO QUESTIONS(ID,QUESTION,OPTION1,OPTION2,OPTION3,OPTION4,ANSWER,SUBJECT) VALUES (QUESTIONS_ID.NEXTVAL,?,?,?,?,?,?,?)";
	String update_questions = "UPDATE QUESTIONS SET QUESTION = ?,OPTION1 = ?,OPTION2 = ?,OPTION3 = ?,OPTION4 = ?,ANSWER = ?,SUBJECT = ? WHERE ID = ?";
	String delete_questions = "DELETE FROM QUESTIONS WHERE ID = ?";
	int count = 0;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Questions> getAllQuestions() {
		
		List<Questions> questions = jdbcTemplateObject.query(getallquestionsquery,new QuestionsDataMapper());
		return questions;
	}

	@Override
	public int insertQuestions(Questions q) {
		count = jdbcTemplateObject.update(insert_questions,q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer(),q.getSubject());
		return count;
	}

	@Override
	public int updateQuestions(Questions q) {
		count = jdbcTemplateObject.update(update_questions,q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer(),q.getSubject(),q.getId());
		return count;
	}

	@Override
	public int deleteQuestions(Questions q) {
		count = jdbcTemplateObject.update(delete_questions,q.getId());
		return count;
	}
}
