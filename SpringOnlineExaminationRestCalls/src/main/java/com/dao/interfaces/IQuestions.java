package com.dao.interfaces;

import java.util.List;

import com.beans.Questions;

public interface IQuestions {
	public List<Questions> getAllQuestions();
	public int insertQuestions(Questions q);
	public int updateQuestions(Questions q);
	public int deleteQuestions(Questions q);
	
}
