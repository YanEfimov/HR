package com.mycom.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class Candidate {
	public static final String TABLE_NAME = "candidate";
	public static final String SALARY_COLUMN = "salary";
	public static final String BIRTHDAY_COLUMN = "birthday";
	public static final String SURNAME_COLUMN = "surname";
	public static final String NAME_COLUMN = "name";
	public static final String ID_COLUMN = "id";
	public static final String CANDIDATESTATE_COLUMN = "candidateState";
	
	private Long id;
	@DecimalMax("10000.0") @DecimalMin("200") 
	private double salary;
    //@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
	private Date birthday;
    @Size(min=2)
	private String surname;
    @Size(min=2)
	private String name;
	private String candidateState;
	@NotNull
	private List<String> skills;
	
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
