package com.dao.interfaces;

import java.util.List;

import com.beans.Subjects;

public interface ISubjects {
	public List<Subjects> getAllSubjects();
	public int insertSubjects(Subjects s);
	public int deleteSubjects(Subjects s);
	public int updateSubjects(Subjects s);
}
