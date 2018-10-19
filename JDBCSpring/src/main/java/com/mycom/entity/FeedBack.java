package com.mycom.entity;

public class FeedBack {
	private static final String TABLE_NAME = "interviewfeedback";
	private static final String REASON_COLUMN = "reason";
	
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
