package com.mycom.dao;

import java.util.List;

import com.mycom.entity.FeedBack;

public interface FeedBackDao {
	public List<FeedBack> findAll();
	public void insert(FeedBack feedback);
	public void update(FeedBack feedback);
	public void delete(long feedback_id);
}
