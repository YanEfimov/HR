package com.mycom.dao;

import java.util.List;

import com.mycom.entity.Interview;

public interface InterviewDao {
	public List<Interview> findAll();
	public void insert(Interview interview);
	public void update(Interview interview);
	public void delete(long interview_id);
	
}
