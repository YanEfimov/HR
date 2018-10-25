package com.mycom.dao;

import java.util.List;

import com.mycom.entity.FeedBack;

public interface FeedBackDao {
	public static String SQL_FINDALL = "select * from "+FeedBack.TABLE_NAME;
	public static String SQL_FINDBYINTERVIEWER = "select * from "+FeedBack.TABLE_NAME+" where "+FeedBack.IDINTERVIEWER_COLUMN+"=?";
	public static String SQL_FINDBYSTATE = "select * from "+FeedBack.TABLE_NAME+" where "+FeedBack.FEEDBACKSTATE_COLUMN+"=?";
	public static String SQL_INSERT = "insert into "+FeedBack.TABLE_NAME+"("+FeedBack.IDINTERVIEW_COLUMN+","+FeedBack.IDINTERVIEWER_COLUMN+""
			+ ","+FeedBack.FEEDBACKSTATE_COLUMN+","+FeedBack.REASON_COLUMN+") values(?,?,?,?)";
	public static String SQL_UPDATE = "update "+FeedBack.TABLE_NAME+" set "+FeedBack.IDINTERVIEW_COLUMN+"=?,"+FeedBack.IDINTERVIEWER_COLUMN+""
			+ "=?,"+FeedBack.FEEDBACKSTATE_COLUMN+"=?,"+FeedBack.REASON_COLUMN+"=? where "+FeedBack.ID_COLUMN+"=?";
	public static String SQL_DELETE = "delete from "+FeedBack.TABLE_NAME+" where "+FeedBack.ID_COLUMN+"=?";
	
	public List<FeedBack> findAll();
	public List<FeedBack> findByInterviewer(long interviewer_id);
	public List<FeedBack> findByState(String feedbackState);
	public void insert(FeedBack feedback);
	public void update(FeedBack feedback);
	public void delete(long feedback_id);
}
