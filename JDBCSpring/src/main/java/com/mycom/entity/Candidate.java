package com.mycom.entity;

import java.util.Date;

public class Candidate {
	private static final String TABLE_NAME = "candidate";
	private static final String SALARY_COLUMN = "salary";
	private static final String BIRTHDAY_COLUMN = "birthday";
	private static final String SURNAME_COLUMN = "surname";
	private static final String NAME_COLUMN = "name";
	private static final String ID_COLUMN = "id";
	private static final String CANDIDATESTATE_COLUMN = "candidateState";
	
	private long id;
	private double salary;
	private Date birthday;
	private String surname;
	private String name;
	private String candidateState;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCandidateState() {
		return candidateState;
	}
	public void setCandidateState(String candidateState) {
		this.candidateState = candidateState;
	}
	
}
