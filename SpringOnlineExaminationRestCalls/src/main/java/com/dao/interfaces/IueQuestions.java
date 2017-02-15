package com.dao.interfaces;

import java.util.List;

import com.beans.ueQuestions;

public interface IueQuestions {
public List<ueQuestions> getAllUsersueQuestions();
public int insertueQuestions(ueQuestions ueq);
public int updateueQuestions(ueQuestions ueq);
public int deleteueQuestions(ueQuestions ueq);
}
