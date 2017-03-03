package com.thbs.interfaces;

import java.util.List;

import com.thbs.Beans.SubjectsBean;

public interface Isubjects {
	
	public int insertSubjects(SubjectsBean s);
	public List<SubjectsBean> getAllSubjects();

}
