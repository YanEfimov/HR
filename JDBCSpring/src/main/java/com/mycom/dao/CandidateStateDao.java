package com.mycom.dao;

import java.util.List;

import com.mycom.entity.CandidateState;

public interface CandidateStateDao {
	public static final String SQL_FINDALL = "select * from "+CandidateState.TABLE_NAME;
	
	public List<CandidateState> FindAll();
}
