package com.mycom.dao;

import java.util.List;

import com.mycom.entity.CandidateCompetence;
import com.mycom.entity.Skill;

public interface CandidateCompetenceDao {
	public static final String SQL_FINDSKILL = "select "+CandidateCompetence.SKILL_NAME+" from "+CandidateCompetence.TABLE_NAME+""
			+ " where "+CandidateCompetence.IDCANDIDATE+"=?";
	public static final String SQL_INSERT = "insert into "+CandidateCompetence.TABLE_NAME+"("+CandidateCompetence.IDCANDIDATE+","
			+ ""+CandidateCompetence.SKILL_NAME+") values(?,?)";
	public static final String SQL_DELETE = "delete from "+CandidateCompetence.TABLE_NAME+" where "+CandidateCompetence.IDCANDIDATE+"=?";
	
	public List<String> findSkill(long id);
	public void insert(CandidateCompetence candidatecompetence);
	public void delete(long id);
	
}
