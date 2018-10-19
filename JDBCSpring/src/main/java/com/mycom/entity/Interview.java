package com.mycom.entity;

import java.util.Date;

public class Interview {
	private static final String TABLE_NAME = "interview";
	private static final String ID_COLUMN = "id";
	private static final String FACTDATE_COLUMN = "factDate";
	private static final String PLANDATE_COLUMN = "planDate";
	
	private long id;
	private Date factDate;
	private Date planDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFactDate() {
		return factDate;
	}
	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	
	
}
