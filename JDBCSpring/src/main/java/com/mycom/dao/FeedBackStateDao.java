package com.mycom.dao;

import java.util.List;

import com.mycom.entity.FeedBackState;

public interface FeedBackStateDao {
	public static final String SQL_FINDALL = "select * from "+FeedBackState.TABLE_NAME;
	
	public List<FeedBackState> FindAll();
}
