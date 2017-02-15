package com.dao.InterfacesImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.beans.ueQuestions;
import com.dao.interfaces.IueQuestions;
import com.datamappers.ueQuestionsDataMapper;

public class ueQuestionsDao implements IueQuestions{
	int count = 0;
	String getallueQuestionsssquery = "SELECT * FROM USERS_EXAM_QUESTIONS";
	String insert_uequestions = "INSERT INTO USERS_EXAM_QUESTIONS(ID,FKUSERID,FKQUESTIONID,SELECTEDANSWER) VALUES (USERS_EXAM_QUESTIONS_ID.NEXTVAL,?,?,?)";
	String update_uequestions = "UPDATE USERS_EXAM_QUESTIONS SET FKUSERID = ?,FKQUESTIONID = ?,SELECTEDANSWER = ? WHERE ID = ?";
	String delete_uequestions = "DELETE FROM USERS_EXAM_QUESTIONS WHERE ID = ?";

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public List<ueQuestions> getAllUsersueQuestions() {
		List<ueQuestions> uequestions = jdbcTemplateObject.query(getallueQuestionsssquery,new ueQuestionsDataMapper());
		return uequestions;
	}



	@Override
	public int insertueQuestions(ueQuestions ueq) {
		count = jdbcTemplateObject.update(insert_uequestions,ueq.getFkuserid(),ueq.getFkquestionid(),ueq.getSelectedanswer());
		return count;
	}



	@Override
	public int updateueQuestions(ueQuestions ueq) {
		count = jdbcTemplateObject.update(update_uequestions,ueq.getFkuserid(),ueq.getFkquestionid(),ueq.getSelectedanswer(),ueq.getId());
		return count;
	}



	@Override
	public int deleteueQuestions(ueQuestions ueq) {
		count = jdbcTemplateObject.update(delete_uequestions,ueq.getId());
		return count;
	}

	
	
	
	
}
