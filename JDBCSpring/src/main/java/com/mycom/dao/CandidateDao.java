package com.mycom.dao;

import java.util.List;

import com.mycom.entity.Candidate;

public interface CandidateDao {
	public List<Candidate> findAll();
	public void insert(Candidate candidate);
	public void update(Candidate candidate);
	public void delete(long candidate_id);
}
